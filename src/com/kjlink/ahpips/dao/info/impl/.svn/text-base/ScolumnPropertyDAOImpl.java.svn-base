package com.kjlink.ahpips.dao.info.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kjlink.ahpips.dao.impl.BaseDAOImpl;
import com.kjlink.ahpips.dao.info.ScolumnPropertyDAO;
import com.kjlink.ahpips.entity.info.ScolumnProperty;

@SuppressWarnings("unchecked")
@Component("scolumnPropertyDAO")
public class ScolumnPropertyDAOImpl extends BaseDAOImpl<ScolumnProperty> implements ScolumnPropertyDAO  {

	public ScolumnPropertyDAOImpl() {
		super(ScolumnProperty.class);
	}

	
	public List<ScolumnProperty> findByScolumnId(Integer scolumnId) {
		String hql = "from ScolumnProperty sp where sp.scolumnId.id="+scolumnId+" and sp.state=1 order by sp.id desc";
		return this.findByHql(hql);
	}

	
}
