package com.kjlink.ahpips.dao.info;

import java.util.List;

import com.brady.common.dao.CommonDAO;
import com.kjlink.ahpips.entity.info.ScolumnProperty;

public interface ScolumnPropertyDAO extends CommonDAO<ScolumnProperty>{

	public List<ScolumnProperty> findByScolumnId(Integer scolumnId);
}
