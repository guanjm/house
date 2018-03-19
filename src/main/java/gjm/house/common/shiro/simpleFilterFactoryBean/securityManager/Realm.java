package gjm.house.common.shiro.simpleFilterFactoryBean.securityManager;

import java.util.HashSet;
import java.util.List;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import gjm.house.common.account.spring.entity.TbUser;
import gjm.house.common.account.spring.service.IPermissionService;
import gjm.house.common.account.spring.service.IRoleService;
import gjm.house.common.account.spring.service.IUserService;
import gjm.house.common.util.ListUtil;

public class Realm extends AuthorizingRealm {
	
	private IUserService userService;
	
	private IRoleService roleService;
	
	private IPermissionService permissionService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取当前用户信息
		TbUser currentUser = (TbUser) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authInfo = new SimpleAuthorizationInfo();
		List<Object> roleIdList = roleService.getRoleId(currentUser.getId());
		authInfo.setRoles(new HashSet<String>(ListUtil.turn(roleIdList, String.class)));
		List<Object> permissionIdList =  permissionService.getPermissionId(currentUser.getId());
		authInfo.setStringPermissions(new HashSet<String>(ListUtil.turn(permissionIdList, String.class)));
		return authInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auToken) throws AuthenticationException {
		//登录信息
		UsernamePasswordToken upToken = (UsernamePasswordToken)auToken;
		String userName = upToken.getUsername();
		String userPassword = new String(upToken.getPassword());
		//用户认证
		TbUser user = userService.authenticate(userName, userPassword);
		if(user == null) {
			throw new AccountException("账号或密码不正确！");
		} else if (user.getFlag() == 1) {
			throw new DisabledAccountException("该账号已失效！");
		}
		//封装认证信息
		return new SimpleAuthenticationInfo(user, userPassword, user.getUserName());
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public void setPermissionService(IPermissionService permissionService) {
		this.permissionService = permissionService;
	}
	
}
