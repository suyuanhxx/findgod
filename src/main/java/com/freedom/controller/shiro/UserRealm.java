package com.freedom.controller.shiro;

/**
 * Created by Huangxiaoxu on 2016/6/7.
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.freedom.bean.Role;
import com.freedom.bean.User;
import com.freedom.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserRealm extends AuthorizingRealm{

    @Autowired
    private UserService userService;

    /**
     * 授权操作
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		String username = (String) getAvailablePrincipal(principals);
        String username = (String) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        return authorizationInfo;
    }

    /**
     * 身份验证操作
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();
        User user = new User();

        if(user==null) {
            throw new UnknownAccountException("没有找到该账号");
        }

        /**
         * 交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以在此判断或自定义实现
         */
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getLoginname(), user.getPassword(),getName());

        return info;
    }

    @Override
    public String getName() {
        return getClass().getName();
    }

}