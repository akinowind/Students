package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UsersDAO;
import serviceImpl.UsersDAOImpl;
import model.Users;

import com.opensymphony.xwork2.ModelDriven;

public class UsersAction extends SuperAction implements ModelDriven<Users>{
	
	/**
	 * 模型驱动的方式传递表单
	 */
	private static final long serialVersionUID = 1L;   //初始化
	private Users user = new Users();
	
	//用户登录动作
	public String login(){
		UsersDAO udao = new UsersDAOImpl();
		if(udao.usersLogin(user)){
			//在session中保存登录成功的用户名
			session.setAttribute("loginUserName", user.getUname());
			return "login_success";
		}else{
			return "login_failure";
		}
	}
	
	//用户注册动作
	public String register(){
		UsersDAO udao = new UsersDAOImpl();
		if(udao.usersRegister(user)){
			return "register_success";
		}else{
			return "register_failure";
		}
	}
	//用户注销
	@SkipValidation
	public String  logout(){
		if(session.getAttribute("loginUserName")!=null){
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		//用户名不能为空
		if("".equals(user.getUname().trim())){
			this.addFieldError("usernameError", "用户名不能为空！");
		}
		if(user.getUpasswd().length()<6){
			this.addFieldError("passwordError", "密码长度不小于6位");
		}
	}

	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}
	
}
