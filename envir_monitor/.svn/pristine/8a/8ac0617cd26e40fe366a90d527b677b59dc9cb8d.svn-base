package com.mwm.commons.commonConst;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * const文件
 * 1、此文件中的值未加注释的请相关人员加上
 * 2、任意改动请通知大家
 * 3、对应的配置项请在config.properties中配置
 * @author Ryan_
 */
public class Const {
	
	static ResourceBundle bundle = PropertyResourceBundle.getBundle("config");
	
	/**
	 * 项目地址
	 */
	public final static String BASE_URL = bundle.getString("BASE_URL");
	
	/**
	 * 状态字段
	 */
	public final static String STATE_INIT = "W";		//初始状态
	public final static String STATE_NORMAL = "N";		//正常状态
	public final static String STATE_LOCK = "L";		//锁定状态
	public final static String STATE_LOCK_M = "LM";		//人为锁定状态
	public final static String STATE_LOCK_A = "LA";		//自动锁定状态
	public final static String STATE_COMPLETE = "C";	//步骤完成状态（部分结束）
	public final static String STATE_FINISH = "A";		//流程结束状态（整体结束）
	public final static String STATE_DEL = "D";			//删除状态
	
	/**
	 * 支付状态
	 */
	public final static String STATE_PAY_INIT = "W";			//交易创建，等待付款
	public final static String STATE_PAY_CLOSED = "CL";			//未付款交易关闭
	public final static String STATE_PAY_SUCCESS = "SU";		//交易支付成功
	public final static String STATE_PAY_REFUND = "R";			//支付完成后全额退款
	public final static String STATE_PAY_FINISHED = "FS";		//交易结束，不可退款
	
	/**
	 * 配置表通用
	 */
	public final static int CONFIG_TYPE_FRONT = 2;		//前端可用
	public final static int CONFIG_TYPE_BACK = 1;		//后端可用
	public final static int CONFIG_TYPE_ALL = 3;		//全部可用
	
	/**
	 * 图片上传
	 */
	public final static String IS_IN_PROJECT_DIR = bundle.getString("IS_IN_PROJECT_DIR");
	public final static String DEFAULT_UPLOAD_DIR = bundle.getString("DEFAULT_UPLOAD_DIR");
	public final static String IMG_MAX_SIZE = bundle.getString("IMG_MAX_SIZE");
	public final static String IMG_URL_DOMAIN = bundle.getString("IMG_URL_DOMAIN");
	public final static String IMG_FILE_PATH = bundle.getString("IMG_FILE_PATH");
	
	/**
	 * 缓存
	 */
	public final static String BEAN_NAME_CACHE_MGR = "cacheMgr";				//缓存管理器	
	public final static String BEAN_NAME_CENTER_CACHE_MGR = "centerCacheMgr";	//中心缓存管理器
	public final static String BEAN_NAME_REDIS_CACHE = "redisCacheMgr";			//redis缓存管理器
	public final static String REDIS_CACH_KEYS = "CACHED_KES_SET";				//redis 需要清除缓存的list 
	public final static String NO_VALIDATE_BEGIN_REDIS_KEY = "CAN_GO_OPENID";	//可以跳过开始时间校验的数据 的redis Key
	
	public final static String IS_SERV_KEY = "IS_SERV";								//是否是服务器--key
	public final static String SERVER_IMG_LOADING_URL = "SERVER_IMG_LOADING_URL";	//值存在数据库
	
	public final static String SYS_LOCK = "SYS_LOCK";
	public final static String CACHE_END_KEY = "CACHE_END_KEY";
	
	public final static String CONFIG_NEED_CACH = bundle.getString("CONFIG_NEED_CACH");		//是否需要cache
	public final static boolean CENTER_CACHE = bundle.containsKey("CENTER_CACHE") && bundle.getString("CENTER_CACHE").equalsIgnoreCase("y");
	
	
	/**
	 * seqBEAN的名称
	 */
	public final static String BEAN_NAME_MWM_COMMONS_BMO = "mwmCommonsBmo";
	public final static String NEED_CHECK_LOGIN = bundle.getString("NEED_CHECK_LOGIN");
	public final static String NEED_CHECK_PERMITION = bundle.getString("NEED_CHECK_PERMITION");
	public final static String IS_DEPLOY_WITH_CONTEXT = bundle.getString("IS_DEPLOY_WITH_CONTEXT");
	
	/**
	 * 支付方式
	 */
	//现金支付
	public final static Integer PAY_TYPE_XJ = 1;
	//银联支付
	public final static Integer PAY_TYPE_YL = 2;
	//微信支付
	public final static Integer PAY_TYPE_WX = 3;
	//支付宝支付
	public final static Integer PAY_TYPE_ZFB = 4;
	//账户余额支付
	public final static Integer PAY_TYPE_YE = 5;
}
