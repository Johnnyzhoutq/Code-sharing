package com.mwm.env.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.mwm.env.mybatis.modal.IndexInfo;
import com.mwm.env.mybatis.modal.IndexLibraryInfo;
import com.mwm.env.mybatis.modal.IndexTypeInfo;
import com.mwm.env.mybatis.modal.ProvideInfo;
import com.mwm.env.mybatis.modal.ReportInfo;

public interface IIndexService {
	
	
	
	/*******************************************原始报告*********************************/

	/**
	 * 原始报告列表
	 * @param params
	 * @param page
	 * @return
	 */
	public List<Map> getReportList(Map params, PageInfo<IndexInfo> page);
	
	/**
	 * 根据Id查询报告
	 * @param info
	 * @return
	 */
	public ReportInfo getReportById(int reportId);

	/**
	 * 新增或者修改报告
	 * @param info
	 * @return
	 */
	public int addOrEditReport(ReportInfo info);
	
	/**
	 * 删除报告
	 * @param reportId
	 */
	public void delReport(int reportId);
	
	
	
	/*******************************************指标*********************************/

	/**
	 * 查询指标信息
	 * @param indexInfo
	 */
	public List<IndexInfo> queryIndexInfo(IndexInfo indexInfo);
	
	/**
	 * 查询指标
	 * @param params
	 * @param page
	 * @return
	 */
	public List<Map> queryIndexInfo(Map params, PageInfo<IndexInfo> page);

	/**
	 * 更新指标信息
	 * @param indexInfo
	 */
	public void updateIndexInfo(IndexInfo indexInfo);

	/**
	 * 创建指标信息
	 * @param indexInfo
	 */
	public int insertIndexInfo(IndexInfo indexInfo);

	/**
	 * 删除指标信息
	 * @param indexInfo
	 */
	public void deleteIndexInfo(int provicerId,int indexId);
	
	/**
	 * 根据Id获取指标
	 * @param indexInfo
	 */
	public IndexInfo getIndexById(int indexId);
	
	
	
	/*******************************************指标类型*********************************/

	/**
	 * 查询指标类型
	 * @param indexTypeInfo
	 * @return
	 */
	public List<IndexTypeInfo> queryIndexTypeInfo(IndexTypeInfo indexTypeInfo);

	/**
	 * 删除指标类型
	 * @param indexTypeInfo
	 */
	public void deleteIndexTypeInfo(int providerId,int indexTypeId);

	/**
	 * 指标类型新增
	 * @param indexTypeInfo
	 */
	public int inserIndexTypeInfo(IndexTypeInfo indexTypeInfo);

	/**
	 * 修改指标类型
	 * @param indexTypeInfo
	 */
	public void updateIndexTypeInfo(IndexTypeInfo indexTypeInfo);
	
	/**
	 * 根据ID查询指标类型
	 * @param goodstype
	 * @return
	 */
	public IndexTypeInfo getIndexTypeById(Integer goodstype);
	
	/*******************************************指标库*********************************/


	/**
	 * 指标信息列表
	 * @param params
	 * @param page
	 * @return
	 */
	public List<Map> queryIndexInfoForLib(Map params, PageInfo<IndexInfo> page);
	
	/**
	 * 查询指标库列表
	 * @param params
	 * @param page
	 * @return
	 */
	public List<IndexLibraryInfo> queryIndexLibraryInfo(Map params, PageInfo page);

	/**
	 * 创建指标库指标
	 * @param indexLibraryInfo
	 */
	public int inserIndexLibraryInfo(IndexLibraryInfo indexLibraryInfo);

	/**
	 * 查询指标库
	 * @param indexLibraryInfo
	 * @return
	 */
	public List<IndexLibraryInfo> queryIndexLibraryInfo(IndexLibraryInfo indexLibraryInfo);

	/**
	 * 更新指标库
	 * @param indexLibraryInfo
	 */
	public void updateIndexLibrary(IndexLibraryInfo indexLibraryInfo);


	/**
	 * 删除指标库
	 * @param indexlibid
	 */
	public void deleteIndexLibInfo(ProvideInfo provider,int indexlibid);
	
	/**
	 * 删除指标库中的指标
	 * @param provideid
	 * @param indexLibId
	 * @param indexId
	 */
	public void delIndexLibIndex(Integer provideid, int indexLibId, int indexId);
	
	
	/*******************************************业务代码*********************************/
	
	/**
	 * 校验指标库是否属于该供应商
	 */
	public void validateIndexLibForProvidor(int provideId,int indexLibId);

	/**
	 * 查询指标类型集合
	 * @param indexTypeInfo
	 * @return
	 */
	public List<IndexTypeInfo> queryIndexTypeInfoList(IndexTypeInfo indexTypeInfo,PageInfo page);

	/**
	 * 判断指标是否存在
	 * @param indexInfo
	 */
	public IndexInfo validateIndexInfo(IndexInfo indexInfo);

	/**
	 * 判断指标是否在对应的指标库
	 * @param indexInfo
	 */
	public void validateIndexInfoWithLibId(IndexInfo indexInfo);

	/**
	 * 判断指标类型
	 * @param indexTypeInfo
	 * @return
	 */
	public IndexTypeInfo validateIndexTypeInfo(IndexTypeInfo indexTypeInfo);

	/**
	 * 指标报告校验
	 * @param reportInfo
	 * @return
	 */
	public ReportInfo validateReportInfo(ReportInfo reportInfo);

	/**
	 * 获取官方指标库列表
	 * @param params
	 * @param page
	 * @return
	 */
	public List<Map> getOfficialIndex(Map params, PageInfo page);

	

	

}
