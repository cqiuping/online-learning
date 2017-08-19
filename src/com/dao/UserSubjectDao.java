package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.po.UserCourse;
import com.po.UserSubject;
import com.po.Type.UserCoursePK;
import com.po.Type.UserSubjectPK;
import com.util.HibernateSessionFactoryUtil;

public class UserSubjectDao {
	public UserSubject getUserSubjectByPK(int uid,int sid){
		UserSubjectPK pk=new UserSubjectPK();
		pk.setSid(sid);;
		pk.setUid(uid);
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		UserSubject userSubject=(UserSubject)session.get(UserSubject.class, pk);
		tx.commit();
		if(userSubject!=null)
			return userSubject;
		else return null;
	}
	
	public void saveInfo(UserSubject userSubject)
	{
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(userSubject);
		tx.commit();
	}

}
