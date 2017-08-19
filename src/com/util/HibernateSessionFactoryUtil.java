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
			//创建Configuration对象，读取hibernate.cfg.xml文件，完成初始化
			Configuration cof = new Configuration().configure();
			//ServiceRegistry 是 Service 的注册表, 它为Service提供了一个统一的加载 /初始化 /存放 /获取机制.
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

