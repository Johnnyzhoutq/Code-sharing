package com.mwm.env.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mwm.commons.exception.MwmRuntimeException;
import com.mwm.env.dao.IDataGoodsDao;
import com.mwm.env.envConst.CommonUtil;
import com.mwm.env.interceptor.requestFilter;
import com.mwm.env.mybatis.dao.DataGoodsInfoMapper;
import com.mwm.env.mybatis.modal.DataGoodsInfo;
import com.mwm.env.mybatis.modal.DataGoodsInfoExample;
import com.mwm.env.mybatis.modal.DataGoodsInfoWithBLOBs;
import com.mwm.env.mybatis.modal.IndexInfo;
import com.mwm.env.mybatis.modal.IndexTypeInfo;
import com.mwm.env.mybatis.modal.ReportInfo;

@Service
public class DataGoodsInfoServiceImpl implements IDataGoodsInfoService {
	@Autowired
	private DataGoodsInfoMapper dataGoodsInfoMapper;
	@Autowired
	private IDataGoodsDao dataGoodsDao;
	@Autowired
	private IIndexService indexService;
	
	@Override
	public DataGoodsInfoWithBLOBs validateDateGoods(DataGoodsInfoWithBLOBs dataGoodsInfo) {
		List<DataGoodsInfoWithBLOBs> dataGoodsInfoList = queryDataGoodsInfo(dataGoodsInfo);
		if (dataGoodsInfoList.size() == 0) {
			throw new MwmRuntimeException("权限不足");
		}
		return dataGoodsInfoList.get(0);
	}

	@Override
	public void updateDataGoodsInfo(DataGoodsInfoWithBLOBs dataGoodsInfo) {
		DataGoodsInfo tmp = validateDateGoods(dataGoodsInfo);
		dataGoodsInfo.setCreatedate(tmp.getCreatedate());
		dataGoodsInfoMapper.updateByPrimaryKey(dataGoodsInfo);
	}

	@Override
	public List<DataGoodsInfoWithBLOBs> queryDataGoodsInfo(DataGoodsInfoWithBLOBs dataGoodsInfo) {
		DataGoodsInfoExample example = new DataGoodsInfoExample();
		if (dataGoodsInfo.getGoods() == null) {
			//查询多个
			example.createCriteria().andProvideidEqualTo(dataGoodsInfo.getProvideid());
		}
		else {
			//查询单个
			example.createCriteria().andGoodsEqualTo(dataGoodsInfo.getGoods()).andProvideidEqualTo(dataGoodsInfo.getProvideid());
		}
		return dataGoodsInfoMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public void deleteDataGoodsInfo(DataGoodsInfo dataGoodsInfo) {
		validateDateGoods((DataGoodsInfoWithBLOBs)dataGoodsInfo);
		dataGoodsInfoMapper.deleteByPrimaryKey(dataGoodsInfo.getGoods());
	}

	@Override
	public int insertDataGoodsInfo(DataGoodsInfoWithBLOBs dataGoodsInfo) {
		dataGoodsInfoMapper.insertSelective(dataGoodsInfo);
		return dataGoodsInfo.getGoods();
	}

	@Override
	public List<Map> queryDataGoodsInfo(Map params, PageInfo page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		return dataGoodsDao.queryDataGoodsInfo(params);
	}

	@Override
	public DataGoodsInfoWithBLOBs addOrEditDataGoods(DataGoodsInfoWithBLOBs dataGoodsInfo) {
		//指标校验
		IndexInfo indexInfo = new IndexInfo();
		indexInfo.setIndexid(dataGoodsInfo.getIndexid());
		indexInfo.setProvideid(dataGoodsInfo.getProvideid());
		indexInfo = indexService.validateIndexInfo(indexInfo);
		
		//指标类型校验
		IndexTypeInfo indexTypeInfo = new IndexTypeInfo();
		indexTypeInfo.setIndextypeid(dataGoodsInfo.getGoodstype());
		indexTypeInfo.setProvideid(dataGoodsInfo.getProvideid());
		indexTypeInfo = indexService.validateIndexTypeInfo(indexTypeInfo);
		
		//指标报告校验
		ReportInfo reportInfo = new ReportInfo();
		reportInfo.setReportid(dataGoodsInfo.getReportid());
		reportInfo.setProvideid(dataGoodsInfo.getProvideid());
		indexService.validateReportInfo(reportInfo);
		
		if(dataGoodsInfo.getGoods() == null){	//新增
			//获取价格 TODO 获取官方指标库中的价格
			IndexTypeInfo indexType = indexService.getIndexTypeById(dataGoodsInfo.getGoodstype());
			dataGoodsInfo.setUnitprice(indexType.getPricemultiple());

			insertDataGoodsInfo(dataGoodsInfo);
		}else{	//修改
			updateDataGoodsInfo(dataGoodsInfo);
		}
		
		return dataGoodsInfo;
	}

	@Override
	public List<Map> searchDatagoodsMap(Map params) {
		List<Map> returnList = new ArrayList<>();
		
		//参数
		String indexNameList = params.get("indexNameList").toString();
		String indexNameListForQuery = ""; 
		if(StringUtils.isNotEmpty(indexNameList)){
			indexNameList.replaceAll("，", ",");
			String[] str = indexNameList.split(",");
			for(String s :str){
				indexNameListForQuery = indexNameListForQuery + "'" + s + "',";
			}
			if(indexNameListForQuery.endsWith(",")){
				indexNameListForQuery = indexNameListForQuery.substring(0, indexNameListForQuery.length() -1);
			}
		}
		
		//地址信息
		JSONArray locationArr = JSONArray.parseArray(params.get("location").toString());
		//查询每个地址的结果
		for(int i = 0;i<locationArr.size();i++){
			JSONObject obj = (JSONObject) locationArr.get(i);
			params.put("lon", obj.getString("lon"));
			params.put("lat", obj.getString("lat"));
			params.put("range", obj.getString("range"));
			params.put("indexNameList", indexNameListForQuery);
			
			//查地图上的商品
			List<Map> maps = dataGoodsDao.searchDatagoodsMap(params);
			maps = CommonUtil.toLowerCaseForList(maps);
			
			Map returnMap = new HashMap<>();
			returnMap.put("lon", obj.getString("lon"));
			returnMap.put("lat", obj.getString("lat"));
			returnMap.put("range", obj.getString("range"));
			returnMap.put("goods", maps);
			returnList.add(returnMap);
		}
		
		return returnList;
	}

	@Override
	public DataGoodsInfo getDataGoodsById(int goodsId) {
		return dataGoodsInfoMapper.selectByPrimaryKey(goodsId);
	}

}
