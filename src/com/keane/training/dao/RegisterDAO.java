package com.keane.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.keane.dbcon.ConnectionHolder;
import com.keane.dbcon.DBConnectionException;
import com.keane.dbfw.DBFWException;
import com.keane.dbfw.DBHelper;
import com.keane.dbfw.ParamMapper;
import com.keane.training.domain.User;

public class RegisterDAO {
	public int registerBUser(final User user) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		int id=1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, id);
				pStmt.setString(2, user.getName());
				pStmt.setString(3, user.getEmail());
				pStmt.setString(4, user.getPassword());
				pStmt.setLong(5, user.getContact());
				pStmt.setString(6, user.getRolename());
			}
		};
		  		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.INSERTUSER, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	public int registerSUser(final User user) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, 2);
				pStmt.setString(2, user.getName());
				pStmt.setString(3, user.getEmail());
				pStmt.setString(4, user.getPassword());
				pStmt.setLong(5, user.getContact());
				pStmt.setString(6, user.getRolename());
			}
		};
		  		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.INSERTUSER, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	public int registerAUser(final User user) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, 3);
				pStmt.setString(2, user.getName());
				pStmt.setString(3, user.getEmail());
				pStmt.setString(4, user.getPassword());
				pStmt.setLong(5, user.getContact());
				pStmt.setString(6, user.getRolename());
			}
		};
		  		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.INSERTUSER, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}

	public boolean validateUser(final String email, final String password) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		List users = null;

		ParamMapper paramMapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, email);
				pStmt.setString(2, password);

				
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			users = DBHelper.executeSelect(con, SqlMapper.VERIFYUSER,
					paramMapper, SqlMapper.MAP_USER);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}

		return (users != null && users.size() > 0);

	}
}
