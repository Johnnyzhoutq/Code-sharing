package com.mwm.env.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mwm.commons.controller.BaseController;
import com.mwm.commons.util.IAnonymousRequest;

/**
 * 系统消息
 * @author heruoyu
 *
 */
@Controller
@RequestMapping("message")
public class MessageController  extends BaseController implements IAnonymousRequest{
	
	/**
	 * @api {GET} /message 获取系统信息（list）
	 * @apiName getMessageInfo
	 * @apiGroup message
	 *
	 * @apiParam {String} keyword 搜索关键词
	 * @apiParam {int} timeFrame 时间范围（1、当日2、一周3、一个月4、三个月5、一年）
	 * @apiParam {int} page 页码
	 * @apiParam {int} pageSize 每页条数
	 * 
	 * @apiSuccess {String} title 消息标题
	 * @apiSuccess {String} content 内容
	 * @apiSuccess {String} sendTime 发送时间
	 * @apiSuccess {String} state 状态（1、已读，2、未读）
	 * @apiSuccess {String} page 页码
	 * @apiSuccess {String} pageNum 信息总条数
	 */
	@RequestMapping(method=RequestMethod.GET)
	public void getMessageInfo(){
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {GET} /message/:id 系统信息详情
	 * @apiName getMessageDetail
	 * @apiGroup message
	 * 
	 * @apiSuccess {String} title 消息标题
	 * @apiSuccess {String} content 内容
	 * @apiSuccess {String} sendTime 发送时间
	 */
	@RequestMapping(method=RequestMethod.GET,value="{id}")
	public void getMessageDetail(){
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {GET} /message/excel 导出excel
	 * @apiName excel
	 * @apiGroup message
	 *
	 * @apiParam {String} keyword 搜索关键词
	 * @apiParam {int} timeFrame 时间范围（1、当日2、一周3、一个月4、三个月5、一年）
	 * 
	 * @apiSuccess {String} excelUrl excel下载地址
	 */
	@RequestMapping(method=RequestMethod.GET,value="excel")
	public void excel(){
		this.setSuccessJsonFromData();
	}
}
