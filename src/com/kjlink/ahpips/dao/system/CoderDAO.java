package com.kjlink.ahpips.dao.system;

import java.util.List;

import com.brady.common.dao.CommonDAO;
import com.kjlink.ahpips.entity.system.Coder;

public interface CoderDAO extends CommonDAO<Coder> {
	public List<Coder> getCoderByPrefix(String prefix) ;
}
