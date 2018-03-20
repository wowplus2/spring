package com.javalec.spring_pjt_board.dto;

import java.sql.Timestamp;

public class BDto 
{
	int idx;
	String uName;
	String uTitle;
	String uContent;
	Timestamp rDate;
	int rHit;
	int rGroup;
	int rStep;
	int rIndent;
	
	public BDto() {
		// TODO Auto-generated constructor stub
	}
	
	public BDto(int idx, String uName, String uTitle, String uContent, Timestamp rDate, int rHit, int rGroup, int rStep, int rIndent) {
		// TODO Auto-generated constructor stub
		this.idx = idx;
		this.uName = uName;
		this.uTitle = uTitle;
		this.uContent = uContent;
		this.rDate = rDate;
		this.rHit = rHit;
		this.rGroup = rGroup;
		this.rIndent = rIndent;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	
	public String getuTitle() {
		return uTitle;
	}
	public void setuTitle(String uTitle) {
		this.uTitle = uTitle;
	}
	
	public String getuContent() {
		return uContent;
	}
	public void setuContent(String uContent) {
		this.uContent = uContent;
	}
	
	public Timestamp getrDate() {
		return rDate;
	}
	public void setrDate(Timestamp rDate) {
		this.rDate = rDate;
	}
	
	public int getrHit() {
		return rHit;
	}
	public void setrHit(int rHit) {
		this.rHit = rHit;
	}
	
	public int getrGroup() {
		return rGroup;
	}
	public void setrGroup(int rGroup) {
		this.rGroup = rGroup;
	}
	
	public int getrStep() {
		return rStep;
	}
	public void setrStep(int rStep) {
		this.rStep = rStep;
	}
	
	public int getrIndent() {
		return rIndent;
	}
	public void setrIndent(int rIndent) {
		this.rIndent = rIndent;
	}
}
