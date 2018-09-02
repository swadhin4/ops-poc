package com.pms.app.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
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
					siteVO.setCountryId(rs.getLong("country_id"));
					siteVO.setCountryName(rs.getString("country_name"));
					siteVO.setCompanyId(rs.getLong("company_id"));
					siteVO.setCompanyName(rs.getString("company_name"));
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
	
	public CreateSiteVO saveSite(CreateSiteVO siteVO, String userDB){
		JdbcTemplate jdbcTemplate = new JdbcTemplate(ConnectionManager.getTenantDataSource());
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("uspInsertSiteDetails");
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("siteName", siteVO.getSiteName());
		map.addValue("siteOwner", siteVO.getOwner());
		map.addValue("operatorId", siteVO.getCompanyId());
		map.addValue("districtId", siteVO.getDistrictId());
		map.addValue("areaId", siteVO.getAreaId());
		map.addValue("clusterId", siteVO.getClusterId());
		map.addValue("elecId", siteVO.getElectricityId());
		map.addValue("siteNumber1", Long.parseLong(siteVO.getSiteNumber1()));
		map.addValue("siteNumber2", StringUtils.isEmpty(siteVO.getSiteNumber2())==true?null:Long.parseLong(siteVO.getSiteNumber2()));
		map.addValue("attachmentPath", siteVO.getSiteAttachments().isEmpty()==true?null:siteVO.getSiteAttachments().get(0));
		map.addValue("salesArea", siteVO.getSalesAreaSize());
		map.addValue("brandId", siteVO.getBrandId());
		map.addValue("brandName", siteVO.getBrandName());
		map.addValue("siteContactName", siteVO.getContactName());
		map.addValue("siteEmail", siteVO.getEmail());
		map.addValue("siteLat", siteVO.getLatitude());
		map.addValue("siteLong", siteVO.getLongitude());
		map.addValue("pContactNumber", StringUtils.isEmpty(siteVO.getPrimaryContact())==true?null:Long.parseLong(siteVO.getPrimaryContact()));
		map.addValue("sContactNumber",  StringUtils.isEmpty(siteVO.getSecondaryContact())==true?null:Long.parseLong(siteVO.getSecondaryContact()));
		map.addValue("addressLine1", siteVO.getSiteAddress1());
		map.addValue("addressLine2", siteVO.getSiteAddress2());
		map.addValue("addressLine3", siteVO.getSiteAddress3());
		map.addValue("addressLine4", siteVO.getSiteAddress4());
		map.addValue("zipCode", siteVO.getZipCode());
		map.addValue("dbName", userDB);
		map.addValue("createdBy", siteVO.getCreatedBy());
		map.addValue("siteId", "@siteId");
		map.addValue("isError", "@isError");
		SqlParameterSource in1 = map;
		Map out = jdbcCall.execute(in1);
		System.out.println(out);
		return siteVO;

	}
	
}
