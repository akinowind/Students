package serviceImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.MyHibernateSessionFactory;

import service.UsersDAO;
import model.Users;

public class UsersDAOImpl implements UsersDAO{

	public boolean usersLogin(Users u) {
		// TODO Auto-generated method stub
		//事务对象
		Transaction tx = null;
		String hql = "";
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Users where uname = ? and upasswd = ?";
			Query query = session.createQuery(hql);
			query.setParameter(0, u.getUname());
			query.setParameter(1, u.getUpasswd());
			List list = query.list();//查询返回结果集
			System.out.println("-----0---------"+u.getUname());
			System.out.println("-----1---------"+list.size());
			System.out.println("-----2---------"+u.getUpasswd());
			tx.commit();
		
			if(list.size()>0){
				return true;
			}else{
				return false;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			if(tx!= null){
				
				tx = null;
			}
		}
	}

	public boolean usersRegister(Users u) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
