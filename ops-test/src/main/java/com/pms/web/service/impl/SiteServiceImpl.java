package com.pms.web.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pms.app.dao.impl.SiteDAO;
import com.pms.app.view.vo.CreateSiteVO;
import com.pms.app.view.vo.LoginUser;
import com.pms.web.service.SiteService;



@Service("siteService")
public class SiteServiceImpl implements SiteService{

	private final static Logger LOGGER = LoggerFactory.getLogger(SiteServiceImpl.class);
	private static final String SUFFIX = "/";
	
	private SiteDAO getSiteDAO(String dbName) {
		return new SiteDAO(dbName);
	}
	
	public SiteServiceImpl() {
		super();
	}
	

	@Override
	public List<CreateSiteVO> getSiteList(LoginUser user) throws Exception {
		SiteDAO siteDAO=getSiteDAO(user.getDbName());
		List<CreateSiteVO> siteList = siteDAO.getSiteList(user.getUsername());
		return siteList;
	}

	@Override
	@Transactional
	public CreateSiteVO saveSite(CreateSiteVO siteVO, LoginUser user) throws Exception {
		SiteDAO siteDAO=getSiteDAO(user.getDbName());
		CreateSiteVO savedSiteVO = siteDAO.saveSite(siteVO, user.getDbName());
		return savedSiteVO;
		
	}

}
