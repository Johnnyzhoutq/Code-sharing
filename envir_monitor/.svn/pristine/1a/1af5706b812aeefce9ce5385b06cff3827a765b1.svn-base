package com.mwm.env.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mwm.commons.controller.BaseController;
import com.mwm.commons.util.IAnonymousRequest;

/**
 * 供应方订单
 * @author heruoyu
 *
 */
@Controller
@RequestMapping("provider/order")
public class ProviderOrderController extends BaseController implements IAnonymousRequest {

	/**
	 * @api {GET} provider/order 供应方订单-获取
	 * @apiName getProviderOrder
	 * @apiGroup providerOrder
	 * @apiDescription 返回数据为  主订单信息 里面包含 array的自订单信息
	 * 
	 * @apiParam {String} masternum 主订单订单号（可选）
	 * @apiParam {bigint} timeFrame 时间范围（可选）
	 * @apiParam {String} auditstatus 审核状态（0未通过1通过）（可选）
	 * @apiParam {String} process 订单流程
	 * 
	 * @apiSuccess {int} masterid 主订单id
	 * @apiSuccess {String} masternum 主订单订单号
	 * @apiSuccess {String} projectname 项目名称
	 * @apiSuccess {String} detectiontype 监测类别
	 * @apiSuccess {String} requester 监测单位
	 * @apiSuccess {String} receiver 收货人
	 * @apiSuccess {String} address 收货地址
	 * @apiSuccess {String} receiverphone 联系手机
	 * @apiSuccess {String} invoicetype 发票类型
	 * @apiSuccess {String} invoicecontent 发票内容
	 * @apiSuccess {String} process 订单流程
	 * @apiSuccess {String} amount 订单金额
	 * @apiSuccess {String} paymenttime 支付时间
	 * @apiSuccess {String} createdate 创建时间
	 * @apiSuccess {String} completedate 完成时间
	 * 
	 * @apiSuccess {int} slaveid 自订单ID
	 * @apiSuccess {int} goodsid 商品ID
	 * @apiSuccess {int} indexid 指标ID
	 * @apiSuccess {String} indexname 指标名称
	 * @apiSuccess {int} reportid 指标ID
	 * @apiSuccess {String} reportname 指标名称
	 * @apiSuccess {String} price 价格
	 * @apiSuccess {int} goodstypeid 商品类型Id
	 * @apiSuccess {String} goodstypename 商品类型名称
	 * @apiSuccess {String} sell 售卖方式
	 * @apiSuccess {String} units 规格
	 * @apiSuccess {String} location 商品所在地
	 * @apiSuccess {String} expirydate 商品有效期
	 * @apiSuccess {String} content 监测内容
	 * @apiSuccess {String} basis 检测依据
	 * @apiSuccess {String} remark 其他
	 * @apiSuccess {String} shelves 上架标识
	 * @apiSuccess {String} auditstatus 审核状态
	 * @apiSuccess {String} createdate 创建时间
	 */
	public void getProviderOrder(){
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {POST} provider/order/:id/slave 供应方订单-编辑（确认子订单）
	 * @apiName confirmProviderOrder
	 * @apiGroup providerOrder
	 * 
	 * @apiParam {int} operate 子订单操作（0取消1确认）
	 * @apiParam {JSON} slaveids 子订单列表
	 */
	public void confirmProviderOrder(){
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {GET} provider/order/:id/slave/:id 供应方订单-子订单-获取（物流信息）
	 * @apiName sendProviderOrder
	 * @apiGroup providerOrder
	 * 
	 * @apiParam {int} slaveid 子订单ID
	 */
	public void getSendProviderOrder(){
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {POST} provider/order/:id/slave/:id 供应方订单-子订单-编辑（添加物流信息）
	 * @apiName sendProviderOrder
	 * @apiGroup providerOrder
	 * 
	 * @apiParam {String} deliverycompany 物流公司
	 * @apiParam {String} deliverynum 物流单号
	 * @apiParam {int} slaveid 子订单ID
	 */
	public void sendProviderOrder(){
		this.setSuccessJsonFromData();
	}
}
