package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyHibernateSessionFactory {
	private static SessionFactory sessionFactory;
	//���췽��˽�л�����֤����ģʽ
	private MyHibernateSessionFactory(){
		
	}
	//���еľ�̬��������ûỰ��������
	public static SessionFactory getSessionFactory(){
		if(sessionFactory == null){
			//����һ�����ö���
			Configuration config = new Configuration().configure();

			//��������ע�����
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
			//����sessionFactory
			sessionFactory = config.buildSessionFactory(serviceRegistry);
			return sessionFactory;
		}else{
			return sessionFactory;
		}
	}
}