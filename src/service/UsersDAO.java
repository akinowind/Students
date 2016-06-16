package service;

import model.Users;

//用户业务逻辑接口
public interface UsersDAO {
	
	//用户登录方法
	public boolean usersLogin(Users u);
	
	//用户注册
	public boolean usersRegister(Users u);
}
