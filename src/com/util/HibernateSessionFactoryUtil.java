package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateSessionFactoryUtil {
		private static SessionFactory sessionFactory;
		private static Session session;
		static {
			//����Configuration���󣬶�ȡhibernate.cfg.xml�ļ�����ɳ�ʼ��
			Configuration cof = new Configuration().configure();
			//ServiceRegistry �� Service ��ע���, ��ΪService�ṩ��һ��ͳһ�ļ��� /��ʼ�� /��� /��ȡ����.
			ServiceRegistryBuilder ssrb = new ServiceRegistryBuilder()
					.applySettings(cof.getProperties());
			ServiceRegistry ssr=ssrb.buildServiceRegistry();
			sessionFactory=cof.buildSessionFactory(ssr);
		}
		public static SessionFactory getSessionFactory(){
			return sessionFactory;
		}
		
		public static Session getSession(){
			session=sessionFactory.getCurrentSession();
			return session;
		}
	}

