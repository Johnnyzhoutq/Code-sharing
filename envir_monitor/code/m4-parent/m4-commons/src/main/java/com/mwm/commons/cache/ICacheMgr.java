package com.mwm.commons.cache;

/**
 * 缓存管理接口
 * @author Kunee
 *
 */
public interface ICacheMgr {
	
	/**
	 * 存储对象
	 * @param key
	 * @param value
	 */
	public void saveObj(String key, Object value);
	
	/**
	 * 存储对象
	 * @param key
	 * @param value
	 * @param level
	 * @param expTime  缓存有效时长，0为永久有效
	 */
	public void saveObj(String key,  Object value, long expTime);
	
	/**
	 * 从缓存获取key
	 * @param key
	 * @return
	 */
	public Object get(String key);

	/**
	 * 移除缓存
	 * @param key
	 */
	public void remove(String key);
	
	/**
	 * 清理缓存
	 */
	public void clear();

	/**
	 * 原子性减 仅redis 实现
	 * @param key
	 * @return
	 */
	long atomDecr(String key);

	/**
	 * 原子性加 仅redis 实现
	 * @param key
	 * @return
	 */
	long atomInc(String key);
	
	/**
	 * 判断缓存中是否存在某个key
	 * @param key
	 */
	public boolean exists(String key);
}
