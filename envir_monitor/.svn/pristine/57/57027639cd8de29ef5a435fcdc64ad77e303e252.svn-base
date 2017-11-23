package com.mwm.commons.cache;

import java.net.URL;

import com.mwm.commons.exception.MwmRuntimeException;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhcacheCacheUtil implements ICacheMgr{
	private static final String path = "/commonEhcache.xml";  
	  
    private URL url;  
  
    private CacheManager manager;
    private String cacheName = "configCache";
	final static Object cacheObj = new Object();
  
    private static EhcacheCacheUtil ehCache;  
  
    private EhcacheCacheUtil(String path) {  
        url = getClass().getResource(path);  
        manager = CacheManager.create(url);
    }  
  
    public static EhcacheCacheUtil getInstance() {  
        if (ehCache== null) {  
        	synchronized (cacheObj) {
                if (ehCache== null) {  
                    ehCache= new EhcacheCacheUtil(path);  
                }
			}
        }  
        return ehCache;  
    }  
    
  
    public Object get(String key) {  
    	Cache cache = manager.getCache(cacheName);  
        Element element = cache.get(key);  
        return element == null ? null : element.getObjectValue(); 
    }  
  
    public void remove(String cacheName, String key) {  
        Cache cache = manager.getCache(cacheName);  
        cache.remove(key);  
    }

	public void saveObj(String key, Object value) {
		this.saveObj(key, value, 0);
	}

	public void saveObj(String key, Object value, long expTime) {
		Cache cache = manager.getCache(cacheName);  
        Element element = new Element(key, value);  
        cache.put(element);  
	}
	
	

	@Override
	public void remove(String key) {
		Cache cache = manager.getCache(cacheName);  
		cache.remove(key);
	}

	@Override
	public void clear() {

		Cache cache = manager.getCache(cacheName);
		cache.removeAll();
	}

	@Override
	public long atomDecr(String key) {
		throw new MwmRuntimeException("Encache缓存框架method--atomDecr未实现");
	}

	@Override
	public long atomInc(String key) {
		throw new MwmRuntimeException("Encache缓存框架method--atomInc未实现");
	}

	@Override
	public boolean exists(String key) {
		if(this.get(key) != null){
			return true;
		}
		return false;
	}  

}
