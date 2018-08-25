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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pms.app.view.vo.CreateSiteVO;
import com.pms.app.view.vo.LoginUser;
import com.pms.web.service.SiteService;
import com.pms.web.service.impl.SiteServiceImpl;

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

	
}
