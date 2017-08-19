package com.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.po.User;
import com.util.HibernateSessionFactoryUtil;

public class UserDao {
	public boolean login(User user){
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		String hql="from User where username=? and password=?";//注意这里user用大写的user，表示User持久化类
		Query query=session.createQuery(hql);
		query.setParameter(0, user.getUsername());
		query.setParameter(1, user.getPassword());
		List list=query.list();
		tx.commit();
		if(list.size()>0)
		{
			return true;
		}
		else return false;
	}
	public boolean register(User user){
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		boolean flag=false;
		if(session.save(user)!=null)
		{
			flag=true;
		}
		else {
			flag=false;
		}
		tx.commit();
		if(flag==true)
		{
			return true;
		}
		else return false;
	}
	public String getPath(User user){
		String hql="select pathid from User where username=? and password=?";
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter(0, user.getUsername());
		query.setParameter(1, user.getPassword());
		List pathid=query.list();
		tx.commit();
		if(pathid!=null)
			return (String)pathid.get(0);
		else return null;
	}
	
	//得到该用户的路径
	public HashMap<Integer, Integer> splitPathid(User user)
	{
		if(user!=null)
		{
			String pathid=user.getPathid();
			String[] pathids=pathid.split("\\,");
			HashMap<Integer,Integer> pidHashMap=new HashMap<Integer,Integer>();
			for(int i=0;i<pathids.length;i++)
			{
				pidHashMap.put(Integer.parseInt(pathids[i]), Integer.parseInt(pathids[i]));
			}
			return pidHashMap;
			
		}
		return null;
	}
	
	public void updateUser(User user)
	{
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(user);
		tx.commit();
	}
	
	public User selectUser(User user)
	{
		String hql="from User where username=? and password=?";
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter(0, user.getUsername());
		query.setParameter(1, user.getPassword());
		List list=query.list();
		tx.commit();
		if(list.size()>0)
			return (User)list.get(0);
		else return null;
			
	}

}
