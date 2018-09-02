/*
 * Copyright (C) 2013 , Inc. All rights reserved
 */
package com.pms.app.controller;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pms.app.view.vo.CreateSiteVO;
import com.pms.app.view.vo.DistrictVO;
import com.pms.app.view.vo.LoginUser;
import com.pms.jpa.entities.Area;
import com.pms.jpa.entities.Cluster;
import com.pms.web.service.DistrictService;
import com.pms.web.service.SiteService;
import com.pms.web.util.RestResponse;

/**
 * The Class UserController.
 *
 */
@RequestMapping(value = "/site")
@Controller
public class SiteController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(SiteController.class);
	
	@Autowired
	private SiteService siteService;
	
	@Autowired
	private DistrictService districtService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET, produces = "application/json")
	public String userHome(final Locale locale, final ModelMap model,
			final HttpServletRequest request, final HttpSession session) {
		LoginUser loginUser=getCurrentLoggedinUser(session);
		if (loginUser!=null) {
			boolean isSessionEnabled=request.isRequestedSessionIdValid();
			System.out.println(isSessionEnabled +""+ request.getSession().getId());
			model.put("user", loginUser);
			model.put("sessionId", request.getSession().getId());
			return "site.list";
		} else {
			return "redirect:/login";
		}
	}
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public String userDetails(final Locale locale, final ModelMap model,final HttpServletRequest request, final HttpSession session) {
		String redirectUrl="";
			LoginUser loginUser = getCurrentLoggedinUser(session);
			if (loginUser!=null) {
				model.put("user", loginUser);
				if(loginUser.getSysPassword().equalsIgnoreCase("YES")){
					redirectUrl = "redirect:/user/profile";
				}else{
					model.put("sessionId", request.getSession().getId());
					redirectUrl =  "site.details";
				}
			} else {
				redirectUrl =  "redirect:/login";
			}
		return redirectUrl;
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<List<CreateSiteVO>> listAllSites(HttpSession session) {
		logger.info("Inside TestController -- ListAllSites");
		List<CreateSiteVO> sitesList = null;
		try {
			LoginUser user= getCurrentLoggedinUser(session);
			if(user!=null){
				//SiteServiceImpl siteService = new SiteServiceImpl();
				sitesList = siteService.getSiteList(user);
				if (sitesList.isEmpty()) {
					return new ResponseEntity(HttpStatus.NO_CONTENT);
					// You many decide to return HttpStatus.NOT_FOUND
				}else{
					Collections.sort(sitesList, CreateSiteVO.COMPARE_BY_SITENAME);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("Exit TestController -- ListAllSites");
		return new ResponseEntity<List<CreateSiteVO>>(sitesList, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<RestResponse> createNewSite(final Locale locale, final ModelMap model,
			@RequestBody final CreateSiteVO createSiteVO, final HttpSession session) {
		logger.info("Inside SiteController .. createNewSite");
		RestResponse response = new RestResponse();
		ResponseEntity<RestResponse> responseEntity = new ResponseEntity<RestResponse>(HttpStatus.NO_CONTENT);
		LoginUser loginUser = getCurrentLoggedinUser(session);

		CreateSiteVO savedSiteVO = null;
		if(loginUser!=null){
			try {
				logger.info("CreateSiteVO : "+ createSiteVO);
				savedSiteVO= siteService.saveSite(createSiteVO, loginUser);
				if(savedSiteVO.getSiteId()==null){
					response.setStatusCode(204);
					response.setMessage("Please verify the required fields");
					responseEntity = new ResponseEntity<RestResponse>(response,HttpStatus.NOT_FOUND);
				}
				else if(savedSiteVO.getSiteId() != null){
					if(savedSiteVO.getStatus()==201){
						response.setStatusCode(200);
						response.setObject(savedSiteVO);
						response.setMessage("New site created successfully");
						responseEntity = new ResponseEntity<RestResponse>(response,HttpStatus.OK);
					}else{
						response.setStatusCode(200);
						response.setObject(savedSiteVO);
						response.setMessage("Site updated successfully");
						responseEntity = new ResponseEntity<RestResponse>(response,HttpStatus.OK);
					}
				}

			} catch (Exception e) {
				logger.info("Exception occured while saving or updating site", e);
				response.setMessage("Exception occured while saving or updating site");
				response.setStatusCode(500);
				responseEntity = new ResponseEntity<RestResponse>(response,HttpStatus.NOT_FOUND);

			}
		}

		logger.info("Exit SiteController .. createNewSite");
		return responseEntity;
	}
	
	@RequestMapping(value = "/district/api/country/{countryId}", method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<RestResponse> listAllDistricts(@PathVariable(value="countryId") final Long countryId, final HttpSession session) {
		logger.info("Inside DistrictController .. listAllDistricts");
		List<DistrictVO> districtList = null;
		RestResponse response = new RestResponse();
		ResponseEntity<RestResponse> responseEntity = new ResponseEntity<RestResponse>(HttpStatus.NO_CONTENT);
		LoginUser loginUser = getCurrentLoggedinUser(session);
		if(loginUser!=null){
			try {
				districtList = districtService.findDistrictByCountry(countryId, loginUser);
				if(!districtList.isEmpty()){				
					response.setStatusCode(200);
					response.setObject(districtList);
					responseEntity = new ResponseEntity<RestResponse>(response, HttpStatus.OK);
				}else{
					response.setStatusCode(404);
					response.setMessage("No district found");
					responseEntity = new ResponseEntity<RestResponse>(response, HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				response.setStatusCode(505);
				response.setMessage("Exception in getting response");
				responseEntity = new ResponseEntity<RestResponse>(response, HttpStatus.NOT_FOUND);
				logger.info("Exception in getting response", e);

			}
		}

		logger.info("Exit DistrictController .. listAllDistricts");
		return responseEntity;
	}
	
	@RequestMapping(value = "/v1/area/{districtId}", method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<RestResponse> listAllAreas(@PathVariable(value="districtId") final Long districtId, final HttpSession session) {
		logger.info("Inside DistrictController .. listAllAreas");
		RestResponse response = new RestResponse();
		ResponseEntity<RestResponse> responseEntity = new ResponseEntity<RestResponse>(HttpStatus.NO_CONTENT);
		LoginUser loginUser = getCurrentLoggedinUser(session);
		if(loginUser!=null){
		try {
			List<Area> areaList = districtService.findAreaByDistrict(districtId, loginUser);
			if(!areaList.isEmpty()){				
				response.setStatusCode(200);
				response.setObject(areaList);
				responseEntity = new ResponseEntity<RestResponse>(response, HttpStatus.OK);
			}else{
				response.setStatusCode(404);
				response.setMessage("No Areas found");
				responseEntity = new ResponseEntity<RestResponse>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		logger.info("Exit DistrictController .. listAllAreas");
		return responseEntity;
	}
	
	@RequestMapping(value = "/v1/cluster/{districtId}/{areaId}", method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<RestResponse> listAllCluster(@PathVariable(value="districtId") final Long districtId,
			@PathVariable(value="areaId") final Long areaId, final HttpSession session) {
		logger.info("Inside DistrictController .. listAllCluster");
		RestResponse response = new RestResponse();
		ResponseEntity<RestResponse> responseEntity = new ResponseEntity<RestResponse>(HttpStatus.NO_CONTENT);
		LoginUser loginUser = getCurrentLoggedinUser(session);
		if(loginUser!=null){
		try {
			List<Cluster> clusters = districtService.findClusterByArea(districtId,areaId, loginUser);
			if(!clusters.isEmpty()){				
				response.setStatusCode(200);
				response.setObject(clusters);
				responseEntity = new ResponseEntity<RestResponse>(response, HttpStatus.OK);
			}else{
				response.setStatusCode(404);
				response.setMessage("No Clusters found");
				responseEntity = new ResponseEntity<RestResponse>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		logger.info("Exit DistrictController .. listAllCluster");
		return responseEntity;
	}
	
}
