package com.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;






import com.po.Course;
import com.po.Video;
import com.util.HibernateSessionFactoryUtil;

public class VideoDao {
	public String getVideoNamesByCid(int cid)
	{
		String hql="from Course where cid=?";
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter(0, cid);
		List<Course> list=query.list();
		tx.commit();
		if(list.size()>0)
		{
			String videoNames=list.get(0).getCouvideo();
			return videoNames;
		}
		else return null;
	}
	
	//吧course表中的couvideo拆开
	public String[] splitVideoName(String videoName,String spliperator)
	{

		String[] tmp=null;
		if(videoName!=null)
		{
			tmp=videoName.split(spliperator);
			return tmp;
		}
		else return null;
	}
	public Video getVideoByVid(int vid)
	{
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		Video video=(Video)session.get(Video.class, vid);
		tx.commit();
		if(video!=null)
			return video;
		else return null;
	}
	public List<Video> getVideoByCid(int cid)
	{
		String hql="from Video where cid=?";
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter(0, cid);
		List<Video> videos=query.list();
		tx.commit();
		if(videos.size()>0)
			return videos;
		else return null;
	}

}
