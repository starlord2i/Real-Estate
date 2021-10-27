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
import com.keane.training.domain.Booking;
import com.keane.training.domain.Site;

public class BookingDAO {
	static Logger log = Logger.getLogger(BookingDAO.class);
	
	public int insertBook(final Booking b)throws DAOAppException {
		int res = 0;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setInt(1, b.getUser_id());
					pStmt.setInt(2, b.getSite_id());
					pStmt.setString(3, b.getIntrest());
					pStmt.setString(4, b.getBooking_date());
					pStmt.setLong(5, b.getCard_no());
					pStmt.setString(6, b.getB_name());
				}
			};
			res = DBHelper.executeUpdate(con, SqlMapper.INSERTBOOKING, paramMapper);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		
		return res;
		

	}
	public int updateName(final int sid,final String name) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		ParamMapper mapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, name);
				pStmt.setInt(2, sid);
				
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.UPDATEBOOKSNAME, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}
	public List getDetails(final int id) throws DAOAppException {
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

			res = DBHelper.executeSelect(con, SqlMapper.FETCHBOOKINGDETAILS,
					paramMapper, SqlMapper.USERBOOKINGMAPPER);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;

	}

}
