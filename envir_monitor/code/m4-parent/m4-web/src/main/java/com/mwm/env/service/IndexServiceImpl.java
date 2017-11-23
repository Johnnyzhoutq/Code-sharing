package com.mwm.env.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mwm.commons.commonConst.Const;
import com.mwm.commons.exception.MwmRuntimeException;
import com.mwm.env.dao.IIndexDao;
import com.mwm.env.envConst.EnvConst;
import com.mwm.env.mybatis.dao.IndexInfoMapper;
import com.mwm.env.mybatis.dao.IndexLibraryInfoMapper;
import com.mwm.env.mybatis.dao.IndexTypeInfoMapper;
import com.mwm.env.mybatis.dao.ReportInfoMapper;
import com.mwm.env.mybatis.modal.IndexInfo;
import com.mwm.env.mybatis.modal.IndexInfoExample;
import com.mwm.env.mybatis.modal.IndexLibraryInfo;
import com.mwm.env.mybatis.modal.IndexLibraryInfoExample;
import com.mwm.env.mybatis.modal.IndexTypeInfo;
import com.mwm.env.mybatis.modal.IndexTypeInfoExample;
import com.mwm.env.mybatis.modal.ProvideInfo;
import com.mwm.env.mybatis.modal.ReportInfo;
import com.mwm.env.util.DateUtil;

@Service
public class IndexServiceImpl implements IIndexService {

	@Autowired
	private IndexInfoMapper indexInfoMapper;
	@Autowired
	private ReportInfoMapper reportInfoMapper;
	@Autowired
	private IndexTypeInfoMapper indexTypeMapper;
	@Autowired
	private IndexLibraryInfoMapper indexLibraryInfoMapper;
	@Autowired
	private IIndexDao indexDao;

	@Override
	public List<Map> getReportList(Map params, PageInfo<IndexInfo> page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		return indexDao.getReportList(params);
	}

	@Override
	public int addOrEditReport(ReportInfo info) {
		if (info.getReportid() == null) { // 无主键，为新增逻辑,返回新增数据的主键
			reportInfoMapper.insertSelective(info);
			return info.getReportid();
		} else {// 有主键，为update逻辑，返回修改数据的条数
			return reportInfoMapper.updateByPrimaryKeySelective(info);
		}
	}

	@Override
	public ReportInfo getReportById(int reportId) {
		return reportInfoMapper.selectByPrimaryKey(reportId);
	}

	@Override
	public List<Map> queryIndexInfoForLib(Map params, PageInfo<IndexInfo> page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		return indexDao.queryIndexInfoForLib(params);
	}

	@Override
	public List<IndexInfo> queryIndexInfo(IndexInfo indexInfo) {
		Integer indexid = indexInfo.getIndexid();
		Integer indexLibId = indexInfo.getIndexlibid();
		Integer provideId = indexInfo.getProvideid();
		IndexInfoExample example = new IndexInfoExample();
		//查询单个指标
		if (indexLibId != null && indexid != null) {
			example.createCriteria().andIndexidEqualTo(indexid).andIndexlibidEqualTo(indexLibId)
					.andProvideidEqualTo(provideId);
		} else if (indexLibId != null) {//查询指标库指标
			example.createCriteria().andIndexlibidEqualTo(indexLibId).andProvideidEqualTo(provideId);
		} else {//查询单个指标
			example.createCriteria().andIndexidEqualTo(indexid).andProvideidEqualTo(provideId);
		}
		return indexInfoMapper.selectByExample(example);
	}

	@Override
	public void updateIndexInfo(IndexInfo indexInfo) {
		IndexInfoExample example = new IndexInfoExample();
		example.createCriteria().andStateEqualTo(Const.STATE_NORMAL).andProvideidEqualTo(indexInfo.getProvideid()).andIndexidEqualTo(indexInfo.getIndexid());
		indexInfoMapper.updateByExampleSelective(indexInfo, example);
	}
	
	@Override
	public IndexInfo validateIndexInfo(IndexInfo indexInfo) {
		IndexInfo tmp = new IndexInfo();
		tmp.setIndexid(indexInfo.getIndexid());
		tmp.setProvideid(indexInfo.getProvideid());
		List<IndexInfo> indexInfList = queryIndexInfo(tmp);
		if (indexInfList.size() == 0) {
			throw new MwmRuntimeException("权限不足");
		}
		return indexInfList.get(0);
	}

	@Override
	public int insertIndexInfo(IndexInfo indexInfo) {
		indexInfoMapper.insertSelective(indexInfo);
		return indexInfo.getIndexid();
	}

	@Override
	public void deleteIndexInfo(int provicerId,int indexId) {
		IndexInfoExample example = new IndexInfoExample();
		example.createCriteria().andStateEqualTo(Const.STATE_NORMAL).andProvideidEqualTo(provicerId).andIndexidEqualTo(indexId);
		indexInfoMapper.deleteByExample(example);
	}

	@Override
	public void deleteIndexTypeInfo(int providerId,int indexTypeId) {
		IndexTypeInfoExample example = new IndexTypeInfoExample();
		example.createCriteria().andIndextypeidEqualTo(indexTypeId).andProvideidEqualTo(providerId);
		indexTypeMapper.deleteByExample(example);
	}

	@Override
	public IndexTypeInfo validateIndexTypeInfo(IndexTypeInfo indexTypeInfo) {
		List<IndexTypeInfo> indexTypeInfoList = queryIndexTypeInfo(indexTypeInfo);
		if (indexTypeInfoList == null || indexTypeInfoList.isEmpty()) {
			throw new MwmRuntimeException("权限不足");
		}
		indexTypeInfo.setTypeflag(EnvConst.CAN_OPER);
		return indexTypeInfoList.get(0);
	}

	@Override
	public int inserIndexTypeInfo(IndexTypeInfo indexTypeInfo) {
		indexTypeMapper.insertSelective(indexTypeInfo);
		return indexTypeInfo.getIndextypeid();
	}

	@Override
	public void updateIndexTypeInfo(IndexTypeInfo indexTypeInfo) {
		IndexTypeInfoExample example = new IndexTypeInfoExample();
		example.createCriteria().andProvideidEqualTo(indexTypeInfo.getProvideid()).andIndextypeidEqualTo(indexTypeInfo.getIndextypeid());
		indexTypeMapper.updateByExampleSelective(indexTypeInfo, example);
	}

	@Override
	public List<IndexTypeInfo> queryIndexTypeInfo(IndexTypeInfo indexTypeInfo) {
		Integer indexTypeId = indexTypeInfo.getIndextypeid();
		Integer provideId = indexTypeInfo.getProvideid();
		IndexTypeInfoExample example = new IndexTypeInfoExample();
		example.createCriteria().andIndextypeidEqualTo(indexTypeId).andProvideidEqualTo(provideId);
		return indexTypeMapper.selectByExample(example);
	}

	@Override
	public List<IndexLibraryInfo> queryIndexLibraryInfo(Map params, PageInfo page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		Integer provideId = (Integer) params.get("provideId");
		
		IndexLibraryInfoExample example = new IndexLibraryInfoExample();
		example.createCriteria().andProvideidEqualTo(provideId).andStateEqualTo(Const.STATE_NORMAL);
		return indexLibraryInfoMapper.selectByExample(example);
	}

	@Override
	public int inserIndexLibraryInfo(IndexLibraryInfo indexLibraryInfo) {
		indexLibraryInfoMapper.insertSelective(indexLibraryInfo);
		return indexLibraryInfo.getIndexlibid();
	}

	@Override
	public List<IndexLibraryInfo> queryIndexLibraryInfo(IndexLibraryInfo indexLibraryInfo) {
		Integer provideId = indexLibraryInfo.getProvideid();
		Integer indexLibraryId = indexLibraryInfo.getIndexlibid();
		IndexLibraryInfoExample example = new IndexLibraryInfoExample();
		example.createCriteria().andProvideidEqualTo(provideId).andIndexlibidEqualTo(indexLibraryId);
		return indexLibraryInfoMapper.selectByExample(example);
	}

	@Override
	public void updateIndexLibrary(IndexLibraryInfo indexLibraryInfo) {
		IndexLibraryInfoExample example = new IndexLibraryInfoExample();
		example.createCriteria().andProvideidEqualTo(indexLibraryInfo.getProvideid()).andStateEqualTo(Const.STATE_NORMAL).andIndexlibidEqualTo(indexLibraryInfo.getIndexlibid());
		
		indexLibraryInfoMapper.updateByExampleSelective(indexLibraryInfo, example);
	}

	@Override
	public List<Map> queryIndexInfo(Map params, PageInfo<IndexInfo> page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		return indexDao.queryIndexInfo(params);
	}

	@Override
	public void deleteIndexLibInfo(ProvideInfo provider, int indexlibid) {
		IndexLibraryInfoExample example = new IndexLibraryInfoExample();
		example.createCriteria().andProvideidEqualTo(provider.getProvideid()).andStateEqualTo(Const.STATE_NORMAL).andIndexlibidEqualTo(indexlibid);
		
		IndexLibraryInfo libraryInfo = new IndexLibraryInfo();
		libraryInfo.setState(Const.STATE_DEL);
		indexLibraryInfoMapper.updateByExampleSelective(libraryInfo, example);
	}

	@Override
	public void validateIndexLibForProvidor(int provideId, int indexLibId) {
		IndexLibraryInfoExample example = new IndexLibraryInfoExample();
		example.createCriteria().andProvideidEqualTo(provideId).andIndexlibidEqualTo(indexLibId);
		if (indexLibraryInfoMapper.selectByExample(example).size() == 0) {
			throw new MwmRuntimeException("权限不足");
		}
	}

	@Override
	public void delReport(int reportId) {
		ReportInfo info = new ReportInfo();
		info.setDeleteflag("1");
		info.setReportid(reportId);
		addOrEditReport(info);
	}

	@Override
	public List<IndexTypeInfo> queryIndexTypeInfoList(IndexTypeInfo indexTypeInfo,PageInfo page) {
		PageHelper.startPage(page.getPageNum(),page.getPageSize());
		Integer provideId = indexTypeInfo.getProvideid();
		IndexTypeInfoExample example = new IndexTypeInfoExample();
		example.createCriteria().andProvideidEqualTo(provideId);
		return indexTypeMapper.selectByExample(example);
	}

	@Override
	public void validateIndexInfoWithLibId(IndexInfo indexInfo) {
		IndexInfo tmp = new IndexInfo();
		tmp.setIndexid(indexInfo.getIndexid());
		tmp.setIndexlibid(indexInfo.getIndexlibid());
		tmp.setProvideid(indexInfo.getProvideid());
		List<IndexInfo> indexInfList = queryIndexInfo(tmp);
		if (indexInfList.size() == 0) {
			throw new MwmRuntimeException("权限不足");
		}
	}

	@Override
	public ReportInfo validateReportInfo(ReportInfo reportInfo) {
		ReportInfo tmp = getReportById(reportInfo.getReportid());
		if (tmp == null) {
			throw new MwmRuntimeException("权限不足");
		}
		if (!reportInfo.getProvideid().equals(tmp.getProvideid())) {
			throw new MwmRuntimeException("权限不足");
		}
		return tmp;
	}

	@Override
	public void delIndexLibIndex(Integer provideid, int indexLibId, int indexId) {
		
		deleteIndexInfo(provideid, indexId);
		
		/*IndexInfoExample example = new IndexInfoExample();
		example.createCriteria().andIndexidEqualTo(indexId).andProvideidEqualTo(provideid).andIndexlibidEqualTo(indexLibId);
		
		IndexInfo index = getIndexById(indexId);
		index.setIndexlibid(null);
		
		indexInfoMapper.updateByExampleSelective(index, example);*/
	}

	@Override
	public IndexInfo getIndexById(int indexId) {
		return indexInfoMapper.selectByPrimaryKey(indexId);
	}

	@Override
	public IndexTypeInfo getIndexTypeById(Integer goodstype) {
		return indexTypeMapper.selectByPrimaryKey(goodstype);
	}

	@Override
	public List<Map> getOfficialIndex(Map params, PageInfo page) {
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		return indexDao.getOfficialIndex(params);
	}
	
	

}
