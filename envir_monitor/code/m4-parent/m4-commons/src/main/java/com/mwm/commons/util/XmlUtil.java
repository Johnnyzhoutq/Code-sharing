package com.mwm.commons.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class XmlUtil {

	public static Map xmlStrToMap(String xml) throws DocumentException{
		Document doc = DocumentHelper.parseText(xml);
		Element rootEle = doc.getRootElement();
		Map<String,String> retMap = new HashMap();
		for (Iterator i = rootEle.elementIterator(); i.hasNext();) {
			Element el = (Element) i.next();
			String key = el.getName();
			String value = el.getStringValue();
			retMap.put(key, value);
		}
		return retMap;
	}
	
	public static String mapToXml(Map map){
		StringBuffer sb = new StringBuffer();
		Iterator<String> iterator = map.keySet().iterator(); 
		sb.append("<xml>");
		while (iterator.hasNext()) { 
			Object key = iterator.next();
			Object value = map.get(key);
			
			if(Integer.class.equals(value.getClass())){
				sb.append("<");
				sb.append(key);
				sb.append(">");
				sb.append(value);
				sb.append("</");
				sb.append(key);
				sb.append(">");
			}else{
				sb.append("<");
				sb.append(key);
				sb.append("><![CDATA[");
				sb.append(value);
				sb.append("]]></");
				sb.append(key);
				sb.append(">");
			}
			
		} 
		sb.append("</xml>");
		return sb.toString();
	}
}

