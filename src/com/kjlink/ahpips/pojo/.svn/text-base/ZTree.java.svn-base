package com.kjlink.ahpips.pojo;

import java.util.ArrayList;
import java.util.List;



/**
 * 用于ZTree的树形数据封装格式
 * @author brady
 *
 */
public class ZTree {
	private String id;		//树的节点ID
	private String name = ""; 	//树的节点名称
	private String ename= "";	//树的英文节点名称
	private boolean open = false;	//节点是否展开标志
	
	private List<ZTree> nodes = new ArrayList<ZTree>();	//子节点

	public ZTree() {
	}

	public ZTree(String id, String name, String ename, boolean open) {
		this.id = id;
		this.name = name;
		this.ename= ename;
		this.open = open;
	}
	

	public void addChild(ZTree item) {
		nodes.add(item);
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public List<ZTree> getNodes() {
		return nodes;
	}

	public void setNodes(List<ZTree> nodes) {
		this.nodes = nodes;
	}
}
