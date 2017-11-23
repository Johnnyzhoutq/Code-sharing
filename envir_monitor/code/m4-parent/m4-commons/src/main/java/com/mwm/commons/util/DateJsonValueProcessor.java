package com.mwm.commons.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**  
 * JSON日期格式转换 
 *  
*/  
public class DateJsonValueProcessor implements JsonValueProcessor  
{  
    private String format = "yyyy-MM-dd HH:mm:ss";  
  
    public DateJsonValueProcessor()  
    {  
  
    }  
  
    public DateJsonValueProcessor(String format)  
    {  
  
        this.format = format;  
    }  
  
    public Object processArrayValue(Object value, JsonConfig jsonConfig)  
    {  
  
        String[] obj = {};  
        if (value instanceof Date[])  
        {  
            SimpleDateFormat sf = new SimpleDateFormat(format);  
            Date[] dates = (Date[]) value;  
            obj = new String[dates.length];  
            for (int i = 0; i < dates.length; i++)  
            {  
                obj[i] = sf.format(dates[i]);  
            }  
        }  
        if(value instanceof int[]){
        	int[] dates = (int[]) value; 
        	for (int i = 0; i < dates.length; i++)  
            {  
                obj[i] = String.valueOf(dates[i]);  
            }  
        }
        if(value instanceof float[]){
        	float[] dates = (float[]) value; 
        	for (int i = 0; i < dates.length; i++)  
            {  
                obj[i] = String.valueOf(dates[i]);  
            }  
        }
        if(value instanceof double[]){
        	double[] dates = (double[]) value; 
        	for (int i = 0; i < dates.length; i++)  
            {  
                obj[i] = String.valueOf(dates[i]);  
            }  
        }
        if(value instanceof long[]){
        	long[] dates = (long[]) value; 
        	for (int i = 0; i < dates.length; i++)  
            {  
                obj[i] = String.valueOf(dates[i]);  
            }  
        }
        if(value instanceof Long[]){
        	Long[] dates = (Long[]) value; 
        	for (int i = 0; i < dates.length; i++)  
            {  
                obj[i] = String.valueOf(dates[i]);  
            }  
        }
        if(value instanceof Float[]){
        	Float[] dates = (Float[]) value; 
        	for (int i = 0; i < dates.length; i++)  
            {  
                obj[i] = String.valueOf(dates[i]);  
            }  
        }
        if(value instanceof Integer[]){
        	Integer[] dates = (Integer[]) value; 
        	for (int i = 0; i < dates.length; i++)  
            {  
                obj[i] = String.valueOf(dates[i]);  
            }  
        }
        
        if(value instanceof Double[]){
        	Double[] dates = (Double[]) value; 
        	for (int i = 0; i < dates.length; i++)  
            {  
                obj[i] = String.valueOf(dates[i]);  
            }  
        }
        
        if(value instanceof BigDecimal[]){
        	BigDecimal[] dates = (BigDecimal[]) value; 
        	for (int i = 0; i < dates.length; i++)  
            {  
                obj[i] = String.valueOf(dates[i]);  
            }  
        }
        
        return obj;  
    }  
  
    public Object processObjectValue(String key, Object value, JsonConfig jsonConfig)  
    {  
    	
    	if(value == null){
    		return null;
    	}
        if (value instanceof Date)  
        {  
        	String str="";
        	if(value != null ){
        		str = new SimpleDateFormat(format).format((Date) value);  
        	}
            return str;  
        }  
        if(value.getClass() == int.class){
        	return String.valueOf(value);  
        }
        if(value.getClass() == double.class){
        	return String.valueOf(value);  
        }
        if(value.getClass() == float.class){
        	return String.valueOf(value);  
        }
        if(value.getClass() == long.class){
        	return String.valueOf(value);  
        }
        if(value instanceof Integer){
        	return String.valueOf(value);  
        }
        if(value instanceof Float){
        	return String.valueOf(value);  
        }
        if(value instanceof Double){
        	return  String.valueOf(value);  
        }
        if(value instanceof BigDecimal){
        	return  String.valueOf(value);  
        }
        if(value instanceof Long){
        	return  String.valueOf(value);  
        }
        
        return value;
    }  
  
    public String getFormat()  
    {  
  
        return format;  
    }  
  
    public void setFormat(String format)  
    {  
  
        this.format = format;  
    }  
  
}  