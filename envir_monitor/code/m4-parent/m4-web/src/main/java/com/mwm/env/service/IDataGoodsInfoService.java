package com.mwm.env.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.mwm.env.mybatis.modal.DataGoodsInfo;
import com.mwm.env.mybatis.modal.DataGoodsInfoWithBLOBs;

public interface IDataGoodsInfoService {
	
	/*********************************指标商品基础接口*******************************/

	/**
	 * dataGoodsInfo校验
	 * @param dataGoodsInfo 
	 * @return
	 */
	DataGoodsInfoWithBLOBs validateDateGoods(DataGoodsInfoWithBLOBs dataGoodsInfo);

	/**
	 * 更新DataGoods
	 * @param dataGoodsInfo
	 */
	void updateDataGoodsInfo(DataGoodsInfoWithBLOBs dataGoodsInfo);
	
	/**
	 * 根据ID查商品
	 * @param goods
	 * @return
	 */
	DataGoodsInfo getDataGoodsById(int goodsId);
	
	/**
	 * 查询商品详情list
	 * @param dataGoodsInfo
	 * @return
	 */
	List<DataGoodsInfoWithBLOBs> queryDataGoodsInfo(DataGoodsInfoWithBLOBs dataGoodsInfo);

	/**
	 * 删除dataGoodsInfo
	 * @param dataGoodsInfo
	 */
	void deleteDataGoodsInfo(DataGoodsInfo dataGoodsInfo);

	/**
	 * 插入dataGoodsInfo
	 * @param dataGoodsInfo
	 */
	int insertDataGoodsInfo(DataGoodsInfoWithBLOBs dataGoodsInfo);

	
	/**
	 * 分页查询指标商品
	 * @param dataGoodsInfo
	 * @param page
	 * @return
	 */
	List<Map> queryDataGoodsInfo(Map params, PageInfo page);

	/**
	 * 新增或修改商品
	 * @param dataGoodsInfo
	 * @return
	 */
	DataGoodsInfoWithBLOBs addOrEditDataGoods(DataGoodsInfoWithBLOBs dataGoodsInfo);
	
	
	
	/*********************************指标商品业务接口*******************************/

	/**
	 * 搜索指标商品地图
	 * @param params
	 * @param page
	 * @return
	 */
	List<Map> searchDatagoodsMap(Map params);

	


}
