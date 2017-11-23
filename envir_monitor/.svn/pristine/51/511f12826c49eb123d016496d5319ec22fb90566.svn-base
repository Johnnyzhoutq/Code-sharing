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
import com.mwm.commons.exception.MwmRuntimeException;
import com.mwm.commons.util.IAnonymousRequest;
import com.mwm.env.envConst.CommonUtil;
import com.mwm.env.envConst.EnvConst;
import com.mwm.env.mybatis.modal.IndexInfo;
import com.mwm.env.mybatis.modal.IndexLibraryInfo;
import com.mwm.env.mybatis.modal.IndexTypeInfo;
import com.mwm.env.mybatis.modal.ProvideInfo;
import com.mwm.env.mybatis.modal.ReportInfo;
import com.mwm.env.service.IIndexService;
import com.mwm.env.util.EnvUtils;
import com.mwm.env.util.UserUtil;

/**
 * 指标信息
 * 
 * @author heruoyu
 *
 */
@Controller
@RequestMapping("/index")
public class IndexController extends BaseController implements IAnonymousRequest {

	@Autowired
	private IIndexService indexService;

	/************************************ 指标 ************************************/
	/**
	 * @api {PUT} index/:id 指标编辑
	 * @apiName updateIndexInfo
	 * @apiGroup index
	 *
	 * @apiParam {String} indexname 指标名称
	 * @apiParam {int} indexlibdd 所属指标库ID
	 * @apiParam {String} indexunits 指标单位
	 * @apiParam {String} createdate 创建时间
	 * @apiParam {decimal} indexprice 毛价
	 * @apiParam {int} offindexid 官方指标编号
	 * @apiParam {String} indexremark 备注
	 * @apiParam {String} offindexid 官方指标编号
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public void updateIndexInfo(@PathVariable int id) {
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		//获取参数
		String indexName = reqString("indexname");
		Integer indexLibId = reqInt("indexlibid", null);
		String indexUnits = reqString("indexunits");
		String indexPrice = reqString("indexprice");
		String indexRemark = reqString("indexremark");
		Integer offIndexId = reqInt("offindexid", null);
		
		//校验参数
		EnvUtils.validateStrNotNull(indexName, "指标名称", 10);
		Preconditions.checkNotNull(indexLibId, "请选择指标库");
		EnvUtils.validateStrNotNull(indexUnits, "指标单位", 15);
		Preconditions.checkArgument(StringUtils.isNotBlank(indexPrice), "请输入指标价格");
		BigDecimal indexprice = EnvUtils.strToBigDecimal(indexPrice, "指标价格");
		Preconditions.checkNotNull(offIndexId, "请输入官方指标编号");
				
		IndexInfo indexInfo = new IndexInfo();
		indexInfo.setIndexid(id);
		indexInfo.setProvideid(provider.getProvideid());
		indexInfo.setIndexprice(indexprice);
		indexInfo.setIndexlibid(indexLibId);
		indexInfo.setIndexname(indexName);
		indexInfo.setOffindexid(offIndexId);
		indexInfo.setIndexunits(indexUnits);
		indexInfo.setIndexremark(indexRemark);
		indexInfo.setModifydate(System.currentTimeMillis());
		
		//判断指标和指标库对应关系是否存在
		indexService.updateIndexInfo(indexInfo);
		
		this.setSuccessJsonFromData(indexInfo);
	}

	/**
	 * @api {DELETE} index/:id 指标删除
	 * @apiName delIndexInfo
	 * @apiGroup index
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void delIndexInfo(@PathVariable int id) {
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		indexService.deleteIndexInfo(provider.getProvideid(),id);
		this.setSuccessJsonFromData();
	}

	/**
	 * @api {POST} index 指标新建
	 * @apiName addIndexInfo
	 * @apiGroup index
	 *
	 * @apiParam {String} indexname 指标名称
	 * @apiParam {String} indexlibid 所属指标库名称
	 * @apiParam {String} indexunits 指标单位
	 * @apiParam {decimal} indexprice 毛价
	 * @apiParam {String} indexremark 备注
	 * @apiParam {String} offindexid 官方指标ID
	 */
	@RequestMapping(method = RequestMethod.POST)
	public void addIndexInfo() {
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		
		//获取参数
		String indexName = reqString("indexname");
		Integer indexLibId = reqInt("indexlibid", null);
		String indexUnits = reqString("indexunits");
		String indexPrice = reqString("indexprice");
		String indexRemark = reqString("indexremark");
		Integer offIndexId = reqInt("offindexid", null);
		
		//校验参数
		EnvUtils.validateStrNotNull(indexName, "指标名称", 10);
		Preconditions.checkNotNull(indexLibId, "请选择指标库");
		EnvUtils.validateStrNotNull(indexUnits, "指标单位", 15);
		Preconditions.checkArgument(StringUtils.isNotBlank(indexPrice), "请输入指标价格");
		BigDecimal indexprice = EnvUtils.strToBigDecimal(indexPrice, "指标价格");
		Preconditions.checkNotNull(offIndexId, "请输入官方指标编号");
		
		//包装
		IndexInfo indexInfo = new IndexInfo();
		indexInfo.setIndexname(indexName);
		indexInfo.setIndexlibid(indexLibId);
		indexInfo.setProvideid(provider.getProvideid());
		indexInfo.setIndexprice(indexprice);
		indexInfo.setIndexunits(indexUnits);
		indexInfo.setIndexremark(indexRemark);
		indexInfo.setOffindexid(offIndexId);
		indexInfo.setCreatedate(System.currentTimeMillis());
		indexInfo.setState(Const.STATE_NORMAL);
		
		//新增
		int indexId = indexService.insertIndexInfo(indexInfo);
		indexInfo.setIndexid(indexId);
		
		this.setSuccessJsonFromData(indexInfo);
	}

	/**
	 * @api {GET} index 指标信息（list）
	 * @apiName getIndexInfo
	 * @apiGroup index
	 *
	 * @apiParam {String} name 指标名称（可选）
	 * @apiParam {bigint} timeframe 时间范围（可选,默认所有）
	 * @apiparam {String} page 页码（可选）
	 * @apiparam {String} pagesize 每页显示的内容数（可选）
	 *
	 * @apiSuccess {int} indexid 指标ID
	 * @apiSuccess {String} indexname 指标名称
	 * @apiSuccess {String} indexlibname 所属指标库名称
	 * @apiSuccess {String} indexunits 指标单位
	 * @apiSuccess {String} createdate 创建时间
	 * @apiSuccess {decimal} indexprice 毛价
	 * @apiSuccess {String} indexremark 备注
	 */
	@RequestMapping(method = RequestMethod.GET)
	public void getIndexInfo() {
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		
		//包装参数
		String name = reqString("name");
		String timeFrame = reqString("timeframe");
		
		Map params = new HashMap<>();
		params.put("name", name);
		params.put("timeFrame", timeFrame);
		params.put("provideId", provider.getProvideid());
		
		//分页查
		PageInfo page = new PageInfo<>();
		page.setPageNum(reqInt("page", 1));
		page.setPageSize(reqInt("pageSize", 10));
		List<Map> indexInfoList = indexService.queryIndexInfo(params, page);
		page = new PageInfo<>(indexInfoList);
		
		//加上分页数据
		Map returnMap = new HashMap<>();
		returnMap.put("pagenum", page.getPageNum());
		returnMap.put("pagesize", page.getPageSize());
		returnMap.put("pagetotal", page.getTotal());
		returnMap.put("content", CommonUtil.toLowerCaseForList(indexInfoList));
		
		this.setSuccessJsonFromData(returnMap);
	}
	
	/************************************ 指标库 ************************************/

	/**
	 * @api {GET} index/indexLib 指标库-获取(list)
	 * @apiName getIndexLib
	 * @apiGroup index
	 * 
	 * @apiparam {String} page 页码（可选）
	 * @apiparam {String} pageSize 每页显示的内容数（可选）
	 *
	 * @apiSuccess {int} indexlibid 指标库编号
	 * @apiSuccess {String} indexlibname 指标库名称
	 * @apiSuccess {String} indexlibdes 指标库描述
	 * @apiSuccess {String} creatdate 创建时间
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/indexLib")
	public void getIndexLib() {
		ProvideInfo provider = UserUtil.getProvider(getRequest());

		// 组装参数
		Map params = new HashMap<>();
		params.put("provideId", provider.getProvideid());

		PageInfo page = new PageInfo<>();
		page.setPageNum(reqInt("page", 1));
		page.setPageSize(reqInt("pageSize", 10));
		List<IndexLibraryInfo> indexLibraryInfoList = indexService.queryIndexLibraryInfo(params, page);
		page = new PageInfo<>(indexLibraryInfoList);
		
		//加上分页数据
		Map returnMap = new HashMap<>();
		returnMap.put("pagenum", page.getPageNum());
		returnMap.put("pagesize", page.getPageSize());
		returnMap.put("pagetotal", page.getTotal());
		returnMap.put("content", indexLibraryInfoList);

		this.setSuccessJsonFromData(returnMap);
	}
	
	
	/**
	 * @api {DELETE} index/indexLib/:indexibId 指标库删除
	 * @apiName deleteIndexLib
	 * @apiGroup index
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/indexLib/{indexlibid}")
	public void deleteIndexLib(@PathVariable int indexlibid) {
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		// 删除
		indexService.deleteIndexLibInfo(provider, indexlibid);
		this.setSuccessJsonFromData();
	}

	/**
	 * @api {PUT} index/indexLib/:indexlibid 指标库编辑
	 * @apiName addIndexLib
	 * @apiGroup index
	 *
	 * @apiParam {String} indexlibname 指标库名称
	 * @apiParam {String} indexlibdes 指标库描述
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/indexLib/{indexlibid}")
	public void updateIndexLib(@PathVariable int indexlibid) {
		ProvideInfo provider = UserUtil.getProvider(getRequest());

		// 参数
		String indexLibName = reqString("indexlibname");
		String indexLibDes = reqString("indexlibdes");
		// 校验
		Preconditions.checkArgument(StringUtils.isNotEmpty(indexLibName),"请输入指标库名称");

		IndexLibraryInfo indexLibraryInfo = new IndexLibraryInfo();
		indexLibraryInfo.setIndexlibid(indexlibid);
		indexLibraryInfo.setProvideid(provider.getProvideid());
		indexLibraryInfo.setIndexlibname(indexLibName);
		indexLibraryInfo.setIndexlibdes(indexLibDes);
		
		indexService.updateIndexLibrary(indexLibraryInfo);
		this.setSuccessJsonFromData(indexLibraryInfo);
	}

	/**
	 * @api {POST} index/indexLib 指标库新增
	 * @apiName addIndexLib
	 * @apiGroup index
	 *
	 * @apiParam {String} indexlibname 指标库名称
	 * @apiParam {String} indexlibdes 指标库描述（可选）
	 */
	@RequestMapping(method = RequestMethod.POST, value = "indexLib")
	public void addIndexLib() {
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		
		// 参数
		String indexLibName = reqString("indexlibname");
		String indexLibDes = reqString("indexlibdes");

		// 校验
		Preconditions.checkArgument(StringUtils.isNotEmpty(indexLibName),"请输入指标库名称");

		IndexLibraryInfo indexLibraryInfo = new IndexLibraryInfo();
		indexLibraryInfo.setIndexlibname(indexLibName);
		indexLibraryInfo.setIndexlibdes(indexLibDes);
		indexLibraryInfo.setProvideid(provider.getProvideid());
		indexLibraryInfo.setCreatedate((new Date()).getTime());
		indexLibraryInfo.setState(Const.STATE_NORMAL);
		int indexLibId = indexService.inserIndexLibraryInfo(indexLibraryInfo);
		indexLibraryInfo.setIndexlibid(indexLibId);
		
		this.setSuccessJsonFromData(indexLibraryInfo);
	}

	/**
	 * @api {GET} index/indexLib/:indexLibId/index 指标库指标查询
	 * @apiName getIndexLibIndex
	 * @apiGroup index
	 * 
	 * @apiparam {String} indexname 指标名称（可选）
	 *
	 * @apiSuccess {int} indexid 指标编号
	 * @apiSuccess {String} indexlibname 指标库名称
	 * @apiSuccess {String} indexname 指标名称
	 * @apiSuccess {String} indexunits 指标单位
	 * @apiSuccess {String} indexprice 指标毛价
	 * @apiSuccess {String} creatdate 创建时间
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/indexLib/{id}/index")
	public void getIndexLibIndex(@PathVariable("id") int indexLibId) {
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		// 包装参数
		String indexName = reqString("indexname");
		
		Map params  = new HashMap<>();
		params.put("indexName", indexName);
		params.put("indexLibId", indexLibId);
		params.put("providerId", provider.getProvideid());
		
		PageInfo page = new PageInfo<>();
		page.setPageNum(reqInt("page", 1));
		page.setPageSize(reqInt("pageSize", 10));
		List<Map> indexInfoList = indexService.queryIndexInfoForLib(params, page);
		page = new PageInfo<>(indexInfoList);
		
		//加上分页数据
		Map returnMap = new HashMap<>();
		returnMap.put("pagenum", page.getPageNum());
		returnMap.put("pagesize", page.getPageSize());
		returnMap.put("pagetotal", page.getTotal());
		returnMap.put("content", CommonUtil.toLowerCaseForList(indexInfoList));
		
		this.setSuccessJsonFromData(returnMap);
	}

	/**
	 * @api {DELETE} index/indexLib/:indexLibId/index/:indexId 删除指标库和指标对应关系 (将指标库下的某一指标删除)
	 * @apiName delIndexLibIndex
	 * @apiGroup index
	 * 
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/indexLib/{indexLibId}/index/{indexId}")
	public void delIndexLibIndex(@PathVariable int indexLibId, @PathVariable int indexId) {
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		indexService.delIndexLibIndex(provider.getProvideid(),indexLibId,indexId);
		this.setSuccessJsonFromData();
	}

	
	/************************************ 指标类型 ************************************/
	
	/**
	 * @api {GET} index/indexType 指标类型（list）
	 * @apiName getIndexType
	 * @apiGroup index
	 * 
	 * @apiSuccess {int} indextypeid 编号
	 * @apiSuccess {int} typenum 类型编号
	 * @apiSuccess {String} typename 类型名称
	 * @apiSuccess {int} timedomain 类型时域
	 * @apiSuccess {String} tdtype 时域类型
	 * @apiSuccess {String} tdcontent 时域内容
	 * @apiSuccess {String} pricemultiple 价格倍数
	 * @apiSuccess {int} typeflag 类型标记 (1-不可以删除和修改 0-表示可以删除，数据库默认为0 可不传)
	 * @apiSuccess {String} creatdate 创建时间
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/indexType")
	public void getIndexType() {
		ProvideInfo provider = UserUtil.getProvider(getRequest());

		//包装参数
		PageInfo page = new PageInfo<>();
		page.setPageNum(reqInt("page", 1));
		page.setPageSize(reqInt("pageSize", 10));
		IndexTypeInfo indexTypeInfo = new IndexTypeInfo();
		indexTypeInfo.setProvideid(provider.getProvideid());
		List<IndexTypeInfo> indexTypeInfoList = indexService.queryIndexTypeInfoList(indexTypeInfo,page);
		page = new PageInfo<>(indexTypeInfoList);
		
		//加上分页数据
		Map returnMap = new HashMap<>();
		returnMap.put("pagenum", page.getPageNum());
		returnMap.put("pagesize", page.getPageSize());
		returnMap.put("pagetotal", page.getTotal());
		returnMap.put("content", indexTypeInfoList);

		this.setSuccessJsonFromData(returnMap);
	}
	
	/**
	 * @api {POST} index/indexType 指标类型新增
	 * @apiName addIndexType
	 * @apiGroup index
	 * 
	 * @apiParam {String} typename 类型名称
	 * @apiParam {String} timedomain 类型时域（1均值2瞬时值3自定义）
	 * @apiParam {bigint} tdcontent 时域内容（格式前端定义）
	 * @apiParam {String} pricemultiple 价格倍数
	 * @apiParam {int} typeflag 类型标记(0可以增删改查1不可)
	 * @apiParam {String} typenum 类型编号
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/indexType")
	public void addIndexType() {
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		
		//获取参数
		String typeName = reqString("typename");
		String timeDomain = reqString("timedomain");
		String TDContent = reqString("tdcontent");
		String priceMultiple = reqString("pricemultiple");
		String typeFlag = reqString("typeflag");
		String typeNum = reqString("typenum");
		
		//校验
		EnvUtils.validateStrNotNull(typeName, "自定义类型名称", 10);
		EnvUtils.validateStrNotNull(timeDomain, "类型时域", 1);
		Preconditions.checkArgument(StringUtils.isNotBlank(TDContent), "时域内容不能为空");
		Preconditions.checkArgument(StringUtils.isNotBlank(priceMultiple), "价格倍数不能为空");
		Preconditions.checkArgument(StringUtils.isNotBlank(typeNum), "类型编号不能为空");
		
		BigDecimal priceultiple = EnvUtils.strToBigDecimal(priceMultiple, "价格倍数");
		
		//包装
		IndexTypeInfo indexTypeInfo = new IndexTypeInfo();
		indexTypeInfo.setTypeflag(typeFlag);
		indexTypeInfo.setIndextypename(typeName);
		indexTypeInfo.setTimedomain(timeDomain);
		//indexTypeInfo.setTdtype(TDType);
		indexTypeInfo.setTypenum(typeNum);
		indexTypeInfo.setTdcontent(TDContent);
		indexTypeInfo.setPricemultiple(priceultiple);
		indexTypeInfo.setProvideid(provider.getProvideid());
		indexTypeInfo.setCreatedate(System.currentTimeMillis());
		
		int indexTypeId = indexService.inserIndexTypeInfo(indexTypeInfo);
		indexTypeInfo.setIndextypeid(indexTypeId);
		this.setSuccessJsonFromData(indexTypeInfo);
	}
	
	/**
	 * @api {PUT} index/indexType/:id 指标类型编辑
	 * @apiName updateIndexType
	 * @apiGroup index
	 * 
	 * @apiParam {String} typename 类型名称
	 * @apiParam {String} timedomain 类型时域（1均值2瞬时值3自定义）
	 * @apiParam {bigint} tdcontent 时域内容（格式前端定义）
	 * @apiParam {String} pricemultiple 价格倍数
	 * @apiParam {int} typeflag 类型标记(0可以增删改查1不可)
	 * @apiParam {String} typenum 类型编号
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/indexType/{id}")
	public void updateIndexType(@PathVariable int id) {
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		
		//获取参数
		String typeName = reqString("typename");
		String timeDomain = reqString("timedomain");
		//String TDType = reqString("TDType");
		String TDContent = reqString("tdcontent");
		String priceMultiple = reqString("pricemultiple");
		String typeFlag = reqString("typeflag");
		String typeNum = reqString("typenum");
		
		//校验
		EnvUtils.validateStrNotNull(typeName, "自定义类型名称", 10);
		EnvUtils.validateStrNotNull(timeDomain, "类型时域", 1);
		Preconditions.checkArgument(StringUtils.isNotBlank(TDContent), "时域内容不能为空");
		Preconditions.checkArgument(StringUtils.isNotBlank(priceMultiple), "价格倍数不能为空");
		Preconditions.checkArgument(StringUtils.isNotBlank(TDContent), "时域内容不能为空");
		Preconditions.checkArgument(StringUtils.isNotBlank(typeNum), "类型编号不能为空");
		
		BigDecimal priceultiple = EnvUtils.strToBigDecimal(priceMultiple, "价格倍数");
		
		//包装
		IndexTypeInfo indexTypeInfo = new IndexTypeInfo();
		indexTypeInfo.setIndextypeid(id);
		indexTypeInfo.setTypeflag(typeFlag);
		indexTypeInfo.setIndextypename(typeName);
		indexTypeInfo.setTimedomain(timeDomain);
		//indexTypeInfo.setTdtype(TDType);
		indexTypeInfo.setTypenum(typeNum);
		indexTypeInfo.setTdcontent(TDContent);
		indexTypeInfo.setPricemultiple(priceultiple);
		indexTypeInfo.setProvideid(provider.getProvideid());
		indexTypeInfo.setModifydate(System.currentTimeMillis());
		indexService.updateIndexTypeInfo(indexTypeInfo);
		
		this.setSuccessJsonFromData(indexTypeInfo);
	}

	/**
	 * @api {DELETE} index/indexType/:id 指标类型删除
	 * @apiName updateIndexType
	 * @apiGroup index
	 * 
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/indexType/{id}")
	public void deleteIndexType(@PathVariable int id) {
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		indexService.deleteIndexTypeInfo(provider.getProvideid(),id);
		this.setSuccessJsonFromData();
	}

	
	/************************************ 原始报告 ************************************/

	/**
	 * @api {GET} index/report 原始报告列表（list）
	 * @apiName getReport
	 * @apiGroup index
	 *
	 * @apiParam {String} reportname 报告名称（可选）
	 * @apiparam {int} page 页码（可选）
	 * @apiparam {int} pageSize 每页显示的内容数（可选）
	 * 
	 * @apiSuccess {String} reportname 报告名称
	 * @apiSuccess {String} reporturl 报告信息
	 * @apiSuccess {String} linkindex 关联指标
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/report")
	public void getReport() {
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		// 参数
		String reportName = reqString("reportname");

		Map params = new HashMap<>();
		params.put("reportName", reportName);
		params.put("provideId", provider.getProvideid());

		PageInfo page = new PageInfo<>();
		page.setPageNum(reqInt("page", 1));
		page.setPageSize(reqInt("pageSize", 10));
		List<Map> infos = indexService.getReportList(params, page);
		page = new PageInfo<>(infos);
		
		//加上分页数据
		Map returnMap = new HashMap<>();
		returnMap.put("pagenum", page.getPageNum());
		returnMap.put("pagesize", page.getPageSize());
		returnMap.put("pagetotal", page.getTotal());
		returnMap.put("content", CommonUtil.toLowerCaseForList(infos));
		
		this.setSuccessJsonFromData(returnMap);
	}

	/**
	 * @api {POST} index/report 原始报告创建
	 * @apiName addReport
	 * @apiGroup index
	 *
	 * @apiParam {String} reportname 报告名称
	 * @apiParam {String} reporturl 报告信息
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/report")
	public void addReport() {
		ProvideInfo provider = UserUtil.getProvider(getRequest());
		
		String reportName = reqString("reportname");
		String reportURL = reqString("reporturl");

		EnvUtils.validateStrNotNull(reportName, "报告名称", 10);
		Preconditions.checkArgument(StringUtils.isNotBlank(reportURL), "请输入报告信息");

		ReportInfo info = new ReportInfo();
		info.setReportname(reportName);
		info.setReporturl(reportURL);
		info.setCreatedate((new Date()).getTime());
		info.setProvideid(provider.getProvideid());
		int reprtId = indexService.addOrEditReport(info);
		info.setReportid(reprtId);
		
		this.setSuccessJsonFromData(info);
	}
	
	/**
	 * @api {DELETE} index/report/:reportId 原始报告删除
	 * @apiName delReport
	 * @apiGroup index
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/report/{reportId}")
	public void deleteReport(@PathVariable int reportId) {
		indexService.delReport(reportId);
		this.setSuccessJsonFromData();
	}
	
	
	/************************************ 官方指标的查，没有增删改 ************************************/
	/**
	 * @api {GET} index/official 官方指标库获取
	 * @apiName delReport
	 * @apiGroup index
	 */
	@RequestMapping(method = RequestMethod.GET,value="official")
	public void getOfficialIndex() {

		Map params = new HashMap<>();
		PageInfo page = new PageInfo<>();
		page.setPageNum(reqInt("page", 1));
		page.setPageSize(reqInt("pageSize", 10));
		List<Map> infos = indexService.getOfficialIndex(params, page);
		page = new PageInfo<>(infos);
		
		//加上分页数据
		Map returnMap = new HashMap<>();
		returnMap.put("pagenum", page.getPageNum());
		returnMap.put("pagesize", page.getPageSize());
		returnMap.put("pagetotal", page.getTotal());
		returnMap.put("content", CommonUtil.toLowerCaseForList(infos));
		
		this.setSuccessJsonFromData(returnMap);
	} 
	
}
