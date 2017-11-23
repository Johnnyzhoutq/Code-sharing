package com.mwm.commons.util;

import net.sf.json.JSONNull;
import net.sf.json.JsonConfig;
import net.sf.json.processors.DefaultValueProcessor;
import net.sf.json.processors.JsonValueProcessor;

public class StringDefaultValueProcessor implements DefaultValueProcessor  {


	
	public Object getDefaultValue(Class type) {  
        if (type != null && String.class.isAssignableFrom(type)) {  
            return "";  
        }  
        return JSONNull.getInstance();  
    }  


}
