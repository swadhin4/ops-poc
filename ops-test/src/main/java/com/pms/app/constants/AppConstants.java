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
			+ " r.role_id, r.role_name, r.role_desc, u.sys_password, pc.company_id, pc.company_name "
			+ " from pm_users u inner join pm_user_role ur  INNER join pm_role r on ur.role_id=r.role_id "
			+ " inner  join pm_company pc where u.company_id=pc.company_id and u.user_id=ur.user_id and u.email_id = ?";
	
	public static final String USER_SITE_ACCESS_QUERY="select ps.site_id, ps.site_name, ps.district_id, pd.district_name,"
			+ " ps.area_id, pa.area_name, ps.cluster_id, pc.cluster_name, pu.company_id,pcomp.company_name, "
			+ " pcon.country_id, pcon.country_name, ps.site_owner,ps.brand_id, ps.brand_name  from pm_site ps "
			+ " left join pm_district pd on pd.district_id=ps.district_id left join pm_area pa on pa.area_id = ps.area_id "
			+ " left join pm_cluster pc on pc.cluster_id = ps.cluster_id left join pm_country pcon on pcon.country_id = pd.country_id "
			+ " inner join pm_user_access pua on pua.site_id=ps.site_id inner join pm_users pu on pu.user_id = pua.user_id "
			+ " left join pm_company pcomp on pcomp.company_id = pu.company_id WHERE pu.email_id = ?";
	
	public static final String USER_DISTRICT_QUERY = "SELECT dist.district_id,dist.district_name from pm_district dist "
			+ " INNER JOIN pm_company com ON com.country_id = dist.country_id WHERE com.company_id=?";
	
	public static final String USER_AREA_QUERY = "SELECT ar.area_id, ar.area_name from pm_area ar "
			+ " INNER JOIN pm_district dist ON dist.district_id = ar.dist_id WHERE ar.dist_id=?";
	
	public static final String USER_CLUSTER_QUERY = "SELECT cl.cluster_id,cl.cluster_name FROM pm_cluster cl "
			+ " INNER JOIN pm_area ar ON ar.area_id = cl.area_id WHERE cl.district_id=? and ar.area_id = ?";

}
