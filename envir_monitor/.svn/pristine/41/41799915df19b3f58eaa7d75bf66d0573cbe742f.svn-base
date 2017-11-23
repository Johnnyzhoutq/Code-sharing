package com.mwm.env.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mwm.commons.commonConst.Const;
import com.mwm.commons.exception.MwmRuntimeException;
import com.mwm.env.dao.IAccountDao;
import com.mwm.env.mybatis.dao.AccountInfoMapper;
import com.mwm.env.mybatis.modal.AccountInfo;
import com.mwm.env.mybatis.modal.AccountInfoExample;

@Service
public class AccountServiceImpl implements IAccountService {
	
	@Autowired
	private AccountInfoMapper accountInfoMapper;
	@Autowired
	private IAccountDao accountDao;

	@Override
	public AccountInfo login(String account, String userPwd) {
		AccountInfoExample example = new AccountInfoExample();
		example.createCriteria().andAccountnameEqualTo(account).andAccountpwdEqualTo(DigestUtils.md5Hex(userPwd));
		List<AccountInfo> accounts = accountInfoMapper.selectByExample(example);
		
		if(accounts.size() != 0){
			throw new MwmRuntimeException("账号不存在或者密码错误");
		}
		return accounts.get(0);
	}

	@Override
	public List<Map> queryAccountInfo(Map params, PageInfo page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		return accountDao.queryAccountInfo(params);
	}

	@Override
	public List<AccountInfo> getAccountInfo(Map params, PageInfo page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		AccountInfoExample example = new AccountInfoExample();
		example.createCriteria().andStateEqualTo(Const.STATE_NORMAL);
		return accountInfoMapper.selectByExample(example);
	}

	@Override
	public AccountInfo getAccountInfoById(int accountId) {
		return accountInfoMapper.selectByPrimaryKey(accountId);
	}

	@Override
	public int addOrEditAccountInfo(AccountInfo account) {
		if (account.getAccountid() == null) {
			account.setCreatedate(new Date().getTime());
			accountInfoMapper.insertSelective(account);
			return account.getAccountid();
		}else {
			return accountInfoMapper.updateByPrimaryKeySelective(account);
		}
	}

	@Override
	public void delAccountInfo(int accountId) {
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setAccountid(accountId);
		accountInfo.setModifydate(new Date().getTime());
		accountInfo.setState(Const.STATE_DEL);
		accountInfoMapper.updateByPrimaryKeySelective(accountInfo);
	}

}
