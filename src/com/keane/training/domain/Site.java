package com.keane.training.domain;

public class Site {
	
	private int sid;
	private int uid;
	private String type;
	private String location;
	private double amount;
	private String purpose;
	private String avail;
	@Override
	public String toString() {
		return "Site [sid=" + sid + ", uid=" + uid + ", type=" + type + ", location=" + location + ", amount=" + amount
				+ ", purpose=" + purpose + ", avail=" + avail + ", max=" + max + ", min=" + min + "]";
	}
	private int max;
	private int min;
	public Site(String type, String location, String purpose, int max, int min) {
		this.type = type;
		this.location = location;
		this.purpose = purpose;
		this.max = max;
		this.min = min;
	}
	public Site(int sid, String stype, String slocation, double samount, String purpose) {
		this.sid = sid;
		this.type = stype;
		this.location = slocation;
		this.amount = samount;
		this.purpose = purpose;
	}

	public Site()
	{
		
	}
	public Site(int uid, String type, String location, double amount, String purpose, String avail) {
		this.uid = uid;
		this.type = type;
		this.location = location;
		this.amount = amount;
		this.purpose = purpose;
		this.avail = avail;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getAvail() {
		return avail;
	}
	public void setAvail(String avail) {
		this.avail = avail;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	

}
