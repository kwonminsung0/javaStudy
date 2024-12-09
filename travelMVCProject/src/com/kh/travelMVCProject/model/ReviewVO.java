package com.kh.travelMVCProject.model;

public class ReviewVO {
	private int no;
	private String reservId;
	private int guideReview;
	private int scheReview;
	private double avgReview;
	
	public ReviewVO() {}
	
	public ReviewVO(int guideReview, int scheReview) {
		super();
		this.guideReview = guideReview;
		this.scheReview = scheReview;
	}
	public ReviewVO(String reservId, int guideReview, int scheReview) {
		super();
		this.reservId = reservId;
		this.guideReview = guideReview;
		this.scheReview = scheReview;
	}
	public ReviewVO(int no, String reservId, int guideReview, int scheReview, double avgReview) {
		super();
		this.no = no;
		this.reservId = reservId;
		this.guideReview = guideReview;
		this.scheReview = scheReview;
		this.avgReview = avgReview;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getReservId() {
		return reservId;
	}
	public void setReservId(String reservId) {
		this.reservId = reservId;
	}
	public int getGuideReview() {
		return guideReview;
	}
	public void setGuideReview(int guideReview) {
		this.guideReview = guideReview;
	}
	public int getScheReview() {
		return scheReview;
	}
	public void setScheReview(int scheReview) {
		this.scheReview = scheReview;
	}
	public double getAvgReview() {
		return avgReview;
	}
	public void setAvgReview(double avgReview) {
		this.avgReview = avgReview;
	}

	@Override
	public String toString() {
	    return String.format(
    	        "%-7s %-14s %-9s %-7s %-10s\n",
	        no, reservId, guideReview, scheReview, avgReview
	    );
	}
}
