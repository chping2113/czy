package com.kjlink.ahpips.web.action;

public class TaskCount {
	private String name;
	private String url;
	private int count;
	private String id;
	private int fristMenu;
	

	public int getFristMenu() {
		return fristMenu;
	}
	public void setFristMenu(int fristMenu) {
		this.fristMenu = fristMenu;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
