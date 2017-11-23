package com.mwm.env.controller;

import java.io.UnsupportedEncodingException;
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
import com.mwm.commons.controller.BaseController;
import com.mwm.commons.exception.MwmRuntimeException;
import com.mwm.commons.util.IAnonymousRequest;
import com.mwm.env.envConst.CommonUtil;
import com.mwm.env.envConst.EnvConst;
import com.mwm.env.mybatis.modal.DataGoodsInfoWithBLOBs;
import com.mwm.env.mybatis.modal.IndexInfo;
import com.mwm.env.mybatis.modal.IndexTypeInfo;
import com.mwm.env.mybatis.modal.ProvideInfo;
import com.mwm.env.mybatis.modal.ReportInfo;
import com.mwm.env.service.IDataGoodsInfoService;
import com.mwm.env.service.IIndexService;
import com.mwm.env.util.EnvUtils;
import com.mwm.env.util.UserUtil;

import net.sf.json.JSONObject;

/**
 * 指标商品
 * @author heruoyu
 *
 */
@Controller
@RequestMapping("/dataGoods")
public class DataGoodsController extends BaseController implements IAnonymousRequest{
	
	@Autowired
	private IDataGoodsInfoService dataGoodsInfoService;
	@Autowired
	private IIndexService indexService;

	/**
	 * @throws UnsupportedEncodingException 
	 * @api {GET} dataGoods 商品列表（列表，该接口参数均为可选）
	 * @apiName getDataGoods
	 * @apiGroup dataGoods
	 * 
	 * @apiparam {String} location 地址信息,格式:{lon:xxxx,lat:xxxx,range:400}
	 * @apiparam {String} indexname 模板名称
	 * @apiparam {int} indextypeId 商品类型ID
	 * @apiparam {int} shelves 上架状态（0下架，1上架，不填全部）
	 * @apiparam {int} auditstatus 审核状态（0未通过，1通过）
	 * @apiparam {String} sortfiled 排序字段（Createdate:上传时间，UnitPrice价格   采样时间？）
	 * @apiparam {String} page 页码
	 * @apiparam {String} pageSize 每页数量
	 *
	 * @apiSuccess {int} goodsid 商品ID
	 * @apiSuccess {int} indexid 指标ID
	 * @apiSuccess {String} indexname 指标名称
	 * @apiSuccess {int} reportid 指标ID
	 * @apiSuccess {String} reportname 指标名称
	 * @apiSuccess {String} price 报价
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
	 * 
	 */
	@RequestMapping(method=RequestMethod.GET)
	public void getDataGoods() throws UnsupportedEncodingException{
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		//组装参数
		Map params = new HashMap<>();
		params.put("indexName", reqString("indexname"));
		params.put("indexTypeId", reqString("indextypeId"));
		params.put("shelves", reqString("shelves"));
		params.put("sortFiled", reqString("sortfiled"));
		params.put("sort", reqString("sort"));
		params.put("auditStatus", reqString("auditstatus"));
		params.put("providerId", provider.getProvideid());
		
		//获取地图信息
		String location = reqString("location");
		if(StringUtils.isNotEmpty(location)){
			JSONObject obj = JSONObject.fromObject(location);
			Preconditions.checkNotNull(obj.get("lon"),"地图信息错误");
			Preconditions.checkNotNull(obj.get("lat"),"地图信息错误");
			Preconditions.checkNotNull(obj.get("range"),"地图信息错误");
			params.put("lon", obj.get("lon"));
			params.put("lat", obj.get("lat"));
			params.put("range", obj.get("range"));
		}
		
		//分页查
		PageInfo page = new PageInfo<>();
		page.setPageNum(reqInt("page", 1));
		page.setPageSize(reqInt("pageSize", 10));
		List<Map> result = dataGoodsInfoService.queryDataGoodsInfo(params, page);
		page = new PageInfo<>(result);
		
		//包装返回值
		Map returnMap = new HashMap<>();
		returnMap.put("pagenum", page.getPageNum());
		returnMap.put("pagesize", page.getPageSize());
		returnMap.put("pagetotal", page.getTotal());
		returnMap.put("content", CommonUtil.toLowerCaseForList(result));
		
		this.setSuccessJsonFromData(returnMap);
	}
	
	
	/**
	 * @api {GET} dataGoods/:id 商品详情
	 * 
	 * @apiName getDataGoodsById
	 * @apiGroup dataGoods
	 *
	 * @apiSuccess {int} goods 商品ID
	 * @apiSuccess {int} indexid 指标ID
	 * @apiSuccess {int} indexid 指标ID
	 * @apiSuccess {String} indexname 指标名称
	 * @apiSuccess {int} reportid 指标ID
	 * @apiSuccess {String} reportname 指标名称
	 * @apiSuccess {String} price 报价
	 * @apiSuccess {int} goodstypeid 商品类型Id
	 * @apiSuccess {String} goodstypeName 商品类型名称
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
	@RequestMapping(method=RequestMethod.GET,value="/{id}")
	public void getDataGoodsById(@PathVariable int id){
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		
		Map params = new HashMap<>();
		params.put("providerId", provider.getProvideid());
		params.put("goodsId", id);
		
		PageInfo page = new PageInfo<>();
		page.setPageNum(reqInt("page", 1));
		page.setPageSize(reqInt("pageSize", 10));
		List<Map> result = dataGoodsInfoService.queryDataGoodsInfo(params, page);
		page = new PageInfo<>(result);
		
		//包装返回值
		Map returnMap = new HashMap<>();
		returnMap.put("pagenum", page.getPageNum());
		returnMap.put("pagesize", page.getPageSize());
		returnMap.put("pagetotal", page.getTotal());
		returnMap.put("content", CommonUtil.toLowerCaseForList(result));
		
		this.setSuccessJsonFromData(returnMap);
	}
	
	/**
	 * @api {POST} dataGoods 商品新增
	 * @apiName addDataGoods
	 * @apiGroup dataGoods
	 *
	 * @apiparam {int} indexid 指标ID
	 * @apiparam {int} reportid 报告ID
	 * @apiparam {int} indextypeid 指标类型id
	 * @apiparam {int} reportid 关联报告
	 * @apiparam {String} simpletime 采样时间
	 * @apiparam {String} simpletimedetail 采样时间相关内容json串
	 * @apiparam {String} units 规格
	 * @apiparam {String} startdate 有效期开始时间（unix时间戳）
	 * @apiparam {String} enddate 有效期结束时间（unix时间戳）
	 * @apiparam {String} location 商品所在地，格式（{"lon":"123","lat":"123","range":"12312"}）
	 * @apiparam {String} sell 售卖方式（整卖/可单可整）
	 * @apiparam {String} expirydate 商品有效期
	 * @apiparam {String} content 监测内容
	 * @apiparam {String} basis 检测依据
	 * @apiparam {String} remark 其他
	 * @apiparam {String} shelves 上架标识 （审核通过直接上架还是不上架）
	 */
	@RequestMapping(method=RequestMethod.POST)
	public void addDataGoods(){
		//获取用户信息
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		
		//基本参数获取和校验
		Integer indexId = reqInt("indexid", null);
		Integer indexTypeId = reqInt("indextypeid", null);
		Integer reportId = reqInt("reportid", null);
		String simpleTime = reqString("simpletime");
		String simpleTimeDetail = reqString("simpletimedetail");
		String units = reqString("units");
		String startDate = reqString("startdate");
		String endDate = reqString("enddate");
		String expiryDate = reqString("expiredate");
		String location = reqString("location");
		String sell = reqString("sell");
		String content = reqString("content");
		String basis = reqString("basis");
		String remark = reqString("remark");
		
		//校验
		Preconditions.checkNotNull(indexId, "请选择商品母版");
		Preconditions.checkNotNull(indexTypeId, "请选择商品类型");
		Preconditions.checkNotNull(reportId, "请选择关联报告");
//		EnvUtils.validateUnixDate(simpleTime, "采样时间");
//		EnvUtils.validateStrNotNull(simpleTime, "采样时间", 20);
		EnvUtils.validateStrNotNull(units, "规格", 10);
		EnvUtils.validateUnixDate(startDate, "请填写有效期开始时间");
		EnvUtils.validateUnixDate(endDate, "请填写有效期结束时间");
		EnvUtils.validateStrNotNull(expiryDate, "数据有效期", 5);
		EnvUtils.validateStrNotNull(location, "请选择商品所在地", 50);
		EnvUtils.validateStrNotNull(sell, "请选择售卖方式", 1);
		String shelves = reqString("shelves");
		EnvUtils.validateStrNotNull(shelves, "上架方式", 1);
		
		if (!(EnvConst.SHELVES_OFF.equals(shelves)) && !(EnvConst.SHELVES_ON.equals(shelves))) {
			throw new MwmRuntimeException("权限不足");
		}
		if (!(EnvConst.CAN_NOT_SINGLE.equals(sell)) && !(EnvConst.CAN_SINGLE.equals(sell))) {
			throw new MwmRuntimeException("权限不足");
		}
		
		//获取地图信息
		JSONObject obj = JSONObject.fromObject(location);
		
		Preconditions.checkNotNull(obj.get("lon"),"地图信息错误");
		Preconditions.checkNotNull(obj.get("lat"),"地图信息错误");
		Preconditions.checkNotNull(obj.get("range"),"地图信息错误");
		
		
		//指标校验
		IndexInfo indexInfo = new IndexInfo();
		indexInfo.setIndexid(indexId);
		indexInfo.setProvideid(provider.getProvideid());
		indexInfo = indexService.validateIndexInfo(indexInfo);
		
		//指标类型校验
		IndexTypeInfo indexTypeInfo = new IndexTypeInfo();
		indexTypeInfo.setIndextypeid(indexTypeId);
		indexTypeInfo.setProvideid(provider.getProvideid());
		indexTypeInfo = indexService.validateIndexTypeInfo(indexTypeInfo);
		
		//指标报告校验
		ReportInfo reportInfo = new ReportInfo();
		reportInfo.setReportid(reportId);
		reportInfo.setProvideid(provider.getProvideid());
		indexService.validateReportInfo(reportInfo);
		
		//组装参数
		DataGoodsInfoWithBLOBs dataGoodsInfo = new DataGoodsInfoWithBLOBs();
		//地理信息
		dataGoodsInfo.setLon(obj.getString("lon").trim());
		dataGoodsInfo.setLat(obj.getString("lat").trim());
		//dataGoodsInfo.setRanges(obj.getString("range").trim());
		
		dataGoodsInfo.setCreatedate(System.currentTimeMillis());
		dataGoodsInfo.setStartdate(Long.valueOf(startDate));
		dataGoodsInfo.setEnddate(Long.valueOf(endDate));
		dataGoodsInfo.setExpirydate(expiryDate);
		dataGoodsInfo.setGoodstype(indexTypeId);
		dataGoodsInfo.setIndexid(indexId);
		dataGoodsInfo.setLocation(location);
		dataGoodsInfo.setProvideid(provider.getProvideid());
		dataGoodsInfo.setReportid(reportId);
		dataGoodsInfo.setSell(sell);
		dataGoodsInfo.setShelves(shelves);
		dataGoodsInfo.setSimpletime(Long.valueOf(simpleTime));
		dataGoodsInfo.setSimpletimedetail(simpleTimeDetail);
		//dataGoodsInfo.setUnitprice(indexInfo.getIndexprice().multiply(indexTypeInfo.getPricemultiple()));
		dataGoodsInfo.setUnits(units);
		dataGoodsInfo.setBasis(basis);
		dataGoodsInfo.setContent(content);
		dataGoodsInfo.setRemark(remark);
		dataGoodsInfo.setState("N");
		
		//插入数据库
		dataGoodsInfo = dataGoodsInfoService.addOrEditDataGoods(dataGoodsInfo);
		this.setSuccessJsonFromData(dataGoodsInfo);
	}
	
	/**
	 * @api {PUT} dataGoods/:id 商品编辑
	 * @apiName updateDataGoods
	 * @apiGroup dataGoods
	 *
	 * @apiparam {int} indexid 指标ID
	 * @apiparam {int} reportid 报告ID
	 * @apiparam {int} indextypeid 指标类型id
	 * @apiparam {int} reportid 关联报告
	 * @apiparam {String} simpletime 采样时间
	 * @apiparam {String} simpletimedetail 采样时间相关内容json串
	 * @apiparam {String} units 规格
	 * @apiparam {String} startdate 有效期开始时间（unix时间戳）
	 * @apiparam {String} enddate 有效期结束时间（unix时间戳）
	 * @apiparam {String} location 商品所在地，格式（{"lon":"123","lat":"123","range":"12312"}）
	 * @apiparam {String} sell 售卖方式（整卖/可单可整）
	 * @apiparam {String} expirydate 商品有效期
	 * @apiparam {String} content 监测内容
	 * @apiparam {String} basis 检测依据
	 * @apiparam {String} remark 其他
	 * @apiparam {String} shelves 上架标识 （审核通过直接上架还是不上架）
	 */
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public void updateDataGoods(@PathVariable int id){
		//获取用户信息
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		
		//基本参数获取和校验
		Integer indexId = reqInt("indexid", null);
		Integer indexTypeId = reqInt("indextypeid", null);
		Integer reportId = reqInt("reportid", null);
		String simpleTime = reqString("simpletime");
		String simpleTimeDetail = reqString("simpletimedetail");
		String units = reqString("units");
		String startDate = reqString("startdate");
		String endDate = reqString("enddate");
		String expiryDate = reqString("expiredate");
		String location = reqString("location");
		String sell = reqString("sell");
		String content = reqString("content");
		String basis = reqString("basis");
		String remark = reqString("remark");
		
		//校验
		Preconditions.checkNotNull(indexId, "请选择商品母版");
		Preconditions.checkNotNull(indexTypeId, "请选择商品类型");
		Preconditions.checkNotNull(reportId, "请选择关联报告");
//				EnvUtils.validateUnixDate(simpleTime, "采样时间");
//				EnvUtils.validateStrNotNull(simpleTime, "采样时间", 20);
		EnvUtils.validateStrNotNull(units, "规格", 10);
		EnvUtils.validateUnixDate(startDate, "请填写有效期开始时间");
		EnvUtils.validateUnixDate(endDate, "请填写有效期结束时间");
		EnvUtils.validateStrNotNull(expiryDate, "数据有效期", 5);
		EnvUtils.validateStrNotNull(location, "请选择商品所在地", 50);
		EnvUtils.validateStrNotNull(sell, "请选择售卖方式", 1);
		String shelves = reqString("shelves");
		EnvUtils.validateStrNotNull(shelves, "上架方式", 1);
		
		
		//获取地图信息
		JSONObject obj = JSONObject.fromObject(location);
		Preconditions.checkNotNull(obj.get("lon"),"地图信息错误");
		Preconditions.checkNotNull(obj.get("lat"),"地图信息错误");
		Preconditions.checkNotNull(obj.get("range"),"地图信息错误");
		
		//组装参数
		DataGoodsInfoWithBLOBs dataGoodsInfo = new DataGoodsInfoWithBLOBs();
		//地理信息
		dataGoodsInfo.setLon(obj.getString("lon"));
		dataGoodsInfo.setLat(obj.getString("lat"));
		//dataGoodsInfo.setRanges(obj.getString("range"));
		dataGoodsInfo.setGoods(id);
		dataGoodsInfo.setCreatedate(System.currentTimeMillis());
		dataGoodsInfo.setStartdate(Long.valueOf(startDate));
		dataGoodsInfo.setEnddate(Long.valueOf(endDate));
		dataGoodsInfo.setExpirydate(expiryDate);
		dataGoodsInfo.setGoodstype(indexTypeId);
		dataGoodsInfo.setIndexid(indexId);
		dataGoodsInfo.setLocation(location);
		dataGoodsInfo.setProvideid(provider.getProvideid());
		dataGoodsInfo.setReportid(reportId);
		dataGoodsInfo.setSell(sell);
		dataGoodsInfo.setShelves(shelves);
		dataGoodsInfo.setSimpletime(Long.valueOf(simpleTime));
		dataGoodsInfo.setSimpletimedetail(simpleTimeDetail);
//		dataGoodsInfo.setUnitprice(indexInfo.getIndexprice().multiply(indexTypeInfo.getPricemultiple()));
		dataGoodsInfo.setUnits(units);
		dataGoodsInfo.setBasis(basis);
		dataGoodsInfo.setContent(content);
		dataGoodsInfo.setRemark(remark);
		dataGoodsInfo.setState("N");
		
		//插入数据库
		dataGoodsInfo = dataGoodsInfoService.addOrEditDataGoods(dataGoodsInfo);
		this.setSuccessJsonFromData(dataGoodsInfo);
	}
	
	/**
	 * @api {DELETE} dataGoods/:id 商品删除
	 * @apiName delDataGoods
	 * @apiGroup dataGoods
	 */
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	public void delDataGoods(@PathVariable int id){
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		
		DataGoodsInfoWithBLOBs dataGoodsInfo = new DataGoodsInfoWithBLOBs();
		dataGoodsInfo.setProvideid(provider.getProvideid());
		dataGoodsInfo.setGoods(id);
		
		dataGoodsInfoService.deleteDataGoodsInfo(dataGoodsInfo);
		this.setSuccessJsonFromData();
	}
	
	/**
	 * @api {PUT} dataGoods/:id/onsale 商品上架
	 * @apiName saleDataGoods
	 * @apiGroup dataGoods
	 */
	@RequestMapping(method=RequestMethod.PUT,value="/{id}/onsale")
	public void saleDataGoods(@PathVariable int id){
		
		DataGoodsInfoWithBLOBs dataGoodsInfo = new DataGoodsInfoWithBLOBs();
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		dataGoodsInfo.setProvideid(provider.getProvideid());
		dataGoodsInfo.setGoods(id);
		//检查商品是否存在
		dataGoodsInfo = dataGoodsInfoService.validateDateGoods(dataGoodsInfo);
		dataGoodsInfo.setShelves(EnvConst.SHELVES_ON);
		dataGoodsInfo.setModifydate(System.currentTimeMillis());
		dataGoodsInfoService.updateDataGoodsInfo(dataGoodsInfo);
		this.setSuccessJsonFromData(dataGoodsInfo);
	}

	/**
	 * @api {PUT} dataGoods/:id/offsale 商品下架
	 * @apiName offSaleDataGoods
	 * @apiGroup dataGoods
	 */
	@RequestMapping(method=RequestMethod.PUT,value="/{id}/offsale")
	public void offSaleDataGoods(@PathVariable int id){
		DataGoodsInfoWithBLOBs dataGoodsInfo = new DataGoodsInfoWithBLOBs();
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		dataGoodsInfo.setProvideid(provider.getProvideid());
		dataGoodsInfo.setGoods(id);
		//检查商品是否存在
		dataGoodsInfo = dataGoodsInfoService.validateDateGoods(dataGoodsInfo);
		dataGoodsInfo.setShelves(EnvConst.SHELVES_OFF);
		dataGoodsInfo.setModifydate(System.currentTimeMillis());
		dataGoodsInfoService.updateDataGoodsInfo(dataGoodsInfo);
		this.setSuccessJsonFromData(dataGoodsInfo);
	}
	
	
	
	/******************************搜索商品*************************************/
	
	/**
	 * @api {GET} dataGoods/map 商品列表地图（列表，该接口参数均为可选）
	 * @apiName getDataGoodsMap
	 * @apiGroup dataGoods
	 * 
	 * @apiparam {String} location 地址信息,格式（[{lon:xxxx,lat:xxxx,range:400},{lon:xxxx,lat:xxxx,range:400}]）(必填)
	 * @apiparam {String} indexnamelist 模板名称列表（多个用逗号隔开）
	 * @apiparam {bigint} timescope 数据有效期(bigint形式)(必填)
	 * @apiparam {int} indextypeid 商品类型ID
	 *
	 * @apiSuccess {int} goodsid 商品ID
	 * @apiSuccess {int} indexid 指标ID
	 * @apiSuccess {String} indexname 指标名称
	 * @apiSuccess {int} reportid 指标ID
	 * @apiSuccess {String} reportname 报告名称
	 * @apiSuccess {String} price 报价
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
	@RequestMapping(method=RequestMethod.GET,value="map")
	public void getDataGoodsMap(){
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		
		String location = reqString("location");
		String indexNameList = reqString("indexnamelist");
		String timeScope = reqString("timescope");
		int indexTypeId = reqInt("indextypeid", 0);
		
		//校验参数
		Preconditions.checkArgument(StringUtils.isNotEmpty(timeScope),"请选择数据有效期");
		Preconditions.checkArgument(StringUtils.isNotEmpty(location),"请选择地址范围");
		
		//组装参数
		Map params = new HashMap<>();
		params.put("providerId", provider.getProvideid());
		params.put("location", location);
		params.put("indexNameList", indexNameList);
		params.put("timeScope", timeScope);
		params.put("indexTypeId", indexTypeId);
		
		List<Map> dataGoods = dataGoodsInfoService.searchDatagoodsMap(params);
		
		this.setSuccessJsonFromData(CommonUtil.toLowerCaseForList(dataGoods));
	}
	
}
