package com.zqs.utils.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zqs.model.cms.User;
import com.zqs.service.cms.IUserService;
/**
 * shiro权限、登录认证
 * 
 * @author qiushi.zhou  
 * @date 2016年8月24日 上午9:30:53
 */
@Service("shiroDbRealm")
public class ShiroDbRealm extends AuthorizingRealm{
	
	
	private static final Logger logger = LoggerFactory.getLogger(ShiroDbRealm.class);
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 权限认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
//		SysUser user = (SysUser) principals.fromRealm(getName()).iterator().next();
//		if(null == user) return null;
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		SysUserRole userRole = sysUserRoleService.loadByUsername(user.getUsername());
//		if(null == userRole) return null;
//		info.addRole(userRole.getRole().getCode());
//		return info;
		return null;
	}
	
	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken anthenticationToken) throws AuthenticationException {
		
		UsernamePasswordToken token = (UsernamePasswordToken) anthenticationToken;
		
		User user = userService.loadUserByloginname(token.getUsername());
		if(null != user){
			if((new String(token.getPassword())).equals(user.getLoginPwd())){
				SecurityUtils.getSubject().getSession().setAttribute("user", user);
				SecurityUtils.getSubject().getSession().setTimeout(1000 * 60 * 60 * 24);//会话时间设置：24h
				
				SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getLoginPwd(), getName());
				return info;
			}else{
					logger.info("user [{}] authenticated fail with wrong password.", token.getUsername());
			}
		}else{
			logger.info("user [{}] authenticated fail with not exists.", token.getUsername());
		}
		
		throw new AuthenticationException("can't.find.user");
	}
}
