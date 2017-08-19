package com.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.po.UserCourse;
import com.po.UserVideo;
import com.po.Type.UserCoursePK;
import com.po.Type.UserVideoPK;
import com.util.HibernateSessionFactoryUtil;

public class UserVideoDao {
	public UserVideo getUserVideoByPK(int uid,int vid){
		UserVideoPK pk=new UserVideoPK();
		pk.setVid(vid);
		pk.setUid(uid);
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		UserVideo userVideo=(UserVideo)session.get(UserVideo.class, pk);
		tx.commit();
		if(userVideo!=null)
			return userVideo;
		else return null;
	}
	
	public void saveInfo(UserVideo userVideo)
	{
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(userVideo);
		tx.commit();
	}
}
