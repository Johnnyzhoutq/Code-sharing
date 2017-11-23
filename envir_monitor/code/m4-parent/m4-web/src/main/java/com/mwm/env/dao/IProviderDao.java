package com.mwm.env.dao;

import java.util.Map;

public interface IProviderDao {

	/**
	 * 获取供应方信息
	 * @param provideid
	 * @return
	 */
	Map getProviderInfo(Integer provideid);

}
