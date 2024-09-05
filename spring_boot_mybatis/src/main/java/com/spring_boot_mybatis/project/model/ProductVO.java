package com.spring_boot_mybatis.project.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ProductVO {
	private String prdNo;
	private String prdName;
	private int prdPrice;
	private String prdCompany;
	private int prdStock;
    @DateTimeFormat(pattern="yyyy-MM-dd")
//	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date prdDate;
	
	public String getPrdNo() {
		return prdNo;
	}
	public void setPrdNo(String prdNo) {
		this.prdNo = prdNo;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public int getPrdPrice() {
		return prdPrice;
	}
	public void setPrdPrice(int prdPrice) {
		this.prdPrice = prdPrice;
	}
	public String getPrdCompany() {
		return prdCompany;
	}
	public void setPrdCompany(String prdCompany) {
		this.prdCompany = prdCompany;
	}
	public int getPrdStock() {
		return prdStock;
	}
	public void setPrdStock(int prdStock) {
		this.prdStock = prdStock;
	}
	public Date getPrdDate() {
		return prdDate;
	}
	public void setPrdDate(Date prdDate) {
		this.prdDate = prdDate;
	}
	
	
}
