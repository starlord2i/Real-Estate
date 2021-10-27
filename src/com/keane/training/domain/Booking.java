package com.keane.training.domain;

public class Booking {
	
	private int user_id;
	private int site_id;
	private String intrest;
	private String booking_date;
	private long card_no;
	private String s_name;
	private String b_name;
	public Booking(String s_name, String b_name) {
		super();
		this.s_name = s_name;
		this.b_name = b_name;
	}
	public Booking() {
		super();
	}
	public Booking(int user_id, int site_id, String intrest, String booking_date, long card_no, String b_name) {
		super();
		this.user_id = user_id;
		this.site_id = site_id;
		this.intrest = intrest;
		this.booking_date = booking_date;
		this.card_no = card_no;
		this.b_name = b_name;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getSite_id() {
		return site_id;
	}
	public void setSite_id(int site_id) {
		this.site_id = site_id;
	}
	public String getIntrest() {
		return intrest;
	}
	public void setIntrest(String intrest) {
		this.intrest = intrest;
	}
	public String getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}
	public long getCard_no() {
		return card_no;
	}
	public void setCard_no(long card_no) {
		this.card_no = card_no;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	

}
