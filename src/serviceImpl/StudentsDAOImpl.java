package serviceImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.MyHibernateSessionFactory;

import model.Students;
import service.StudentsDAO;

public class StudentsDAOImpl implements StudentsDAO {
	
	public List<Students> queryAllStudents() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		List<Students> list = null;
		String hql = "";
		System.out.println("queryStudents-----");
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Students";
			Query query = session.createQuery(hql);
			list= query.list();
			tx.commit();
			return list;
				
		}catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			System.out.println("queryStudents13-----");
			return list;
		}finally{
			if(tx!=null){
				tx = null;
			}
		}
		
	}
	public List<Students> queryStudents(String sid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		List<Students> list = null;
		String hql = "";
		System.out.println("queryStudentsByid-----"+sid);
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			hql = "from Students stu where stu.sid ="+sid+"";
			Query query = session.createQuery(hql);
			list= query.list();
			System.out.println("queryStudentsByid-----"+list.size());
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
	
	public boolean addStudents(Students s) {
		// TODO Auto-generated method stub
		s.setSid(getNewSid());//����ѧ����ѧ��
		Transaction tx = null;
		
		String hql = "";
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.save(s);
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

	public boolean deleteStudents(String sid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		//String hql = "";
		
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			Students s = (Students)session.get(Students.class, sid);
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
	
	

	public Students queryStudentsBySid(String sid) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		Students s = null;
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			s = (Students)session.get(Students.class, sid);
			tx.commit();
			return s;
				
		}catch(Exception ex){
			ex.printStackTrace();
			tx.commit();
			return s;
		}finally{
			if(tx!=null){
				tx = null;
			}
		}
	}

	public boolean updateStudents(Students s) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try{
			System.out.println("-----updateStudents-----");
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			session.update(s);
			tx.commit();
			System.out.println("------------------update_sucees-------");
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
	
	//����ѧ����ѧ��
	private String getNewSid(){
		Transaction tx = null;
		String hql = "";
		String sid = null;
		
		try{
			Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
			tx = session.beginTransaction();
			//��õ�ǰѧ���������
			hql = "select max(sid) from Students";
			Query query = session.createQuery(hql);
			sid = (String)query.uniqueResult();  //uniqueResult���󷵻�object����
			if(sid == null||"".equals(sid)){
				//��һ��Ĭ�ϵ����仯
				sid="20130001";
			}else{
				int i = Integer.parseInt(sid);//ת������
				i++;
				sid = String.valueOf(i);//��ԭ���ַ���
				
			}
			tx.commit();
			return sid;
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
