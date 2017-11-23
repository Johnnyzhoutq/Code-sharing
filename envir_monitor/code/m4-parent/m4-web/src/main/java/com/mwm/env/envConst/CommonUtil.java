package com.mwm.env.envConst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CommonUtil {

	//list<Map> 转小写
	public static List<Map> toLowerCaseForList(List<Map> list){
		if (list == null) {
			return null;
		}
		List<Map> returnList = new ArrayList<>();
		for(Map map : list){
			Map newMap = new HashMap<>();
			for (Object key : map.keySet()) {
				newMap.put(key.toString().toLowerCase(), map.get(key));
			}
			returnList.add(newMap);
		}
		return returnList;
	}

	//Map 转小写
	public static Map toLowerCaseForMap(Map returnMap) {
		Map newMap = new HashMap<>();
		for (Object key : returnMap.keySet()) {
			newMap.put(key.toString().toLowerCase(), returnMap.get(key));
		}
		return newMap;
	}
}
