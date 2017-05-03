package com.hiext.mms.core.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import com.hiext.mms.core.config.Resources;
import com.hiext.mms.core.exception.LoginException;

/**
 * shiro登陆
 * @author angy.zhang
 *
 */
public final class LoginHelper {
	private LoginHelper() {
	}

	/** 用户登录 */
	public static final Boolean login(String account, String password) {
		UsernamePasswordToken token = new UsernamePasswordToken(account, password);
		token.setRememberMe(true);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return subject.isAuthenticated();
		} catch (LockedAccountException e) {
			throw new LoginException(Resources.getMessage("ACCOUNT_LOCKED", token.getPrincipal()));
		} catch (DisabledAccountException e) {
			throw new LoginException(Resources.getMessage("ACCOUNT_DISABLED", token.getPrincipal()));
		} catch (ExpiredCredentialsException e) {
			throw new LoginException(Resources.getMessage("ACCOUNT_EXPIRED", token.getPrincipal()));
		} catch (Exception e) {
			throw new LoginException(Resources.getMessage("LOGIN_FAIL"), e);
		}
	}
}
