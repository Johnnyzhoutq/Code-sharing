package com.mwm.commons.bean;

import java.io.IOException;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.NestedIOException;

/**
 * 解决Mybatis不抛出异常的问题
 * @author mengweima
 *
 */
public class BeanFactory extends SqlSessionFactoryBean{
	
	@Override
	protected SqlSessionFactory buildSqlSessionFactory() throws NestedIOException {
		try {
			return super.buildSqlSessionFactory();
		} catch (IOException e) {
			e.printStackTrace();
			throw new NestedIOException("", e.getCause());
		}finally {
			ErrorContext.instance().reset();
		}
	}
}
