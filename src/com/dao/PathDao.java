package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;





import com.po.Path;
import com.util.HibernateSessionFactoryUtil;

public class PathDao {
	public List<Path> showPaths()
	{
		String hql="from Path";
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery(hql);
		List list=query.list();
		tx.commit();
		if(list.size()>0)
			return list;
		else return null;
	}
	
	public String[] splitPath(String path,String spliperator)
	{
		String[] tmp=null;
		if(path!=null)
		{
			tmp=path.split(spliperator);
			return tmp;
		}
		else return null;
	}
	
	public Path getPathById(int id)
	{
		String hql="from Path where pid=?";
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter(0, id);
		List list=query.list();
		tx.commit();
		if(list.size()>0)
			return (Path)list.get(0);
		else return null;
	}
}
