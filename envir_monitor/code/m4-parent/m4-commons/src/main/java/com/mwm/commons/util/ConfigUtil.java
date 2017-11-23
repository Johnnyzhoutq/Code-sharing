package com.mwm.commons.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.mwm.commons.cache.CacheUtil;
import com.mwm.commons.cache.CacheUtil.CACHE_LEVEL;
import com.mwm.commons.mybatis.modal.MwmConfig;
import com.mwm.commons.service.IMWMCommonsService;

@Component
public class ConfigUtil {
	private static Logger log = LoggerFactory.getLogger(ConfigUtil.class);

	private static IMWMCommonsService mwmCommonsService;

	@Autowired
	public void setMwmCommonsService(IMWMCommonsService mwmCommonsService) {
		ConfigUtil.mwmCommonsService = mwmCommonsService;
	}

	/**
	 * 从数据库获取某个key值对应的值，如果没有配置则为空
	 * @param key
	 * @return
	 * TODO 把缓存整上去
	 */
	public static String getValue(String key){
		/*String value  = null;
		Object cacheObj = CacheUtil.getInstance().get(key);
		if(cacheObj == null){
			MwmConfig resultMap = mwmCommonsService.getConfigByKey(key);
			if(resultMap != null){
				value = resultMap.getValue();
				CacheUtil.getInstance().saveObj(key, value);
				return value;
			}
		}else{
			value = cacheObj.toString();
		}
		return value;*/
		
		MwmConfig resultMap = mwmCommonsService.getConfigByKey(key);
		return resultMap.getValue();
	}
	
	public static String getValueNoCache(String key){
		String value  = null;
		MwmConfig resultMap = mwmCommonsService.getConfigByKey(key);
		if(resultMap != null){
			value = resultMap.getValue();
			
		}
		return value;
	}
	
	public static void insertOrUpdateConfig(String key,String value,int type){
		mwmCommonsService.insertOrUpdateConfig(key, value, type);
		CacheUtil.getInstance().saveObj(key, value, CACHE_LEVEL.MUTI_SHARE);
	}
	
}
