package service;

import model.Users;

//�û�ҵ���߼��ӿ�
public interface UsersDAO {
	
	//�û���¼����
	public boolean usersLogin(Users u);
	
	//�û�ע��
	public boolean usersRegister(Users u);
}
