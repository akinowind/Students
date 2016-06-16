package action;

import org.apache.struts2.interceptor.validation.SkipValidation;

import service.UsersDAO;
import serviceImpl.UsersDAOImpl;
import model.Users;

import com.opensymphony.xwork2.ModelDriven;

public class UsersAction extends SuperAction implements ModelDriven<Users>{
	
	/**
	 * ģ�������ķ�ʽ���ݱ�
	 */
	private static final long serialVersionUID = 1L;   //��ʼ��
	private Users user = new Users();
	
	//�û���¼����
	public String login(){
		UsersDAO udao = new UsersDAOImpl();
		if(udao.usersLogin(user)){
			//��session�б����¼�ɹ����û���
			session.setAttribute("loginUserName", user.getUname());
			return "login_success";
		}else{
			return "login_failure";
		}
	}
	
	//�û�ע�ᶯ��
	public String register(){
		UsersDAO udao = new UsersDAOImpl();
		if(udao.usersRegister(user)){
			return "register_success";
		}else{
			return "register_failure";
		}
	}
	//�û�ע��
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
		//�û�������Ϊ��
		if("".equals(user.getUname().trim())){
			this.addFieldError("usernameError", "�û�������Ϊ�գ�");
		}
		if(user.getUpasswd().length()<6){
			this.addFieldError("passwordError", "���볤�Ȳ�С��6λ");
		}
	}

	public Users getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}
	
}
