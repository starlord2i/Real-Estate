package com.keane.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ParamMapper;
import com.keane.training.domain.Site;

public class SiteDAO {
	static Logger log = Logger.getLogger(SiteDAO.class);
	public int insertSite(final Site site) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, site.getUid());
				pStmt.setString(2, site.getType());
				pStmt.setString(3, site.getLocation());
				pStmt.setDouble(4, site.getAmount());
				pStmt.setString(5, site.getPurpose());
				pStmt.setString(6, site.getAvail());
				
			}
		};
		  		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.INSERTSITE, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	public int getSiteId(final String location, final double amount ) throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setString(1,location);
					pStmt.setDouble(2,amount);
				}
			};
			res = DBHelper.executeSelect(con, SqlMapper.GETSIDEID,
					paramMapper, SqlMapper.MAP_SITEID);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		int id=0;
		Iterator itr = res.iterator();
		while(itr.hasNext())
		{
			Site s = (Site) itr.next();
			id = s.getSid();
		}
		return id;
		

	}
	public List getSite(final String choice, final String loc, final int minimum, final int maximum, final String pupor) throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setString(1,choice);
					pStmt.setString(2,loc);
					pStmt.setInt(3,minimum);
					pStmt.setInt(4,maximum);
					pStmt.setString(5,pupor);
				}
			};

			res = DBHelper.executeSelect(con, SqlMapper.FETCHSITE,
					paramMapper, SqlMapper.MAP_SITE);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;

	}
	
	public int getAvailability(final int id) throws DAOAppException {
		List res = null;
		int result=0;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setInt(1, id);
				}
			};
			res = DBHelper.executeSelect(con, SqlMapper.AVAILSITE,
					paramMapper, SqlMapper.MAP_SITE);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		if(!(res.isEmpty()))
		{
			result=1;
		}
		else
		{
			result=0;
		}
		return result;

	}
	public int updateAvailabiliy(final int sid) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, sid);
				
			}
		};
		  		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.UPDATEAVAIL, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	public Boolean deleteSite() throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
		
				
			}
		};
		  		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.DELETESITE, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		if(res!=0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
