package com.kjlink.ahpips.dao.system.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.system.CoderDAO;
import com.kjlink.ahpips.entity.system.Coder;

@Component("coderDAO")
public class CoderDAOImpl extends BaseDAOImpl<Coder> implements CoderDAO {
	public CoderDAOImpl() {
		super(Coder.class);
	}
	
	public List<Coder> getCoderByPrefix(String prefix) {
		String hql = "from Coder co where co.prefix = '" + prefix + "'";
		return this.findByHql(hql);
	}
	
}
