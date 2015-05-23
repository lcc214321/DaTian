package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Goodsform;
import cn.edu.bjtu.vo.Userinfo;

public interface AuthenticationDao {
	public List getAllAuthentication();
	public Clientinfo getAuthenticationInfo(String clientId);
	public Userinfo getMyUserDetail(String clientId);

}