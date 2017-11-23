package com.mwm.commons.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 通用签名公用类
 * @author hery@2016-7-30 11:03:21
 *
 */
public class SignUtil {

	/**
	 * 字典排序，生成sign，小写
	 */
	public static String createSign(Map<String, String> packageParams, String signKey){
		
		SortedMap<String, String> sortedMap = new TreeMap<String, String>();
        sortedMap.putAll(packageParams);

        List<String> keys = new ArrayList<String>(packageParams.keySet());
        Collections.sort(keys);

        StringBuffer toSign = new StringBuffer();
        for (String key : keys) {
            String value = packageParams.get(key);
            if (null != value && !"".equals(value) && !"sign".equals(key) && !"key".equals(key)) {
                toSign.append(key + "=" + value + "&");
            }
        }
        toSign.append("key=" + signKey);
        String sign = DigestUtils.md5Hex(toSign.toString()).toUpperCase();        
        return sign;
	}
	
	public static void main(String args[]){
		Map<String, String> packageParams = new HashMap<String, String>();
		packageParams.put("nonce", "58658065");
		packageParams.put("timestamp", "20160810150006");
		packageParams.put("version", "1.0");
		packageParams.put("mobile", "15895310729");
		packageParams.put("type", "1");
		createSign(packageParams,"D6HzI480HLFjheWbTegWjMaLE0rdksx1");
	}
}
