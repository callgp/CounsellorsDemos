package com.example.demo.dto;

public class DashboardResponse {

	private Integer totalEnqs;
	private Integer enrolledEnqs;
	private Integer openEnqs;
	private Integer lostEnqs;
	public Integer getTotalEnqs() {
		return totalEnqs;
	}
	public Integer getEnrolledEnqs() {
		return enrolledEnqs;
	}
	public void setEnrolledEnqs(Integer enrolledEnqs) {
		this.enrolledEnqs = enrolledEnqs;
	}
	public Integer getOpenEnqs() {
		return openEnqs;
	}
	public void setOpenEnqs(Integer openEnqs) {
		this.openEnqs = openEnqs;
	}
	public Integer getLostEnqs() {
		return lostEnqs;
	}
	public void setLostEnqs(Integer lostEnqs) {
		this.lostEnqs = lostEnqs;
	}
	public void setTotalEnqs(Integer totalEnqs) {
		this.totalEnqs = totalEnqs;
	}

	
}
