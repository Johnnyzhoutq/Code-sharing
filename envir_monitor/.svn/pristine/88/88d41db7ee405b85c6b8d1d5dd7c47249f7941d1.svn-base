 package com.mwm.env.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.pagehelper.PageInfo;
import com.mwm.commons.controller.BaseController;
import com.mwm.commons.util.IAnonymousRequest;
import com.mwm.env.dao.IOrderDao;
import com.mwm.env.envConst.CommonUtil;
import com.mwm.env.mybatis.modal.AddressInfo;
import com.mwm.env.mybatis.modal.UserInfo;
import com.mwm.env.service.IOrderService;
import com.mwm.env.util.UserUtil;

/**
 * 需求方订单
 * @author heruoyu
 *
 */
@Controller
@RequestMapping("demander/order")
public class DemanderOrderController extends BaseController implements IAnonymousRequest {

	@Autowired
	private IOrderService orderService;
	
	/**
	 * @api {GET} demander/order 需求方订单-获取
	 * @apiName getDemanderOrder
	 * @apiGroup demandOrder
	 * @apiDescription 返回数据为  主订单信息 里面包含 array的自订单信息
	 * 
	 * @apiParam {String} masterid 主订单订单ID（可选）
	 * @apiParam {bigint} timeframe 时间范围（可选）
	 * @apiParam {int} auditstatus 审核状态（0未通过1通过）（可选）
	 * @apiParam {int} process 订单流程
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
	@RequestMapping(method = RequestMethod.GET)
	public void getDemanderOrder(){
		UserInfo user = UserUtil.getUser(getRequest());
		
		Integer masterid = reqInt("masterid", null);
		String timeframe = reqString("timeframe");
		Integer auditstatus = reqInt("auditstatus", null);
		
		Map params = new HashMap<>();
		params.put("userid", user.getUserid());
		params.put("masterid",masterid);
		params.put("timeframe",timeframe);
		params.put("auditstatus",auditstatus);
		
		PageInfo page = new PageInfo<>();
		page.setPageNum(reqInt("page", 1));
		page.setPageSize(reqInt("pageSize", 10));
		Map orderMap = orderService.getMasterOrderList(params, page);
		List<Map> orders = (List<Map>) orderMap.get("orders");
		page = (PageInfo) orderMap.get("page");
		
		//加上分页数据
		Map returnMap = new HashMap<>();
		returnMap.put("pagenum", page.getPageNum());
		returnMap.put("pagesize", page.getPageSize());
		returnMap.put("pagetotal", page.getTotal());
		returnMap.put("content", CommonUtil.toLowerCaseForList(orders));
		
		this.setSuccessJsonFromData(returnMap);
	}
	
	/**
	 * @api {POST} demander/order 需求方订单-新增
	 * @apiName addDemanderOrder
	 * @apiGroup demandOrder
	 * 
	 * @apiParam {int} masterid 主订单id
	 * @apiParam {JSON} slaveids 子订单列表
	 */
	public void addDemanderOrder(){
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {POST} demander/order/status/:id 需求方订单-确认收货
	 * @apiName completeDemanderOrder
	 * @apiGroup demandOrder
	 * 
	 * @apiParam {int} masterid 主订单id
	 */
	public void completeDemanderOrder(){
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {POST} demander/order/:id 需求方订单-删除（取消订单）
	 * @apiName delDemanderOrder
	 * @apiGroup demandOrder
	 * 
	 * @apiParam {int} masterid 主订单id
	 */
	public void delDemanderOrder(){
		this.setSuccessJsonFromData();
	}
	
}
