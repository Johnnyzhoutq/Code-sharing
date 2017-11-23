package com.mwm.commons.cache;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mwm.commons.commonConst.Const;
import com.mwm.commons.util.ConfigUtil;
import com.twelvemonkeys.lang.StringUtil;

/**
 * 缓存工具类
 * @author tanxh
 * @reconstruction hery
 *
 */
public class CacheUtil {
	private static Logger log = LoggerFactory.getLogger(CacheUtil.class);
	
	private static String endTag = "";
	
	final static Object cacheObj = new Object();

    // 1. 定义枚举类型
	public enum CACHE_LEVEL {
		// 利用构造函数传参 single_priv 单应用独享，mutil_share 多应用共享
		SINGLE_PRIV(1), MUTI_SHARE(2);

		// 定义私有变量
		private int nCode;

		// 构造函数，枚举类型只能为私有
		private CACHE_LEVEL(int _nCode) {
			this.nCode = _nCode;
		}

		@Override
		public String toString() {
			return String.valueOf(this.nCode);
		}
	}
    
    private Map<String, ICacheMgr> cacheMgrMap;
    private static CacheUtil cacheUtil;  
  
    private CacheUtil() {  
    	cacheMgrMap = new HashMap();
    	cacheMgrMap.put(CACHE_LEVEL.MUTI_SHARE+"", RedisUtil.getInstance());
    	cacheMgrMap.put(CACHE_LEVEL.SINGLE_PRIV+"", EhcacheCacheUtil.getInstance());
    }
  
    public static CacheUtil getInstance() {  
        if (cacheUtil == null) {  
        	synchronized (cacheObj) {
                if (cacheUtil == null) {  
                	cacheUtil = new CacheUtil();  
                }
			}
        }
        return cacheUtil;  
    }
    
    private ICacheMgr getCacheMgr(){
    	if(Const.CENTER_CACHE){
    		return RedisUtil.getInstance();
    	}else{
    		return EhcacheCacheUtil.getInstance();
    	}
    }
    
    
    /**
     * 存储对象
     * 
     * @param key
     * @param value
     * @param level 缓存级别
     */
    @Deprecated
	public  void saveObj(String key, Object value, CACHE_LEVEL level){
        if (!Const.CONFIG_NEED_CACH.equalsIgnoreCase("Y")) {
            return;
        }
		saveObj(key, value, level, 0l);
	}
	
	
	/**
	 *  缓存对象
	 * @param key
	 * @param value
	 */
	public void saveObj(String key, Object value){
		if (!Const.CONFIG_NEED_CACH.equalsIgnoreCase("Y")) {
            return;
        }
		this.getCacheMgr().saveObj(buildKey(key),value);
	}

	/**
	 * 保存缓存对象 并且设置失效时长
	 * @param key
	 * @param value
	 * @param expTime
	 */
	public  void saveObj(String key,  Object value,long expTime){
		getCacheMgr().saveObj(buildKey(key),value,expTime);
	}
	
	/**
     * 存储对象
     * @param key
     * @param value
     * @param level
     * @param expTime 缓存有效时长，0为永久有效
     */
	@Deprecated
	public  void saveObj(String key,  Object value, CACHE_LEVEL level, long expTime){
		if (!Const.CONFIG_NEED_CACH.equalsIgnoreCase("Y")) {
            return ;
        }
		this.getCacheMgr().saveObj(buildKey(key), value,expTime);
	}
	
	/**
     * 从缓存获取key
     * @param key
     * @param level
     * @return
     */
	@Deprecated
    public Object get(String key, CACHE_LEVEL level) {
        if (!Const.CONFIG_NEED_CACH.equalsIgnoreCase("Y")) {
            return null;
        }
		return getCacheMgr().get(buildKey(key));
	}
    
    /**
     * 根据key获取缓存
     * @param key
     * @return
     */
    public Object get(String key){
    	if (!Const.CONFIG_NEED_CACH.equalsIgnoreCase("Y")) {
            return null;
        }
    	return  getCacheMgr().get(buildKey(key));
    }

    
    @Deprecated
    public void remove(String key,CACHE_LEVEL level){
    	if (!Const.CONFIG_NEED_CACH.equalsIgnoreCase("Y")) {
            return ;
        }
    	getCacheMgr().remove(buildKey(key));
    }
    
    
    /**
     * 删除某个key值对应的缓存
     * @param key
     */
    public void remove(String key){
    	if (!Const.CONFIG_NEED_CACH.equalsIgnoreCase("Y")) {
            return ;
        }
    	getCacheMgr().remove(buildKey(key));
    }
    
    /**
     * 原子性增加某个值，仅redis使用，如果不存在该key 则设置为1
     * @param key
     * @return
     */
    public long atomInc(String key){
    	return getCacheMgr().atomInc(key);
    }
    
    
    /**
     * 原子性减某个值，仅redis使用，如果不存在该key 则设置为-1
     * @param key
     * @return
     */
    public long atomDesc(String key){
    	return getCacheMgr().atomDecr(key);
    }
	
    
    /**
     * 清除缓存
     */
	public void clear(){
		log.debug("清理所有缓存....");
		if (!Const.CONFIG_NEED_CACH.equalsIgnoreCase("Y")) {
            return ;
        }
		getCacheMgr().clear();
	}
	
	
	/**
	 * 判断缓存中是否存在某个key
	 * @param key
	 */
	public boolean exists(String key){
		if (!Const.CONFIG_NEED_CACH.equalsIgnoreCase("Y")) {
            return false;
        }
		return getCacheMgr().exists(buildKey(key));
	}
	
	public String buildKey(String key){
		return key+"_"+endTag;
	}
	
	
	synchronized public static void loadCacheEndKey(){
        log.debug("获取后台缓存Key后缀开始----");
        String newEndTag = ConfigUtil.getValueNoCache(Const.CACHE_END_KEY);
        if(newEndTag != null && !endTag.equalsIgnoreCase(newEndTag)){
        	//CacheUtil.getInstance().clear();
        	log.debug("版本有变化原来endKey:{}, 现有Key:{}", endTag, newEndTag);
        	endTag = newEndTag;
        }
	}
	
	public static void updateCache(){
		String newEndTag = ConfigUtil.getValueNoCache(Const.CACHE_END_KEY);
		double i = 0;
		if(StringUtil.isEmpty(newEndTag)){
			i++;
		}else if(StringUtils.isNumeric(newEndTag)){
			i = new Double(newEndTag);
			i++;
		}
		ConfigUtil.insertOrUpdateConfig(Const.CACHE_END_KEY, i+"", Const.CONFIG_TYPE_BACK);
	}
}
