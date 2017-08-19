package com.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;









import org.apache.taglibs.standard.lang.jstl.test.StaticFunctionTests;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.po.Question;
import com.po.UserQuestion;
import com.po.Type.UserQuestionPK;
import com.util.HibernateSessionFactoryUtil;

public class UserQuestionDao {
	public void saveOrUpadate(UserQuestion user_Question)
	{
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		session.saveOrUpdate(user_Question);
		tx.commit();
	}
	
	public UserQuestion getUserQuestionByPK(UserQuestionPK pk){
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		UserQuestion userQuestion=(UserQuestion) session.get(UserQuestion.class, pk);
		tx.commit();
		if(userQuestion!=null)
			return userQuestion;
		else return null;
	}
	
	//�Ѷ�Ӧuid���û��Ĵ�������浽txt�ļ��У�����logistics����
	public   void sqlToTxt(int uid) throws IOException{
		String sql="from UserQuestion where uid=?";
		Session session=HibernateSessionFactoryUtil.getSession();
		Transaction tx=session.beginTransaction();
		Query query=session.createQuery(sql);
		query.setParameter(0, uid);
		List<UserQuestion> userQuestions=query.list();
		tx.commit();
		
		File file=new File("F://myeclipsework/imooc2/WebRoot/data/tainData.txt");
		
		if(userQuestions.size()>0)
		{
			FileWriter out=new FileWriter(file);
			String tmp="";
			for(int i=0;i<userQuestions.size();i++)
			{
				//tmp��ʼ��
				tmp="";
				//�õ���Ӧ��diff
				int qid=userQuestions.get(i).getPk().getQid();
				QuestionDao qDao=new QuestionDao();
				Question question=qDao.getQuestionByQid(qid);
				float diff=question.getDiff();
				
				//�õ���Ӧ��TOrF
				float TOrF=userQuestions.get(i).getTOrF();
				
				//�浽�ַ���tmp
				tmp=diff+" "+TOrF;
				if(i!=0)
					out.write("\r\n");
				out.write(tmp);
				
			}
			out.flush();
			out.close();
		}
		
	}
}
