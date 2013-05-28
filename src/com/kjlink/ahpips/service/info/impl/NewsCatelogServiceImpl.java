package com.kjlink.ahpips.service.info.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.brady.common.page.PageInfo;
import com.kjlink.ahpips.dao.info.*;
import com.kjlink.ahpips.dao.system.*;
import com.kjlink.ahpips.entity.info.*;
import com.kjlink.ahpips.entity.system.*;
import com.kjlink.ahpips.service.impl.BaseServiceImpl;
import com.kjlink.ahpips.service.info.*;
import com.kjlink.ahpips.service.system.*;

@Service("newsCatelogService")
public class NewsCatelogServiceImpl extends BaseServiceImpl<NewsCatelog> implements NewsCatelogService {
	private NewsCatelogDAO newsCatelog;

	public NewsCatelogDAO getNewsCatelogDAO() {
		return newsCatelog;
	}

	public void setNewsCatelogDAO(NewsCatelogDAO newsCatelog) {
		super.setCommonDAO(newsCatelog);  //����ķ���һ��Ҫ������,��������
		this.newsCatelog = newsCatelog;
	}
	
	/**
	 * ��ʾȫ����Ŀ
	 */
	public PageInfo findPageAll(int pageNo, int pageSize) {
		return this.newsCatelog.findPageAll(pageNo, pageSize);
	}
	
	/**
	 * ��ʾȫ��һ����Ŀ
	 */
	public PageInfo findFirstLevelPageAll(int pageNo, int pageSize) {
		return this.newsCatelog.findFirstLevelPageAll(pageNo, pageSize);
	}
	
	/**
	 * ��ʾȫ��������Ŀ
	 */
	public PageInfo findSecondLevelPageAll(Integer parentId, int pageNo, int pageSize) {
		return this.newsCatelog.findSecondLevelPageAll(parentId, pageNo, pageSize);
	}
	
	public PageInfo quickSearch(String str, int pageNo, int pageSize) {
		return this.newsCatelog.quickSearch(str, pageNo, pageSize);
	}
	
	public List<NewsCatelog> findSecondCatelogsByParentId(Integer parentId) {
		return this.newsCatelog.findSecondCatelogsByParentId(parentId);
	}
}
