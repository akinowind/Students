package serviceImpl;

import junit.framework.Assert;
import model.Users;

import org.junit.Test;

import service.UsersDAO;

public class TestUsersDAOImpl {
	@Test
	public void testUsersLogin(){
		Users u = new Users(1,"zll","2007");
		UsersDAO udao = new UsersDAOImpl();
		Assert.assertEquals(true, udao.usersLogin(u));
		
	}

}

