package com.pms.web.service;

import java.util.List;

import com.pms.app.view.vo.CreateSiteVO;
import com.pms.app.view.vo.LoginUser;


public interface SiteService {

	public List<CreateSiteVO> getSiteList(LoginUser user) throws Exception;
	

	public CreateSiteVO saveSite(CreateSiteVO siteVO, LoginUser user) throws Exception;



}
