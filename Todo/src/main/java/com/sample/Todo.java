package com.sample;

import java.util.Date;

public class Todo {

	int id;
	String regname;
	String chargename;
	String contents;
	String bikou;
	String date;
	
	Date deadline;
	
	public Todo(int id,String regname, String contents, String date,String chargename,String bikou ) {
		super();
		this.id=id;
		this.regname = regname;
		this.chargename = chargename;
		this.contents = contents;
		this.date=date;
		this.bikou=bikou;
	}
	
	public String getRegname() {
		return regname;
	}
	public String getChargename() {
		return chargename;
	}
	public String getContents() {
		return contents;
	}
	

	public Date getDeadline() {
		return deadline;
	}

	public int getId() {
		return id;
	}

	public String getBikou() {
		return bikou;
	}

	public String getDate() {
		return date;
	}

	
	
	
	
}
