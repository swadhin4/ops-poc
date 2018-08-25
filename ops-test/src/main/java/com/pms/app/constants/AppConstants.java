package com.pms.app.constants;

public class AppConstants {

	public static final String PASSWORD_RESET_LINK="/forgot/app/password/reset/link/{token}";
	
	public static String email="";
	
	public static final String ASSET_REPAIRTYPE_QUERY = "select subcategory1_id, asset_subcategory1 from pm_asset_subcategory1 where "
			+ " asset_category_id = ? order by asset_subcategory1";
	
	public static final String ASSET_SUBREPAIRTYPE_QUERY = "select subcategory2_id, subcategory2_name from pm_asset_subcategory2 where "
			+ " subcategory1_id = ? order by subcategory2_name";
	
	public static final String ASSET_SUBCATEGORY_DETAILS_QUERY = "SELECT a.asset_id, ac.category_id,ac.category_name,asc1.subcategory1_id,asc1.asset_subcategory1 "
			+ " FROM pm_asset a " 
			+ " LEFT JOIN pm_asset_category ac ON a.category_id = ac.category_id "
			+ " LEFT JOIN pm_asset_subcategory1 asc1 ON asc1.subcategory1_id = a.subcategory1_id "
			+ " WHERE a.category_id = ? AND a.subcategory1_id = ?  and a.asset_id=? ";
	
	public static final String USER_ROLE_QUERY ="select u.user_id, u.first_name, u.last_name, u.email_id, u.password,u.enabled, "
			+ " r.role_id, r.role_name, r.role_desc, u.sys_password from pm_users u "
    		+ " inner join pm_user_role ur  INNER join pm_role r where ur.role_id=r.role_id "
    		+ " and u.user_id=ur.user_id and u.email_id = ?";
	
	public static final String USER_SITE_ACCESS_QUERY="select ps.site_id, ps.site_name, ps.district_id, pd.district_name, "
			+ " ps.area_id, pa.area_name, ps.cluster_id, pc.cluster_name, ps.site_owner,ps.brand_id, ps.brand_name "
			+ " from pm_site ps inner join pm_district pd on pd.district_id=ps.district_id "
			+ " inner join pm_area pa on pa.area_id = ps.area_id inner join pm_cluster pc on pc.cluster_id = ps.cluster_id "
			+ " inner join pm_user_access pua on pua.site_id=ps.site_id inner join "
			+ " pm_users pu on pu.user_id = pua.user_id and pu.email_id = ?";
}
