package com.kjlink.ahpips.pojo;

import java.util.ArrayList;
import java.util.List;



public class TreeItem {
	private String title;
	private Integer id;
	private List<TreeItem> childs = new ArrayList<TreeItem>();

	public TreeItem() {

	}

	public TreeItem(Integer id, String title) {
		this.id = id;
		this.title = title;
	}

	public void addChild(TreeItem item) {
		childs.add(item);
	}

	/**
	 * Getter and Setter
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<TreeItem> getChilds() {
		return childs;
	}

	public void setChilds(List<TreeItem> childs) {
		this.childs = childs;
	}
}
