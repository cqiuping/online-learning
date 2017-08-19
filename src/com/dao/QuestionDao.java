package com.dao;

import java.util.Arrays;
import java.util.List;








import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.classify.KeywordFilter;
import com.classify.KeywordFilterBuilder;
import com.po.Question;
import com.po.Video;
import com.util.HibernateSessionFactoryUtil;

public class QuestionDao {
	
	public List<Question> getQuestionsByCid(int cid)
	{
		String hql="from Question where cid=?";
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery(hql);
		query.setParameter(0, cid);
		List<Question> list=query.list();
		tx.commit();
		if(list.size()>0)
			return list;
		else return null;
		
	}
	public Question getQuestionByQid(int qid)
	{
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		Question question=(Question) session.get(Question.class, qid);
		tx.commit();
		if(question!=null)
			return question;
		else return null;
	}
	public String[] splitQuestionContent(String questionContent)
	{
		if(questionContent!=null)
		{
			String[] content=questionContent.split("\\|");
			return content; 
		}
		else return null;
	}
	
	public String[] splitTag(String tag)
	{
		if(tag!=null)
		{
			String[] tags=tag.split("\\,");
			return tags; 
		}
		else return null;
	}
	
	public Integer getVidByTag(String tag,int cid)
	{
		 KeywordFilterBuilder builder = new KeywordFilterBuilder();
		 builder.setKeywords(Arrays.asList(tag));
		 builder.setSkipChars(Arrays.asList('*', ' ', '_', '-', '£¬'));
		KeywordFilter filter = builder.build();
		VideoDao vDao=new VideoDao();
		List<Video> videos=vDao.getVideoByCid(cid);
		
		if(videos!=null)
		{
			for(int i=0;i<videos.size();i++)
			{
				if(videos.get(i).getTag()!=null)
				{
					if(filter.hasKeywords(videos.get(i).getTag()))
					{
						return videos.get(i).getVid();
					}
				}
			}
			return null;
		}
		else return null;
	}
}
