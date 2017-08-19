package com.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;




import com.po.UserCourse;
import com.po.Type.UserCoursePK;
import com.util.HibernateSessionFactoryUtil;

public class UserCourseDao {
	
	public UserCourse getUserCourseByPK(int uid,int cid){
		UserCoursePK pk=new UserCoursePK();
		pk.setCid(cid);
		pk.setUid(uid);
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		UserCourse userCourse=(UserCourse)session.get(UserCourse.class, pk);
		tx.commit();
		if(userCourse!=null)
			return userCourse;
		else return null;
	}
	
	public void saveInfo(UserCourse userCourse)
	{
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(userCourse);
		tx.commit();
	}
	
	//通过cid查UserCourse，便于更新course表
	public List<UserCourse> getUserCourseByCid(int cid)
	{
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		String hql="from UserCourse where cid=?";
		Query query=session.createQuery(hql);
		query.setParameter(0, cid);
		List<UserCourse> list=query.list();
		tx.commit();
		if(list.size()>0)
			return list;
		else return null;
	}

}
