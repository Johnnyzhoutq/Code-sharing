package com.mwm.env.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Preconditions;
import com.mwm.commons.commonConst.Const;
import com.mwm.env.mybatis.dao.AddressInfoMapper;
import com.mwm.env.mybatis.modal.AddressInfo;
import com.mwm.env.mybatis.modal.AddressInfoExample;

@Service
public class AddressServiceImpl implements IAddressService{
	
	@Autowired
	private AddressInfoMapper addressInfoMapper;

	@Override
	public List<AddressInfo> userAddress(Map params, PageInfo page) {
		int userId = Integer.parseInt(params.get("userId").toString());
		
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		AddressInfoExample example = new AddressInfoExample();
		example.createCriteria().andUseridEqualTo(userId).andStateEqualTo(Const.STATE_NORMAL);
		return addressInfoMapper.selectByExample(example);
	}

	@Override
	public AddressInfo getAddressById(int addrId) {
		return addressInfoMapper.selectByPrimaryKey(addrId);
	}

	@Override
	public int addOrEditAddress(AddressInfo address) {
		if(address.getAddressid() == null){
			addressInfoMapper.insertSelective(address);
			return address.getAddressid();
		}else{
			return addressInfoMapper.updateByPrimaryKeySelective(address);
		}
	}

	@Override
	public void delAddress(int addrId) {
		AddressInfo info = new AddressInfo();
		info.setAddressid(addrId);
		info.setModifydate((new Date()).getTime());
		info.setState(Const.STATE_DEL);
		addOrEditAddress(info);
	}

}
