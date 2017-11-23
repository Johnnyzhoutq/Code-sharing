package com.mwm.env.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.mwm.commons.controller.BaseController;
import com.mwm.commons.util.IAnonymousRequest;
import com.mwm.env.mybatis.modal.IndexTypeInfo;
import com.mwm.env.mybatis.modal.MasterOrderInfo;
import com.mwm.env.mybatis.modal.UserInfo;
import com.mwm.env.service.ICartService;
import com.mwm.env.service.IOrderService;
import com.mwm.env.util.UserUtil;

/**
 * 购物车模块
 * @author heruoyu
 *
 */
@Controller
@RequestMapping("cart")
public class CartController extends BaseController implements IAnonymousRequest{
	
	@Autowired
	private ICartService cartService;
	@Autowired
	private IOrderService orderService;
	
	/**************************购物车相关**********************************/
	
	/**
	 * @api {GET} /cart 购物车-获取（list）
	 * @apiName getCart
	 * @apiGroup card
	 * 
	 * @apiSuccess {int} slaveid 子订单ID
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
	@RequestMapping(method = RequestMethod.GET)
	public void getCart(){
		UserInfo user = UserUtil.getUser(getRequest());
		
		Map content = new HashMap<>();
		//获取购物车主订单
		MasterOrderInfo cartOrder = cartService.getMasterCart(user.getUserid());
		content.put("cartOrder", cartOrder);
		
		//获取购物车自订单
		Map params = new HashMap<>();
		params.put("masterId", cartOrder.getMasterid());
		
		PageInfo page = new PageInfo<>();
		page.setPageNum(reqInt("page", 1));
		page.setPageSize(reqInt("pageSize", 10));
		List<Map> slaveOrders = cartService.getSlaveOrderForCart(params,page);
		page = new PageInfo<>(slaveOrders);
		content.put("slaveOrder", slaveOrders);
		
		//加上分页数据
		Map returnMap = new HashMap<>();
		returnMap.put("pagenum", page.getPageNum());
		returnMap.put("pagesize", page.getPageSize());
		returnMap.put("pagetotal", page.getTotal());
		returnMap.put("content", content);

		this.setSuccessJsonFromData(returnMap);
	}
	
	/**
	 * @api {POST} /cart 购物车-新增
	 * @apiName addCart
	 * @apiGroup card
	 * 
	 * @apiParam {String} goods  商品编号
	 * @apiParam {String} dwelltimes  采样时间（["2016-10-6","2016-10-7"]）
	 * 
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void addCart(){
		UserInfo user = UserUtil.getUser(getRequest());
		
		//获取参数
		int goods = reqInt("goods", 0);
		String dwelltimes = reqString("dwelltimes");
		
		//校验
		Preconditions.checkArgument(goods != 0 ,"请选择商品");
		Preconditions.checkArgument(StringUtils.isNotEmpty(dwelltimes) ,"请选择采样时间");
		
		//新增购物车
		cartService.addCartGoods(user.getUserid(),goods,dwelltimes);
		
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {PUT} /cart 购物车-编辑（添加项目信息）
	 * @apiName updateCart
	 * @apiGroup card
	 * 
	 * @apiSuccess {String} projectname 项目名称
	 * @apiSuccess {String} detectiontype 监测类别
	 * @apiSuccess {String} requester 监测单位
	 * @apiSuccess {String} invoicetype 发票类型
	 * @apiSuccess {String} invoicecontent 发票内容
	 * 
	 */
	@RequestMapping(method = RequestMethod.PUT)
	public void updateCart(){
		UserInfo user = UserUtil.getUser(getRequest());
		
		String projectname = reqString("projectname");
		String detectiontype = reqString("detectiontype");
		String requester = reqString("requester");
		String invoicetype = reqString("invoicetype");
		String invoicecontent = reqString("invoicecontent");
		
		Preconditions.checkArgument(StringUtils.isNotEmpty(projectname),"请输入项目名称");
		Preconditions.checkArgument(StringUtils.isNotEmpty(detectiontype),"请输入监测类别");
		Preconditions.checkArgument(StringUtils.isNotEmpty(requester),"请输入监测单位");
		Preconditions.checkArgument(StringUtils.isNotEmpty(invoicetype),"请输入发票类型");

		//获取购物车主订单
		MasterOrderInfo orderInfo = cartService.getMasterCart(user.getUserid());
		Preconditions.checkNotNull(orderInfo,"购物车不存在");
		
		//设置主订单
		orderInfo.setProjectname(projectname);
		orderInfo.setDetectiontype(detectiontype);
		orderInfo.setRequester(requester);
		orderInfo.setInvoicetype(invoicetype);
		orderInfo.setInvoicecontent(invoicecontent);
		
		orderService.addOrEditMasterOrder(orderInfo);
		
		this.setSuccessJsonFromData(orderInfo);
	}
	
	/**
	 * @api {DELETE} /cart/:slaveId 购物车-删除
	 * @apiName delCart
	 * @apiGroup card
	 * 
	 * @apiParam {int} slaveid 子订单ID
	 * 
	 */
	@RequestMapping(method = RequestMethod.DELETE ,value="/{id}")
	public void delCart(@PathVariable("id") long slaveId){
		orderService.delSlaveOrderById(slaveId);
		this.setSuccessJsonFromData();
	}
	
}
