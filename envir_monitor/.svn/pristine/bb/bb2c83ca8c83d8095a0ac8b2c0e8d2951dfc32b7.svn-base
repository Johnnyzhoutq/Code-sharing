package com.mwm.commons.controller;

import org.aspectj.bridge.ICommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.base.Preconditions;
import com.mwm.commons.service.IMWMCommonsService;
import com.mwm.commons.util.IAnonymousRequest;

/**
 * 通用接口
 * @author hery
 *
 */
@Controller
@RequestMapping("WebCommon")
public class WebCommonController extends BaseController implements IAnonymousRequest{
	
	@Autowired
	private IMWMCommonsService commonService;

	/**
	 * @api {POST} /WebCommon/getCityById 根据id获取城市
	 * @apiGroup WebCommon
	 * 
	 * @apiParam {String} id 城市ID
	 * 
	 */
	@RequestMapping("getCityById")
	public void getCityById(){
		int id = reqInt("id", 0);
		Preconditions.checkArgument(id != 0,"城市ID不存在");
		this.setSuccessJsonFromData(commonService.getCityById(id));
	}
	
	/**
	 * @api {POST} /WebCommon/getCitiesByParentId 根据父城市ID获取子城市
	 * @apiGroup WebCommon
	 * 
	 * @apiParam {String} parentId 父城市ID
	 * 
	 */
	@RequestMapping("getCitiesByParentId")
	public void getCitiesByParentId(){
		int parentId = reqInt("parentId", 0);
		Preconditions.checkArgument(parentId != 0,"城市ID不存在");
		this.setSuccessJsonFromData(commonService.getCitiesByParentId(parentId));
	}
	
	/**
	 * @api {POST} /WebCommon/getProvinces 获取所有的省
	 * @apiGroup WebCommon
	 * 
	 */
	@RequestMapping("getProvinces")
	public void getProvinces(){
		this.setSuccessJsonFromData(commonService.getProvinces());
	}
}
