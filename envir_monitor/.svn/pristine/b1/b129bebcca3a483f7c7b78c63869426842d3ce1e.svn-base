package com.mwm.env.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.mwm.env.dao.IProviderDao;
import com.mwm.env.envConst.EnvConst;
import com.mwm.env.mybatis.dao.MemberInfoMapper;
import com.mwm.env.mybatis.dao.MemberShipInfoMapper;
import com.mwm.env.mybatis.dao.ProvideInfoMapper;
import com.mwm.env.mybatis.modal.MemberInfo;
import com.mwm.env.mybatis.modal.MemberShipInfo;
import com.mwm.env.mybatis.modal.MemberShipInfoExample;
import com.mwm.env.mybatis.modal.ProvideInfo;
import com.mwm.env.mybatis.modal.UserBankInfo;
import com.mwm.env.mybatis.modal.UserInfo;

@Service
public class ProviderServiceImpl implements IProviderService {

	@Autowired
	private IProviderDao providerDao;
	@Autowired
	private ProvideInfoMapper providerInfoMapper;
	@Autowired
	private IUserService userService;
	@Autowired
	private MemberInfoMapper memberInfoMapper;
	@Autowired
	private MemberShipInfoMapper memberShipInfoMapper;
	
	@Override
	public Map getProviderInfo(Integer provideid) {
		return providerDao.getProviderInfo(provideid);
	}

	@Override
	public void addProviderInfo(ProvideInfo provider) {
		//个人用户不能称为供应商
		UserInfo userInfo = userService.getUserById(provider.getUserid());
		Preconditions.checkNotNull(userInfo,"当前用户不存在");
		Preconditions.checkArgument(userInfo.getUsertype().equals(EnvConst.USER_TYPE_COMPANY),"当前用户不是企业用户");
		//校验当前供应方的银行信息（成为供应方必须有银行账户信息）
		List<UserBankInfo> banks = userService.getBankInfo(userInfo);
		Preconditions.checkNotNull(banks.size() != 0,"请先添加银行信息");
		//新增供应方
		providerInfoMapper.insertSelective(provider);
		
		//获取等级信息
		MemberShipInfo memberShip = getMemberShipInfoByCode(EnvConst.MEMBER_LEVEL_CODE_NORMAL);
		//设置当前用户为初级供应商
		MemberInfo member = new MemberInfo();
		member.setProvideid(provider.getProvideid());
		member.setUserid(provider.getUserid());
		member.setMembertype(EnvConst.MEMBER_TYPE_1);
		member.setOpenedtime((new Date()).getTime());
		member.setOpenedway(EnvConst.MEMBER_OPEN_WEY_ALWAYS);
		member.setIncomratio(memberShip.getIncomratio());
		member.setCreatedate((new Date().getTime()));
		member.setModifydate((new Date().getTime()));
		addOrEditMemberInfo(member);
	}

	@Override
	public int addOrEditMemberInfo(MemberInfo memberInfo) {
		if(memberInfo.getMemberid() == null){
			memberInfoMapper.insertSelective(memberInfo);
			return memberInfo.getMemberid();
		}else{
			return memberInfoMapper.updateByPrimaryKeySelective(memberInfo);
		}
	}

	@Override
	public MemberShipInfo getMemberShipInfoByCode(String code) {
		MemberShipInfoExample example = new MemberShipInfoExample();
		example.createCriteria().andMembershipcodeEqualTo(code);
		List<MemberShipInfo> memberShips = memberShipInfoMapper.selectByExample(example);
		return memberShips.size() == 0?null:memberShips.get(0);
	}

}
