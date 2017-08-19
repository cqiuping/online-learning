package com.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.po.Course;
import com.po.Subject;
import com.util.HibernateSessionFactoryUtil;

public class SubjectDao {
	public Subject getSubjectById(int sid)
	{
		String hql="from Subject where sid=?";
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter(0, sid);
		List list=query.list();
		tx.commit();
		if(list.size()>0)
			return (Subject)list.get(0);
		else return null;
	}
	public List<Subject> getAllSubjects(){
		String hql="from Subject";
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery(hql);
		List list=query.list();
		tx.commit();
		if(list.size()>0)
			return list;
		else return null;
	}
	public List<String> splitTag(String tag)
	{
		if(tag!=null)
		{
			String[] tags=tag.split("\\,");
			List<String> tagList=Arrays.asList(tags);
			return tagList; 
		}
		else return null;
	}
	
	public void updateSubject(Subject subject)
	{
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(subject);
		tx.commit();
	}

}
