package serviceImpl;

import java.util.List;

import model.Teachers;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import service.TeachersDAO;

import dao.MyHibernateSessionFactory;

public class TeachersDAOImpl implements TeachersDAO {
	
	public List<Teachers> queryAllTeachers() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		List<Teachers> list = null;
		String hql = "";
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Teachers";
			Query query = session.createQuery(hql);
				
			list= query.list();
			tx.commit();
			return list;
				
		}catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return list;
		}finally{
			if(tx!=null){
				tx = null;
			}
		}
		
	}

	public boolean addTeachers(Teachers t) {
		// TODO Auto-generated method stub
		t.setTid(getNewTid());//����ѧ����ѧ��
		Transaction tx = null;
		
		String hql = "";
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(t);
			tx.commit();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return false;
		}finally{
			if(tx!=null){
				tx = null;
			}
		}
	}

	public boolean deleteTeachers(String tid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		//String hql = "";
		
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Teachers s = (Teachers)session.get(Teachers.class, tid);
			session.delete(s);
			tx.commit();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return false;
		}finally{
			if(tx!=null){
				tx = null;
			}
		}
	}

	public Teachers queryTeachersByTid(String tid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Teachers t = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			t = (Teachers)session.get(Teachers.class, tid);
			tx.commit();
			return t;
				
		}catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return t;
		}finally{
			if(tx!=null){
				tx = null;
			}
		}
	}

	public boolean updateTeachers(Teachers t) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try{
			System.out.println("-----updateTeachers-----");
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(t);
			tx.commit();
			System.out.println("------------------update_success-------");
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return false;
		}finally{
			if(tx!=null){
				tx = null;
			}
		}
	}
	//���ɽ�ʦ��ѧ��
	private String getNewTid(){
		Transaction tx = null;
		String hql = "";
		String tid = null;
		
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			//��õ�ǰѧ���������
			hql = "select max(tid) from Teachers";
			Query query = session.createQuery(hql);
			tid = (String)query.uniqueResult();  //uniqueResult���󷵻�object����
			if(tid == null||"".equals(tid)){
				//��һ��Ĭ�ϵ����仯
				tid="00000001";
			}else{
				int i = Integer.parseInt(tid);//ת������
				i++;
				tid = String.valueOf(i);//��ԭ���ַ���
				
			}
			tx.commit();
			return tid;
		}catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return null;
		}finally{
			if(tx!=null){
				tx = null;
			}
		}
	}

}
