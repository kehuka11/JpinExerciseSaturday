package com.sample;

import java.util.Date;

public class Topic {

	private String dai;
	private String name;
	private String comment;
	private String addcomment;
	private Date date;
	private int id;
	public Topic(int id, String dai,String name, String comment, String addcomment, Date date) {
		super();
		this.id=id;
		this.dai=dai;
		this.name = name;
		this.comment = comment;
		this.addcomment=addcomment;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public String getComment() {
		return comment;
	}
	public Date getDate() {
		return date;
	}
	public int getId() {
		return id;
	}
	public String getDai() {
		return dai;
	}
	public String getAddcomment() {
		return addcomment;
	}
	public void setAddcomment(String addcomment) {
		this.addcomment = addcomment;
	}
	
	
	
	
}
