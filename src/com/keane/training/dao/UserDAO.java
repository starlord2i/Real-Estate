package com.keane.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ParamMapper;

public class UserDAO {
	static Logger log = Logger.getLogger(UserDAO.class);
	public int getUser(final int id,final String name) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		List user =null;
		int res = 0;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, id);
				pStmt.setString(2, name);
				
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			user = DBHelper.executeSelect(con, SqlMapper.VERIFYUSER1,
					mapper, SqlMapper.USERMAPPER);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		 if(user.isEmpty())
		 {
			 res=0;
		 }
		 else
		 {
			 res=1;
		 }
		return res;
	}
	
	public List getBuyers(final int id) throws DAOAppException {
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
					pStmt.setInt(1, id);	
				}
			};

			res = DBHelper.executeSelect(con, SqlMapper.FETCHBUYERS,
					paramMapper, SqlMapper.ROLEMAPPER);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;

	}
	
	
}
