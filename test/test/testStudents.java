package test;

import java.util.Date;

import model.Students;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import org.junit.Test;

public class testStudents {
	@Test
	public void testSchemaExport(){
		//����һ�����ö���
		Configuration config = new Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//����sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.getCurrentSession();
		//����SchemaExport����
		SchemaExport export = new SchemaExport(config);
		
		export.create(true, true);
	}
	
	//��Ӳ�������
	@Test
	public void testSaveStudents(){
		//����һ�����ö���
		Configuration config = new Configuration().configure();
		//��������ע�����
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//����sessionFactory
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		//����session����
		Session session = sessionFactory.getCurrentSession();
		//�����������
		Transaction tx = session.beginTransaction();
		
		Students s1 = new Students("20133224","ׯ����","Ů", new Date(),"����");
		Students s2 = new Students("20133225","Ф��","Ů", new Date(),"��ұ");
		Students s3 = new Students("20133226","����","Ů", new Date(),"��ұ");
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		
		tx.commit();
		sessionFactory.close();
		
	}
}
