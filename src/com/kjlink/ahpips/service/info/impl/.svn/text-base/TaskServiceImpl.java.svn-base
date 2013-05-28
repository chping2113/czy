package com.kjlink.ahpips.service.info.impl;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.info.TaskDAO;
import com.kjlink.ahpips.entity.info.Task;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.entity.system.Site;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.info.TaskService;

@Service("taskService")
public class TaskServiceImpl extends BaseServiceImpl<Task> implements TaskService {
	private TaskDAO newsDAO;

	public TaskDAO getTaskDAO() {
		return newsDAO;
	}

	public void setTaskDAO(TaskDAO newsDAO) {
		super.setCommonDAO(newsDAO);  //父类的方法一定要被调用,否则会出错
		this.newsDAO = newsDAO;
	}
	
	public PageInfo findPageAll(int pageNo, int pageSize) {
		return this.newsDAO.findPageAll(pageNo, pageSize);
	}

	public PageInfo todoList(String str,int pageNo, int pageSize,Site site){
		return this.newsDAO.todoList(str,pageNo, pageSize,site);
		
	}
	public PageInfo quickSearch( String str, int pageNo, int pageSize) {
		return this.newsDAO.quickSearch(str, pageNo, pageSize);
	}
	public int findCount(Site site){
		return this.newsDAO.findCount(site);
	}

}
