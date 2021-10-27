package com.keane.training.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.keane.dbfw.ResultMapper;
import com.keane.training.domain.Booking;
import com.keane.training.domain.Site;
import com.keane.training.domain.User;

public class SqlMapper {

	public static final String BUYERUSER = "Select * from user where email=? AND password_r=? And role_name='Buyer' ";
	public static final String SELLERUSER = "Select * from user where email=? AND password_r=? AND role_name='Seller' ";
	public static final String ADMINUSER = "Select * from user where email=? AND password_r=? AND role_name='Admin'";
	public static final String VERIFYUSER= "Select * from user where email=? AND password_r=?";
	public static final String INSERTUSER="insert into user(role_id, name, email, password_r, Phone_NO, role_name) values(?,?,?,?,?,?)";
	public static final String INSERTSITE = "insert into site(user_id,prop_type,location,amount,purpose,availability) values(?,?,?,?,?,?)";
	public static final String GETSIDEID = "Select site_id from site where location=? AND amount=? ";
	public static final String FETCHSITE="select * from site where prop_type= ? and location= ? and amount between ? and ? and purpose= ?";
	public static final String AVAILSITE="select * from site where availability = 'yes' and site_id=?";
	public static final String VERIFYUSER1 = "Select * from user where user_id = ? AND name = ? ";
	public static final String INSERTBOOKING="insert into booking(user_id,site_id,intrested,Date_of_book,card_no,buyer_name) values(?,?,?,?,?,?)";
	public static final String FETCHBUYERS= "select * from user where user_id in (Select user_id from booking where intrested='yes' and site_id= ?)";
	public static final String UPDATEAVAIL = "Update site set availability='No' where site_id=? ";
	public static final String UPDATEBOOKSNAME = "Update booking set sellar_name = ? where site_id = ? ";
	public static final String FETCHBOOKINGDETAILS = "Select * from booking where site_id = ? ";
	public static final String DELETESITE = "Delete from site where availability='No' ";

	
	public static final ResultMapper MAP_USER = new ResultMapper() {
	
		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			User user = new User();
			user.setPassword(rs.getString("password_r"));
			user.setEmail(rs.getString("email"));
			user.setId(rs.getInt("user_id"));
			user.setName(rs.getString("name"));
			return user;
			
		}
	};
	public static final ResultMapper MAP_SITE = new ResultMapper() {
		
		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			int sid = rs.getInt(1);
			String type= rs.getString(3);
			String loc21 = rs.getString(4);
			int max = rs.getInt(5);
			String pup = rs.getString(6);
			Site s=new Site(sid,type,loc21,max,pup);
				return s;
			}
			
		};
	public static final ResultMapper MAP_SITEID = new ResultMapper() {
		
		@Override
		public Object mapRows(ResultSet rs) throws SQLException {
			Site site = new Site();
			site.setSid(rs.getInt("site_id"));
			return site;
		}
	};
	public static final ResultMapper USERMAPPER=
			new ResultMapper()
		{
			@Override
			public Object mapRows(ResultSet rs) throws SQLException {
			int id = rs.getInt(2);
			String name = rs.getString(3);
			String email = rs.getString(4);
			String pass = rs.getString(5);
			User u = new User(id, name, email, pass);
			return u;
			}//mapRow
			
		};
		public static final ResultMapper ROLEMAPPER=
				new ResultMapper()
			{
				@Override
				public Object mapRows(ResultSet rs) throws SQLException {
				int id= rs.getInt(2);
				String name = rs.getString(3);
				String email = rs.getString(4);
				long phno = rs.getLong(6);
				
				User u = new User(id, name, email, phno);
					return u;
				}//mapRow
				
			};
			
			public static final ResultMapper USERBOOKINGMAPPER=
					new ResultMapper()
				{
					@Override
					public Object mapRows(ResultSet rs) throws SQLException {
					String sname = rs.getString(6);
					String bname = rs.getString(7);
					Booking b = new Booking(sname, bname);
					return b;
					}//mapRow
					
				};
	/*
	 * pStmt.setInt(1, user.getPortalID());
				pStmt.setString(2, user.getName());
				pStmt.setInt(3, user.getEmployeeId());
				pStmt.setString(4, user.getTechnology());
				pStmt.setString(5, user.getPassword());
	 * 
	 */

	public static final String ADD_USER = "insert into user_info values(?,?,?,?,?)";

}
/*
<Context docBase="FrontControllerApp" path="/FrontControllerApp" reloadable="true" source="org.eclipse.jst.jee.server:FrontControllerApp">
			<Resource name="jdbc/MyDB"
			auth="container"
			driverClassName="oracle.jdbc.driver.OracleDriver"
			url="jdbc:oracle:thin:@localhost:1521:XE"
			username="TRDB"
			password="TRDB"
			maxActive="20"
			maxIdle="10"
			maxWait="-1"
			/>
			</Context>
*/