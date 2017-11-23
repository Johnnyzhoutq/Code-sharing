package com.mwm.env.controller;

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
import com.mwm.commons.util.ValidateUtil;
import com.mwm.env.envConst.CommonUtil;
import com.mwm.env.mybatis.modal.AddressInfo;
import com.mwm.env.mybatis.modal.UserInfo;
import com.mwm.env.service.IAddressService;
import com.mwm.env.util.UserUtil;

@Controller
@RequestMapping("address")
public class AddressController extends BaseController implements IAnonymousRequest{
	
	@Autowired
	private IAddressService addressService;
	
	/**
	 * @api {GET} /address 获取地址信息（list）
	 * @apiName address
	 * @apiGroup address
	 * 
	 * @apiParam {String} page 页码（默认1）
	 * @apiParam {String} pageSize 每页数据条数（默认10）
	 *
	 * @apiSuccess {String} addressid 地址编号
	 * @apiSuccess {String} receiver 收货人
	 * @apiSuccess {String} address 地址
	 * @apiSuccess {String} receiverphone 联系手机
	 * @apiSuccess {int} defaultflag 默认标记（0非默认地址，1默认地址）
	 */
	@RequestMapping(method=RequestMethod.GET)
	public void getAddressInfo(){
		UserInfo user = UserUtil.getUser(getRequest());
		
		Map params = new HashMap<>();
		params.put("userId", user.getUserid());
		
		PageInfo page = new PageInfo<>();
		page.setPageNum(reqInt("page", 1));
		page.setPageSize(reqInt("pageSize", 10));
		List<AddressInfo> list = addressService.userAddress(params, page);
		page = new PageInfo<>(list);
		
		//加上分页数据
		Map returnMap = new HashMap<>();
		returnMap.put("pagenum", page.getPageNum());
		returnMap.put("pagesize", page.getPageSize());
		returnMap.put("pagetotal", page.getTotal());
		returnMap.put("content", list);
		
		this.setSuccessJsonFromData(returnMap);
	}
	
	/**
	 * @api {POST} /address 新增地址信息
	 * @apiName addAddressInfo
	 * @apiGroup address
	 *
	 * @apiParam {String} receiver 收货人
	 * @apiParam {String} address 地址
	 * @apiParam {String} receiverphone 联系手机
	 * @apiParam {int} defaultflag 默认标记（0非默认地址，1默认地址）(选填)
	 */
	@RequestMapping(method=RequestMethod.POST)
	public void addAddressInfo(){
		UserInfo user = UserUtil.getUser(getRequest());
		
		String receiver = reqString("receiver");
		String address = reqString("address");
		String receiverPhone = reqString("receiverphone");
		String defaultFlag = reqString("defaultflag");
		
		Preconditions.checkArgument(StringUtils.isNotEmpty(receiver),"请输入收货人");
		Preconditions.checkArgument(StringUtils.isNotEmpty(address),"请输入收货地址");
		Preconditions.checkArgument(StringUtils.isNotEmpty(receiverPhone),"请输入联系手机");
		Preconditions.checkArgument(ValidateUtil.Mobile(receiverPhone),"手机号码格式错误");
		
		AddressInfo addressInfo = new AddressInfo();
		addressInfo.setAddress(address);
		addressInfo.setCreatedate((new Date()).getTime());
		addressInfo.setDefaultflag(StringUtils.isEmpty(defaultFlag)?"0":"1");
		addressInfo.setModifydate((new Date()).getTime());
		addressInfo.setReceiver(receiver);
		addressInfo.setReceiverphone(receiverPhone);
		addressInfo.setState(Const.STATE_NORMAL);
		addressInfo.setUserid(user.getUserid());
		
		int addressId = addressService.addOrEditAddress(addressInfo);
		addressInfo.setAddressid(addressId);
		
		this.setSuccessJsonFromData(addressInfo);
	}
	
	/**
	 * @api {PUT} /address/:id 修改地址信息
	 * @apiName updateAddressInfo
	 * @apiGroup address
	 *
	 * @apiParam {String} receiver 收货人
	 * @apiParam {String} address 地址
	 * @apiParam {String} receiverphone 联系手机
	 * @apiParam {int} defaultflag 默认标记（0非默认地址，1默认地址）(选填)
	 */
	@RequestMapping(method=RequestMethod.PUT,value="{id}")
	public void updateAddressInfo(@PathVariable("id") int id){
		
		String receiver = reqString("receiver");
		String address = reqString("address");
		String receiverPhone = reqString("receiverphone");
		String defaultFlag = reqString("defaultflag");
		
		AddressInfo addressInfo = new AddressInfo();
		addressInfo.setAddressid(id);
		addressInfo.setAddress(address);
		addressInfo.setDefaultflag(StringUtils.isEmpty(defaultFlag)?"0":"1");
		addressInfo.setModifydate((new Date()).getTime());
		addressInfo.setReceiver(receiver);
		addressInfo.setReceiverphone(receiverPhone);
		
		addressService.addOrEditAddress(addressInfo);
		
		this.setSuccessJsonFromData(addressInfo);
	}
	
	/**
	 * @api {DELETE} /address/:id 删除地址信息
	 * @apiName delAddressInfo
	 * @apiGroup address
	 *
	 * @apiParam {String} addressId 地址编号
	 */
	@RequestMapping(method=RequestMethod.DELETE,value="{id}")
	public void delAddressInfo(@PathVariable("id") int id){
		addressService.delAddress(id);
		this.setSuccessJsonFromData();
	}
}
