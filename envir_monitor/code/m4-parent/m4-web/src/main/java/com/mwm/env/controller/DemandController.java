package com.mwm.env.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.mwm.commons.commonConst.Const;
import com.mwm.commons.controller.BaseController;
import com.mwm.commons.util.IAnonymousRequest;
import com.mwm.env.envConst.CommonUtil;
import com.mwm.env.mybatis.modal.DemandInfo;
import com.mwm.env.mybatis.modal.DemandLibInfo;
import com.mwm.env.mybatis.modal.IndexInfo;
import com.mwm.env.mybatis.modal.ProvideInfo;
import com.mwm.env.mybatis.modal.UserInfo;
import com.mwm.env.service.IDemandService;
import com.mwm.env.util.EnvUtils;
import com.mwm.env.util.UserUtil;

/**
 * 需求方-需求集
 * @author heruoyu
 *
 */
@Controller
@RequestMapping("/demandLib")
public class DemandController extends BaseController implements IAnonymousRequest{
	
	@Autowired
	private IDemandService demandService;

	/*******************************需求集*************************/
	/**
	 * @api {GET} demandLib 需求集-获取
	 * @apiName getDemandLib
	 * @apiGroup demandLib
	 *
	 * @apiParam {String} demandlibname 需求集名称(可选)
	 * @apiparam {int} page 页码(可选)
	 * @apiparam {int} pageSize 每页显示的内容数(可选)
	 *
	 * @apiSuccess {int} demandlibid 需求集ID
	 * @apiSuccess {String} demandlibname 方案名称
	 * @apiSuccess {String} demandlibdesc 方案描述
	 * @apiSuccess {String} createdate 创建时间
	 */
	@RequestMapping(method = RequestMethod.GET)
	public void getDemandLib() {
		UserInfo user = UserUtil.getUser(getRequest());
		
		//包装参数
		String demandlibname = reqString("demandlibname");
		
		Map params = new HashMap<>();
		params.put("demandlibname", demandlibname);
		params.put("userId", user.getUserid());
		
		//分页查
		PageInfo page = new PageInfo<>();
		page.setPageNum(reqInt("page", 1));
		page.setPageSize(reqInt("pageSize", 10));
		List<Map> demandLibInfo = demandService.getDemandLib(params, page);
		page = new PageInfo<>(demandLibInfo);
		
		//加上分页数据
		Map returnMap = new HashMap<>();
		returnMap.put("pagenum", page.getPageNum());
		returnMap.put("pagesize", page.getPageSize());
		returnMap.put("pagetotal", page.getTotal());
		returnMap.put("content", CommonUtil.toLowerCaseForList(demandLibInfo));
		
		this.setSuccessJsonFromData(returnMap);
	}
	
	/**
	 * @api {POST} demandLib 需求集-新增
	 * @apiName addDemandLib
	 * @apiGroup demandLib
	 *
	 * @apiSuccess {String} demandlibname 方案名称
	 * @apiSuccess {String} demandlibdesc 方案描述（可选）
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void addDemandLib() {
		UserInfo user = UserUtil.getUser(getRequest());
		
		//获取参数
		String demandlibname = reqString("demandlibname");
		String demandlibdesc = reqString("demandlibdesc");
		
		Preconditions.checkArgument(StringUtils.isNotEmpty(demandlibname),"请输入方案名称");
		
		//封装
		DemandLibInfo demandLib = new DemandLibInfo();
		demandLib.setCreatedate((new Date()).getTime());
		demandLib.setDemandlibdesc(demandlibdesc);
		demandLib.setDemandlibname(demandlibname);
		demandLib.setState(Const.STATE_NORMAL);
		demandLib.setUserid(user.getUserid());
		
		int demandLibId = demandService.addOrEditDemandLib(demandLib);
		demandLib.setDemandlibid(demandLibId);
		
		this.setSuccessJsonFromData(demandLib);
	}
	
	/**
	 * @api {PUT} demandLib/:id 需求集-编辑
	 * @apiName editDemandLib
	 * @apiGroup demandLib
	 *
	 * @apiSuccess {String} demandlibiname 方案名称
	 * @apiSuccess {String} demandlibdesc 方案描述
	 */
	@RequestMapping(method = RequestMethod.PUT,value="{id}")
	public void editDemandLib(@PathVariable int id) {
		UserInfo user = UserUtil.getUser(getRequest());
		
		//获取参数
		String demandlibname = reqString("demandlibname");
		String demandlibdesc = reqString("demandlibdesc");
		
		Preconditions.checkArgument(StringUtils.isNotEmpty(demandlibname),"请输入方案名称");
		
		//封装
		DemandLibInfo demandLib = new DemandLibInfo();
		demandLib.setDemandlibid(id);
		demandLib.setDemandlibdesc(demandlibdesc);
		demandLib.setDemandlibname(demandlibname);
		demandLib.setState(Const.STATE_NORMAL);
		demandLib.setUserid(user.getUserid());
		
		demandService.addOrEditDemandLib(demandLib);
		
		this.setSuccessJsonFromData(demandLib);
	}
	
	/**
	 * @api {DELETE} demandLib/:id 需求集-删除
	 * @apiName delDemandLib
	 * @apiGroup demandLib
	 */
	@RequestMapping(method = RequestMethod.DELETE,value="{id}")
	public void delDemandLib(@PathVariable int id) {
		UserInfo user = UserUtil.getUser(getRequest());
		demandService.delDemandLib(user.getUserid(),id);
		this.setSuccessJsonFromData();
	}
	
	
	/*******************************需求集-需求*************************/
	
	/**
	 * @api {GET} demandLib/:id/demand 需求集-需求-获取
	 * @apiName getDemand
	 * @apiGroup demandLib
	 * 
	 * @apiParam {String} demandname 需求名称(可选)
	 * @apiparam {int} page 页码(可选)
	 * @apiparam {int} pageSize 每页显示的内容数(可选)
	 * 
	 * @apiSuccess {String} demandid 需求Id
	 * @apiSuccess {String} demandname 需求名称
	 */
	@RequestMapping(method = RequestMethod.GET,value="{demandlibid}/demand")
	public void getDemand(@PathVariable int demandlibid) {
		UserInfo user = UserUtil.getUser(getRequest());
		
		//包装参数
		String demandname = reqString("demandname");
		
		Map params = new HashMap<>();
		params.put("demandname", demandname);
		params.put("userId", user.getUserid());
		params.put("demandlibid", demandlibid);
		
		//分页查
		PageInfo page = new PageInfo<>();
		page.setPageNum(reqInt("page", 1));
		page.setPageSize(reqInt("pageSize", 10));
		List<Map> demandLibInfo = demandService.getDemandList(params, page);
		page = new PageInfo<>(demandLibInfo);
		
		//加上分页数据
		Map returnMap = new HashMap<>();
		returnMap.put("pagenum", page.getPageNum());
		returnMap.put("pagesize", page.getPageSize());
		returnMap.put("pagetotal", page.getTotal());
		returnMap.put("content", CommonUtil.toLowerCaseForList(demandLibInfo));
		
		this.setSuccessJsonFromData(returnMap);
	}
	
	/**
	 * @api {POST} demandLib/:id/demand 需求集-需求-新增
	 * @apiName addDemand
	 * @apiGroup demandLib
	 *
	 * @apiSuccess {String} demandname 需求名称
	 */
	@RequestMapping(method = RequestMethod.POST,value="{demandlibid}/demand")
	public void addDemand(@PathVariable int demandlibid) {
		UserInfo user = UserUtil.getUser(getRequest());
		
		String demandname = reqString("demandname");
		
		Preconditions.checkArgument(StringUtils.isNotEmpty(demandname),"请输入需求名称");
		
		DemandInfo demand = new DemandInfo();
		demand.setDemandlibid(demandlibid);
		demand.setDemandname(demandname);
		demand.setUserid(user.getUserid());
		
		int demandId = demandService.addOrEditDemand(demand);
		demand.setDemandid(demandId);
		
		this.setSuccessJsonFromData(demand);
	}
	
	/**
	 * @api {DELETE} demandLib/:id/demand/:demandId 需求集-需求-删除
	 * @apiName delDemand
	 * @apiGroup demandLib
	 *
	 * @apiSuccess {String} demandiname 需求名称
	 */
	@RequestMapping(method = RequestMethod.DELETE,value="{demandlibid}/demand/{demandid}")
	public void delDemand(@PathVariable int demandlibid,@PathVariable int demandid) {
		UserInfo user = UserUtil.getUser(getRequest());
		demandService.delDemand(demandid,demandlibid,user.getUserid());
		this.setSuccessJsonFromData();
	}
}
