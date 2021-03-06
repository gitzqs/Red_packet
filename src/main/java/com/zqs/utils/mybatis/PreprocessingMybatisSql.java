package com.zqs.utils.mybatis;

import java.sql.Connection;
import java.util.Date;
import java.util.Properties;

import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zqs.model.cms.User;
/**
 * mybatis拦截器
 * 
 * @author qiushi.zhou  
 * @date 2018年6月2日 下午1:50:05
 */
@Intercepts({@Signature(method = "prepare", type = StatementHandler.class, args = {Connection.class})})
public class PreprocessingMybatisSql implements Interceptor{

	   private static final Logger logger = LoggerFactory.getLogger(PreprocessingMybatisSql.class);
	    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
	    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY =
	            new DefaultObjectWrapperFactory();

	    @Override
	    public Object intercept(Invocation invocation) throws Throwable {
	        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
	        MetaObject metaStatementHandler =
	                MetaObject.forObject(statementHandler, DEFAULT_OBJECT_FACTORY,
	                        DEFAULT_OBJECT_WRAPPER_FACTORY);

	        MappedStatement mappedStatement =
	                (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
	        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();

	        BoundSql boundSql = ((RoutingStatementHandler) invocation.getTarget()).getBoundSql();
	        
	        if (sqlCommandType.equals(SqlCommandType.UPDATE)) {
	            Subject subject = null;
	            try {
	                subject = SecurityUtils.getSubject();
	            } catch (Exception ex) {
	                logger.error("can't get current user, may be not authenticated! \n\t exception is :{}", ex.getLocalizedMessage());
	            }
	            User user = (subject == null) ? null : (User) subject.getPrincipal();
	            boundSql.setAdditionalParameter("lastOperatorId", user == null ? 0L : user.getId());
	            boundSql.setAdditionalParameter("lastOperatedTime", new Date());
	        } else if (sqlCommandType.equals(SqlCommandType.INSERT)) {
	            logger.debug(".begin to set additional params with RInfo");
	            Subject subject = null;
	            try {
	                subject = SecurityUtils.getSubject();
	            } catch (Exception ex) {
	                logger.error("can't get current user, may be not authenticated! \n\t exception is :{}", ex.getLocalizedMessage());
	            }
	            User user = (subject == null) ? null : (User) subject.getPrincipal();
	            boundSql.setAdditionalParameter("creatorId", user == null ? 0L : user.getId());
	            boundSql.setAdditionalParameter("createdTime", new Date());
	        }
	        return invocation.proceed();
	    }

	    @Override
	    public Object plugin(Object target) {
	        if (target instanceof StatementHandler) {
	            return Plugin.wrap(target, this);
	        } else {
	            return target;
	        }
	    }

	    @Override
	    public void setProperties(Properties properties) {}
}
