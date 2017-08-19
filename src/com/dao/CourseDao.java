package com.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;





import com.po.Course;
import com.util.HibernateSessionFactoryUtil;

public class CourseDao {
	public List<Course> getCourseBySid(int sid)
	{
		String hql="from Course where sid=?";
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter(0, sid);
		List list=query.list();
		tx.commit();
		if(list.size()>0)
			return list;
		else return null;
			
	}
	public Course getCourseByCid(int cid)
	{
		String hql="from Course where cid=?";
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter(0, cid);
		List list=query.list();
		tx.commit();
		if(list.size()>0)
			return (Course)list.get(0);
		else return null;
	}
	
	public void updateCourse(Course course)
	{
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(course);
		tx.commit();
	}
	
	public List<Course> getAllCourses()
	{
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		String hql="from Course";
		Query query=session.createQuery(hql);
		List list=query.list();
		tx.commit();
		if(list!=null)
			return list;
		else return null;
		
	}
	
	//获得该course的descr和章节标题的字符串，以便筛选keyword
	public String getAllString(Course course)
	{
		String text=course.getCoudesc();
		String videosName=course.getCouvideo();
		VideoDao vDao=new VideoDao();
		String[] chapters=vDao.splitVideoName(videosName, "\\|");
		String videos[]=null;
		for(int i=0;i<chapters.length;i++)
		{
			videos=vDao.splitVideoName(chapters[i], "\\,");
			text+=" "+videos[0];//连接上章节标题
			for(int j=1;j<videos.length;j++)
			{
				text+=" "+vDao.getVideoByVid(Integer.parseInt(videos[j])).getVname();
			}
		}
		return text;
	}
	
}
