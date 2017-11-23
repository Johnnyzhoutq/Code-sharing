package com.mwm.env.controller;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Preconditions;
import com.mwm.commons.controller.BaseController;
import com.mwm.commons.util.IAnonymousRequest;
import com.mwm.env.envConst.CommonUtil;
import com.mwm.env.envConst.EnvConst;
import com.mwm.env.mybatis.modal.ProvideInfo;
import com.mwm.env.mybatis.modal.UserInfo;
import com.mwm.env.service.IProviderService;
import com.mwm.env.util.UserUtil;

/**
 * 供应方
 * @author heruoyu
 *
 */
@Controller
@RequestMapping("provider")
public class ProviderController extends BaseController implements IAnonymousRequest{

	@Autowired
	private IProviderService providerService;
	
	/******************************************供应方*******************************************/
	
	/**
	 * @api {GET} /provider 供应方-获取信息
	 * @apiName geProviderInfo
	 * @apiGroup provider
	 *
	 * @apiSuccess {String} companyname 企业名称
	 * @apiSuccess {String} orgcode 组织机构代码
	 * @apiSuccess {String} measurecerturl 计量认证证书
	 * @apiSuccess {String} detectioncapabilityurl 监测能力附表
	 */
	@RequestMapping(method=RequestMethod.GET)
	public void geProviderInfo(){
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		//获取供应方信息
		Map returnMap = providerService.getProviderInfo(provider.getProvideid());
		this.setSuccessJsonFromData(CommonUtil.toLowerCaseForMap(returnMap));
	}
	
	/**
	 * @api {POST} /provider 供应方-成为供应方
	 * @apiName addProviderInfo
	 * @apiGroup provider
	 *
	 * @apiParam {String} measurecerturl 计量认证证书
	 * @apiParam {String} detectioncapabilityurl 监测能力附表
	 */
	@RequestMapping(method=RequestMethod.POST)
	public void addProviderInfo(){
		UserInfo user = UserUtil.getUser(getRequest());
		
		//获取参数
		String measureCertUrl = reqString("measurecerturl");
		String detectionCapabilityUrl = reqString("detectioncapabilityurl");
		
		//校验
		Preconditions.checkArgument(StringUtils.isNotEmpty(measureCertUrl),"请上传计量认证证书");
		Preconditions.checkArgument(StringUtils.isNotEmpty(detectionCapabilityUrl),"请上传监测能力附表");
		
		//包装
		ProvideInfo provider = new ProvideInfo();
		provider.setAuditstatus(EnvConst.USER_AUDIT_STATUS_NOT);
		provider.setAuditstute(EnvConst.USER_AUDIT_STATUS_NOT);
		provider.setCreatedate((new Date()).getTime());
		provider.setUserid(user.getUserid());
		provider.setUsertype(user.getUsertype());
		
		providerService.addProviderInfo(provider);
		
		this.setSuccessJsonFromData();
	}
	
	/******************************************供应方等级*******************************************/
	
	/**
	 * @api {PUT} /provider/member 供应方等级- 成为金(银)牌供应商 
	 * @apiName updateProviderInfo
	 * @apiGroup provider
	 *
	 * @apiParam {String} membershipcode 会员等级code（LEVEL_NORMAL：普通  LEVEL_SLIVER：银牌 LEVEL_GOLD金牌）
	 * @apiParam {int} openedway 开通方式（0永久1、月2、年）
	 * @apiParam {String} openedcontent 开通信息
	 */
	@RequestMapping(method=RequestMethod.PUT,value="member")
	public void updateProviderInfo(){
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		
		//获取参数
		String membershipcode = reqString("openedcontent");
		Integer openedway = reqInt("openedway", null);
		Integer openedcontent = reqInt("openedcontent",null);
		String amountpaid = reqString("amountpaid");
		
		//校验参数
		Preconditions.checkArgument(StringUtils.isNotEmpty(membershipcode),"请选择会员类型");
		Preconditions.checkNotNull(openedway,"请选择开通方式");
		if(openedway != 0){
			Preconditions.checkNotNull(openedcontent,"请填写开通信息");
		}
		
		//TODO 修改用户等级，支付完成回调之后，再修改用户等级信息,应该加一个订单表
		
		this.setSuccessJsonFromData();
	}
	
	/******************************************会员等级信息*******************************************/
	
	/**
	 * @api {PUT} /provider/membership/:code 等级信息-获取等级信息
	 * @apiName getMemberInfo
	 * @apiGroup provider
	 *
	 * @apiSuccess {String} membershipname 会员等级名称
	 * @apiSuccess {String} membershipcode 会员等级code
	 * @apiSuccess {String} regulation 前置规则
	 * @apiSuccess {String} applyway 申请方式
	 * @apiSuccess {decimal} amoutpaid 支付金额
	 * @apiSuccess {decimal} incomratio 收入比例
	 * @apiSuccess {String} period 使用期限
	 * @apiSuccess {decimal} createdate 创建时间
	 */
	@RequestMapping(method=RequestMethod.PUT,value="member/{code}")
	public void getMemberInfo(@PathVariable("code") String code){
		this.setSuccessJsonFromData(providerService.getMemberShipInfoByCode(code));
	}
	
}
