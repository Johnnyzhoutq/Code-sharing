package com.mwm.commons.cache;

import java.util.List;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mwm.commons.exception.MwmRuntimeException;
import com.mwm.commons.util.StringUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.exceptions.JedisException;

public class RedisUtil implements ICacheMgr {
	Logger log = LoggerFactory.getLogger(RedisUtil.class);
	private static RedisUtil redisUtil;
	private  String NULL_FLAG ="nil";

	final static Object cacheObj = new Object();
	Jedis jedis;
	private static JedisPool jedisPool;
	static ResourceBundle bundle = PropertyResourceBundle.getBundle("redis");

	private void createJedisPool() {
		int database = Protocol.DEFAULT_DATABASE;
		int port = Protocol.DEFAULT_PORT;
		String password = null;
		int timeout = Protocol.DEFAULT_TIMEOUT;
		String host = null;
		int maxIdle = new Integer(bundle.getString("maxIdle"));
		;
		int maxTotal = new Integer(bundle.getString("maxTotal"));
		;
		int maxWaitMillis = new Integer(bundle.getString("maxWaitMillis"));
		;
		int minIdle = new Integer(bundle.getString("minIdle"));

		if (!StringUtil.isEmpty(bundle.getString("database"))) {
			database = new Integer(bundle.getString("database"));
		}

		if (!StringUtil.isEmpty(bundle.getString("password"))) {
			password = bundle.getString("password");
		}

		if (!StringUtil.isEmpty(bundle.getString("timeout"))) {
			timeout = new Integer(bundle.getString("timeout"));
		}

		if (!StringUtil.isEmpty(bundle.getString("port"))) {
			port = new Integer(bundle.getString("port"));
		}

		if (!StringUtil.isEmpty(bundle.getString("host"))) {
			host = bundle.getString("host");
		}
		if (StringUtil.isEmpty(host)) {
			log.error("使用redis服务但是没有配置redis主机");
			throw new MwmRuntimeException("使用redis服务但是没有配置redis主机");
		}
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(maxIdle);
		poolConfig.setMaxTotal(maxTotal);
		poolConfig.setMaxWaitMillis(maxWaitMillis);
		poolConfig.setMinIdle(minIdle);
		jedisPool = new JedisPool(poolConfig, host, port, timeout, password,
				database);
	}

	private RedisUtil() {
		this.createJedisPool();
	}

	public static RedisUtil getInstance() {
		if (redisUtil == null) {
			synchronized (cacheObj) {
				if (redisUtil == null) {
					redisUtil = new RedisUtil();
				}
			}
		}
		return redisUtil;
	}

	protected Jedis getJedis() throws JedisException {

		Jedis jedis = null;
		try {
			jedis = jedisPool.getResource();
		} catch (JedisException e) {
			if (jedis != null) {
				jedisPool.returnBrokenResource(jedis);
			}
			throw e;

		}
		return jedis;

	}
	
	protected void release(Jedis jedis, boolean isBroken) {

		if (jedis != null) {
			if (isBroken) {
				jedisPool.returnBrokenResource(jedis);
			} else {
				jedisPool.returnResource(jedis);
			}
		}

	}

	public void saveObj(String key, Object value) {
		this.saveObj(key, value, 0);
	}

	public void saveObj(String key, Object value, long expSeconds) {
		
		Class objClass = value.getClass();
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = this.getJedis();
			if (Map.class.equals(objClass)) {
				jedis.hmset(key, (Map<String, String>) value);
			} else if (String.class.equals(objClass)) {
				jedis.set(key, value.toString());
			}else{
				throw new MwmRuntimeException("不支持的缓存对象");
			}
			if(expSeconds > 0){
				jedis.expire(key, (int)expSeconds);
			}
		} catch (Exception e) {
			log.error("写入redis缓存异常：{}", e);
			isBroken = true;
			throw new MwmRuntimeException(e.getMessage());
		} finally {
			release(jedis, isBroken);

		}
	}

	public Object get(String key) {
		Jedis jedis = null;

		boolean isBroken = false;
		String retStr = null;

		try {

			jedis = this.getJedis();

			retStr = jedis.get(key);
			if(NULL_FLAG.equals(retStr)){
				retStr =  null;
			}

		} catch (Exception e) {
			log.error("读取redis缓存异常：{}", e);
			isBroken = true;

		} finally {

			release(jedis, isBroken);

		}
		return retStr;
	}

	@Override
	public void remove(String key) {
		Jedis jedis = null;

		boolean isBroken = false;
		String retStr = null;

		try {

			jedis = this.getJedis();
			
			jedis.del(key);
			retStr = jedis.get(key);
		} catch (Exception e) {
			log.error("读取redis缓存异常：{}", e);
			isBroken = true;

		} finally {

			release(jedis, isBroken);

		}
	}

	@Override
	public void clear() {Jedis jedis = null;

		if(true){
			throw new MwmRuntimeException("禁止调用redis清库指令");
		}
		boolean isBroken = false;
		String retStr = null;
	
		try {
			jedis = this.getJedis();
			
			jedis.flushDB();
		} catch (Exception e) {
			log.error("读取redis缓存异常：{}", e);
			isBroken = true;
	
		} finally {
	
			release(jedis, isBroken);
	
		}
	}
	
	@Override
	public long atomInc(String key){
		Jedis jedis = null;

		boolean isBroken = false;
		try {

			jedis = this.getJedis();
			return jedis.incr(key);
		} catch (Exception e) {
			log.error("读取redis缓存异常：{}", e);
			isBroken = true;
			throw new MwmRuntimeException("读取redis缓存异常：" + e.getMessage());
		} finally {

			release(jedis, isBroken);

		}
	}
	
	@Override
	public long atomDecr(String key){
		Jedis jedis = null;

		boolean isBroken = false;
		try {

			jedis = this.getJedis();
			return jedis.decr(key);
		} catch (Exception e) {
			log.error("读取redis缓存异常：{}", e);
			isBroken = true;
			throw new MwmRuntimeException("读取redis缓存异常：" + e.getMessage());
		} finally {

			release(jedis, isBroken);

		}
	}
	
	public long lpush(String key,String value){
		Jedis jedis = null;
		boolean isBroken = false;
		try {

			jedis = this.getJedis();
			return jedis.lpush(key, value);
		} catch (Exception e) {
			log.error("redis lpush缓存异常：{}", e);
			isBroken = true;
			throw new MwmRuntimeException("redis lpush缓存异常：" + e.getMessage());
		} finally {
			release(jedis, isBroken);
		}
	}
	
	public String lpop(String key){
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = this.getJedis();
			return jedis.lpop(key);
		} catch (Exception e) {
			log.error("redis lpop缓存异常：{}", e);
			isBroken = true;
			throw new MwmRuntimeException("redis lpop缓存异常：" + e.getMessage());
		} finally {
			release(jedis, isBroken);
		}
	}
	
	public List<String> lrange(String key,long start,long end){

		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = this.getJedis();
			return jedis.lrange(key,start,end);
		} catch (Exception e) {
			log.error("redis lrange缓存异常：{}", e);
			isBroken = true;
			throw new MwmRuntimeException("redis lrange缓存异常：" + e.getMessage());
		} finally {
			release(jedis, isBroken);
		}
	}
	
	/**
	 * 移出LIST中的值
	 * @param key
	 * @param value
	 */
	public void lrem(String key,String value){
		Jedis jedis = null;
		boolean isBroken = false;
		try {
			jedis = this.getJedis();
			jedis.lrem(key, 0, value);
		} catch (Exception e) {
			log.error("redis lpop缓存异常：{}", e);
			isBroken = true;
			throw new MwmRuntimeException("redis lpop缓存异常：" + e.getMessage());
		} finally {
			release(jedis, isBroken);
		}
	}

	@Override
	public boolean exists(String key) {
		Jedis jedis = null;
		boolean isBroken = false;
		try {

			jedis = this.getJedis();
			return jedis.exists(key);
		} catch (Exception e) {
			log.error("读取redis缓存异常：{}", e);
			isBroken = true;
			throw new MwmRuntimeException("读取redis缓存异常：" + e.getMessage());
		} finally {
			release(jedis, isBroken);

		}
	}
	
}
