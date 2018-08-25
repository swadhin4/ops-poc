package com.pms.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.pms.app.config.ConnectionManager;
import com.pms.app.constants.AppConstants;
import com.pms.app.view.vo.CreateSiteVO;

@Repository
public class SiteDAO {
	
	public SiteDAO(String userConfig) {
		ConnectionManager.getInstance(userConfig);
	}
	
	public List<CreateSiteVO> getSiteList(String username){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ConnectionManager.getDataSource());
		List<CreateSiteVO> siteList =  jdbcTemplate.query(AppConstants.USER_SITE_ACCESS_QUERY, new Object[]{username}, new ResultSetExtractor<List<CreateSiteVO>>() {
			@Override
			public List<CreateSiteVO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<CreateSiteVO> siteList = new ArrayList<CreateSiteVO>();
				while (rs.next()) {
					CreateSiteVO siteVO = new CreateSiteVO();
					siteVO.setSiteId(rs.getLong("site_id"));
					siteVO.setSiteName(rs.getString("site_name"));
					siteVO.setDistrictId(rs.getLong("district_id"));
					siteVO.setDistrictName(rs.getString("district_name"));
					siteVO.setAreaId(rs.getLong("area_id"));
					siteVO.setAreaName(rs.getString("area_name"));
					siteVO.setClusterId(rs.getLong("cluster_id"));
					siteVO.setClusterName(rs.getString("cluster_name"));
					siteVO.setSiteOwner(rs.getString("site_owner"));
					siteVO.setBrandId(rs.getLong("brand_id"));
					siteVO.setBrandName(rs.getString("brand_name"));
					siteList.add(siteVO);
                }
				System.out.println("Site List : " + siteList.size());
				return siteList;
			}
		});
		return siteList==null?Collections.EMPTY_LIST:siteList;
	}
}
