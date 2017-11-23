package com.mwm.commons.umeng;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mwm.commons.umeng.android.AndroidBroadcast;
import com.mwm.commons.umeng.android.AndroidCustomizedcast;
import com.mwm.commons.umeng.android.AndroidFilecast;
import com.mwm.commons.umeng.android.AndroidGroupcast;
import com.mwm.commons.umeng.android.AndroidUnicast;
import com.mwm.commons.umeng.ios.IOSBroadcast;
import com.mwm.commons.umeng.ios.IOSCustomizedcast;
import com.mwm.commons.umeng.ios.IOSFilecast;
import com.mwm.commons.umeng.ios.IOSGroupcast;
import com.mwm.commons.umeng.ios.IOSUnicast;

public class UMengPush {
	
	protected static ResourceBundle umengBundle = PropertyResourceBundle.getBundle("umeng");
	//配置
	public final static String IOSumengAppkey = umengBundle.getString("ios_appkey");
	public final static String IOSumengAppMasterSecret = umengBundle.getString("ios_app_master_secret");
	public final static String AndroidumengAppkey = umengBundle.getString("android_appkey");
	public final static String AndroidumengAppMasterSecret = umengBundle.getString("android_app_master_secret");
	//服务器秘钥
	public final static boolean umengTestMode = umengBundle.getString("test_mode").equalsIgnoreCase("Y");
	private String timestamp = null;
	private static PushClient client = new PushClient();
	
	public static void sendAndroidBroadcast() throws Exception {
		AndroidBroadcast broadcast = new AndroidBroadcast(AndroidumengAppkey,AndroidumengAppMasterSecret);
		broadcast.setTicker( "Android broadcast ticker");
		broadcast.setTitle(  "中文的title");
		broadcast.setText(   "Android broadcast text");
		broadcast.goAppAfterOpen();
		broadcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		// TODO Set 'production_mode' to 'false' if it's a test device. 
		// For how to register a test device, please see the developer doc.
		broadcast.setProductionMode();
		// Set customized fields
		broadcast.setExtraField("test", "helloworld");
		client.send(broadcast);
	}
	
	public static void sendAndroidBroadcast(AndroidBroadcast broadcast) throws Exception {
		broadcast.setTicker( "Android broadcast ticker");
		broadcast.setTitle(  "中文的title");
		broadcast.setText(   "Android broadcast text");
		broadcast.goAppAfterOpen();
		broadcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		// Set customized fields
		broadcast.setExtraField("test", "helloworld");
		client.send(broadcast);
	}
	
	public static void sendAndroidUnicast() throws Exception {
		AndroidUnicast unicast = new AndroidUnicast(AndroidumengAppkey,AndroidumengAppMasterSecret);
		// TODO Set your device token
		unicast.setDeviceToken( "your device token");
		unicast.setTicker( "Android unicast ticker");
		unicast.setTitle(  "中文的title");
		unicast.setText(   "Android unicast text");
		unicast.goAppAfterOpen();
		unicast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		// TODO Set 'production_mode' to 'false' if it's a test device. 
		// For how to register a test device, please see the developer doc.
		unicast.setProductionMode();
		// Set customized fields
		unicast.setExtraField("test", "helloworld");
		client.send(unicast);
	}
	
	public static void sendAndroidGroupcast() throws Exception {
		AndroidGroupcast groupcast = new AndroidGroupcast(AndroidumengAppkey,AndroidumengAppMasterSecret);
		/*  TODO
		 *  Construct the filter condition:
		 *  "where": 
		 *	{
    	 *		"and": 
    	 *		[
      	 *			{"tag":"test"},
      	 *			{"tag":"Test"}
    	 *		]
		 *	}
		 */
		JSONObject filterJson = new JSONObject();
		JSONObject whereJson = new JSONObject();
		JSONArray tagArray = new JSONArray();
		JSONObject testTag = new JSONObject();
		JSONObject TestTag = new JSONObject();
		testTag.put("tag", "test");
		TestTag.put("tag", "Test");
		tagArray.put(testTag);
		tagArray.put(TestTag);
		whereJson.put("and", tagArray);
		filterJson.put("where", whereJson);
		System.out.println(filterJson.toString());
		
		groupcast.setFilter(filterJson);
		groupcast.setTicker( "Android groupcast ticker");
		groupcast.setTitle(  "中文的title");
		groupcast.setText(   "Android groupcast text");
		groupcast.goAppAfterOpen();
		groupcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		// TODO Set 'production_mode' to 'false' if it's a test device. 
		// For how to register a test device, please see the developer doc.
		groupcast.setProductionMode();
		client.send(groupcast);
	}
	
	public static void sendAndroidCustomizedcast() throws Exception {
		AndroidCustomizedcast customizedcast = new AndroidCustomizedcast(AndroidumengAppkey,AndroidumengAppMasterSecret);
		// TODO Set your alias here, and use comma to split them if there are multiple alias.
		// And if you have many alias, you can also upload a file containing these alias, then 
		// use file_id to send customized notification.
		customizedcast.setAlias("oKoQoweoEnLAxEWCQByHFhVfwiHXIgfq", "alias_type");
		customizedcast.setTicker( "Android customizedcast ticker");
		customizedcast.setTitle(  "中文的title");
		customizedcast.setText(   "Android customizedcast text");
		customizedcast.goAppAfterOpen();
		customizedcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		// TODO Set 'production_mode' to 'false' if it's a test device. 
		// For how to register a test device, please see the developer doc.
		customizedcast.setProductionMode();
		client.send(customizedcast);
	}
	
	public static void main(String args[]) throws Exception{
		sendAndroidCustomizedcast();
	}
	
	public static void sendAndroidCustomizedcast(AndroidCustomizedcast customizedcast) throws Exception {
		if(umengTestMode){
			customizedcast.setTestMode();
		}else{
			customizedcast.setProductionMode();
		}
		client.send(customizedcast);
	}
	
	public static void sendAndroidCustomizedcastFile() throws Exception {
		AndroidCustomizedcast customizedcast = new AndroidCustomizedcast(AndroidumengAppkey,AndroidumengAppMasterSecret);
		// TODO Set your alias here, and use comma to split them if there are multiple alias.
		// And if you have many alias, you can also upload a file containing these alias, then 
		// use file_id to send customized notification.
		String fileId = client.uploadContents(AndroidumengAppkey,AndroidumengAppMasterSecret,"aa"+"\n"+"bb"+"\n"+"alias");
		customizedcast.setFileId(fileId, "alias_type");
		customizedcast.setTicker( "Android customizedcast ticker");
		customizedcast.setTitle(  "中文的title");
		customizedcast.setText(   "Android customizedcast text");
		customizedcast.goAppAfterOpen();
		customizedcast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		// TODO Set 'production_mode' to 'false' if it's a test device. 
		// For how to register a test device, please see the developer doc.
		customizedcast.setProductionMode();
		client.send(customizedcast);
	}
	
	public static void sendAndroidFilecast() throws Exception {
		AndroidFilecast filecast = new AndroidFilecast(AndroidumengAppkey,AndroidumengAppMasterSecret);
		// TODO upload your device tokens, and use '\n' to split them if there are multiple tokens 
		String fileId = client.uploadContents(AndroidumengAppkey,AndroidumengAppMasterSecret,"aa"+"\n"+"bb");
		filecast.setFileId( fileId);
		filecast.setTicker( "Android filecast ticker");
		filecast.setTitle(  "中文的title");
		filecast.setText(   "Android filecast text");
		filecast.goAppAfterOpen();
		filecast.setDisplayType(AndroidNotification.DisplayType.NOTIFICATION);
		client.send(filecast);
	}
	
	public static void sendIOSBroadcast() throws Exception {
		IOSBroadcast broadcast = new IOSBroadcast(IOSumengAppkey,IOSumengAppMasterSecret);

		broadcast.setAlert("IOS 广播测试");
		broadcast.setBadge(0);
		broadcast.setSound("default");
		// TODO set 'production_mode' to 'true' if your app is under production mode
		broadcast.setTestMode();
		//broadcast.set
		// Set customized fields
		broadcast.setCustomizedField("test", "helloworld");
		client.send(broadcast);
	}
	
	public static void sendIOSBroadcast(IOSBroadcast broadcast) throws Exception {
		if(umengTestMode){
			broadcast.setTestMode();
		}else{
			broadcast.setProductionMode();
		}
		client.send(broadcast);
	}
	
	public static void sendIOSUnicast() throws Exception {
		IOSUnicast unicast = new IOSUnicast(IOSumengAppkey,IOSumengAppMasterSecret);
		// TODO Set your device token
		unicast.setDeviceToken( "xx");
		unicast.setAlert("IOS 单播测试");
		unicast.setBadge(0);
		unicast.setSound("default");
		// TODO set 'production_mode' to 'true' if your app is under production mode
		unicast.setTestMode();
		// Set customized fields
		unicast.setCustomizedField("test", "helloworld");
		client.send(unicast);
	}
	
	public static void sendIOSUnicast(IOSUnicast unicast) throws Exception {
		if(umengTestMode){
			unicast.setTestMode();
		}else{
			unicast.setProductionMode();
		}
		client.send(unicast);
	}
	
	public static void sendIOSGroupcast() throws Exception {
		IOSGroupcast groupcast = new IOSGroupcast(IOSumengAppkey,IOSumengAppMasterSecret);
		/*  TODO
		 *  Construct the filter condition:
		 *  "where": 
		 *	{
    	 *		"and": 
    	 *		[
      	 *			{"tag":"iostest"}
    	 *		]
		 *	}
		 */
		JSONObject filterJson = new JSONObject();
		JSONObject whereJson = new JSONObject();
		JSONArray tagArray = new JSONArray();
		JSONObject testTag = new JSONObject();
		testTag.put("tag", "iostest");
		tagArray.put(testTag);
		whereJson.put("and", tagArray);
		filterJson.put("where", whereJson);
		System.out.println(filterJson.toString());
		
		// Set filter condition into rootJson
		groupcast.setFilter(filterJson);
		groupcast.setAlert("IOS 组播测试");
		groupcast.setBadge( 0);
		groupcast.setSound( "default");
		// TODO set 'production_mode' to 'true' if your app is under production mode
		groupcast.setTestMode();
		client.send(groupcast);
	}
	
	public static void sendIOSGroupcast(IOSGroupcast groupcast) throws Exception {
		if(umengTestMode){
			groupcast.setTestMode();
		}else{
			groupcast.setProductionMode();
		}
		client.send(groupcast);
	}
	
	public static void sendIOSCustomizedcast() throws Exception {
		IOSCustomizedcast customizedcast = new IOSCustomizedcast(IOSumengAppkey,IOSumengAppMasterSecret);
		// TODO Set your alias and alias_type here, and use comma to split them if there are multiple alias.
		// And if you have many alias, you can also upload a file containing these alias, then 
		// use file_id to send customized notification.
		customizedcast.setAlias("alias", "alias_type");
		customizedcast.setAlert("IOS 个性化测试");
		customizedcast.setBadge( 0);
		customizedcast.setSound( "default");
		// TODO set 'production_mode' to 'true' if your app is under production mode
		customizedcast.setTestMode();
		client.send(customizedcast);
	}
	
	public static void sendIOSCustomizedcast(IOSCustomizedcast customizedcast) throws Exception {
		if(umengTestMode){
			customizedcast.setTestMode();
		}else{
			customizedcast.setProductionMode();
		}
		client.send(customizedcast);
	}
	
	public static void sendIOSFilecast() throws Exception {
		IOSFilecast filecast = new IOSFilecast(IOSumengAppkey,IOSumengAppMasterSecret);
		// TODO upload your device tokens, and use '\n' to split them if there are multiple tokens 
		String fileId = client.uploadContents(IOSumengAppkey,IOSumengAppMasterSecret,"aa"+"\n"+"bb");
		filecast.setFileId( fileId);
		filecast.setAlert("IOS 文件播测试");
		filecast.setBadge( 0);
		filecast.setSound( "default");
		// TODO set 'production_mode' to 'true' if your app is under production mode
		filecast.setTestMode();
		client.send(filecast);
	}
	
	public static void sendIOSFilecast(IOSFilecast filecast) throws Exception {
		if(umengTestMode){
			filecast.setTestMode();
		}else{
			filecast.setProductionMode();
		}
		client.send(filecast);
	}

}
