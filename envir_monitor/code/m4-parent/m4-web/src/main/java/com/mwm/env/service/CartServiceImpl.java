package com.mwm.env.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.mwm.commons.commonConst.Const;
import com.mwm.commons.util.OrderUtil;
import com.mwm.env.dao.IOrderDao;
import com.mwm.env.envConst.EnvConst;
import com.mwm.env.mybatis.dao.MasterOrderInfoMapper;
import com.mwm.env.mybatis.dao.SlaveOrderInfoMapper;
import com.mwm.env.mybatis.modal.DataGoodsInfo;
import com.mwm.env.mybatis.modal.MasterOrderInfo;
import com.mwm.env.mybatis.modal.MasterOrderInfoExample;
import com.mwm.env.mybatis.modal.SlaveOrderInfo;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	private IOrderService orderService;
	@Autowired
	private MasterOrderInfoMapper masterOrderInfoMapper;
	@Autowired
	private SlaveOrderInfoMapper slaveOrderInfoMapper;
	@Autowired
	private IDataGoodsInfoService dataGoodsInfoService;
	@Autowired
	private IOrderDao orderDao;
	
	@Override
	public MasterOrderInfo getMasterCart(int demanderId) {
		MasterOrderInfoExample example = new MasterOrderInfoExample();
		example.createCriteria().andUseridEqualTo(demanderId).andStateEqualTo(Const.STATE_NORMAL).andOrdertypeEqualTo(EnvConst.ORDER_TYPE_CART);
		List<MasterOrderInfo> carts = masterOrderInfoMapper.selectByExample(example);
		
		int cartNum = carts.size();
		//如果有多个购物车，则全部删除，保留一个
		if(cartNum > 1){
			//删除所有的购物车
			MasterOrderInfo deledCard = new MasterOrderInfo();
			deledCard.setState(Const.STATE_DEL);
			masterOrderInfoMapper.updateByExampleSelective(deledCard, example);
			//新增一个购物车
			MasterOrderInfo newCard = new MasterOrderInfo();
			newCard.setMasternum(OrderUtil.getOrderNum());
			newCard.setCreatedate((new Date()).getTime());
			newCard.setUserid(demanderId);
			newCard.setState(Const.STATE_NORMAL);
			newCard.setOrdertype(EnvConst.ORDER_TYPE_CART);
			orderService.addOrEditMasterOrder(newCard);
			return newCard;
		}
		//如果只有一个购物车，则返回
		if(cartNum == 1){
			return carts.get(0);
		}
		//如果没有购物车则添加
		if(cartNum == 0){
			//新增一个购物车
			MasterOrderInfo newCard = new MasterOrderInfo();
			newCard.setMasternum(OrderUtil.getOrderNum());
			newCard.setCreatedate((new Date()).getTime());
			newCard.setUserid(demanderId);
			newCard.setState(Const.STATE_NORMAL);
			newCard.setOrdertype(EnvConst.ORDER_TYPE_CART);
			orderService.addOrEditMasterOrder(newCard);
			return newCard;
		}
		return null;
	}
	
	@Override
	public void addCartGoods(int demanderId,int goodsId, String dwelltimes) {
		//获取商品信息
		DataGoodsInfo goods = dataGoodsInfoService.getDataGoodsById(goodsId);
		Preconditions.checkNotNull(goods,"当前商品不存在");
		//获取新增购物车(主订单)
		MasterOrderInfo card = getMasterCart(demanderId);
		//新增子订单
		SlaveOrderInfo slaveOrder = new SlaveOrderInfo();
		slaveOrder.setMasterid(card.getMasterid());
		slaveOrder.setGoods(goodsId);
		slaveOrder.setDatagoods(dwelltimes);
		slaveOrder.setProvideid(goods.getProvideid());
		slaveOrder.setSlavenum(OrderUtil.getOrderNum());
		slaveOrder.setRecivable(goods.getUnitprice());
		slaveOrder.setPaidprice(goods.getUnitprice());
		slaveOrder.setPenaltyprice(goods.getUnitprice());
		slaveOrder.setIncomeratio(goods.getUnitprice());
		slaveOrder.setOrderstate(EnvConst.ORDER_STATE_CREATE);
		slaveOrder.setCreatedate((new Date()).getTime());
		slaveOrderInfoMapper.insertSelective(slaveOrder);
	}

	@Override
	public List<Map> getSlaveOrderForCart(Map params, PageInfo page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		return orderDao.getSlaveOrderForCart(params);
	}

	

}
