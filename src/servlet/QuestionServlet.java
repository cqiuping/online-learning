package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.dao.QuestionDao;
import com.dao.UserQuestionDao;
import com.po.Question;
import com.po.User;
import com.po.UserQuestion;
import com.po.Type.UserQuestionPK;
import com.util.LRWork;
import com.util.LogisticRegression;

public class QuestionServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QuestionServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doPost(request, response);
	}

	/**
	 * ��Ҫ������û������ύ�Ĵ𰸼��Դ�����ͨ��LR�㷨����������������
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String answer=request.getParameter("answer");
		int cid=Integer.parseInt(request.getParameter("cid"));
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("userLogin");
		UserQuestion userQuestion=new UserQuestion();
		UserQuestionDao uqDao=new UserQuestionDao();
		String[] answers=null;
		String check="";
		if(answer!=null)
		{
			answers=answer.split("\\,");
			QuestionDao qDao=new QuestionDao();
			List<Question> questions=qDao.getQuestionsByCid(cid);
			if(questions!=null)
			{
				for(int i=0;i<questions.size();i++)
				{
					Question question=questions.get(i);
					UserQuestionPK pk=new UserQuestionPK();
					pk.setQid(question.getQid());
					pk.setUid(user.getUid());
					userQuestion.setPk(pk);
					if(question.getAnswer().equals(answers[i]))
					{
						
						userQuestion.setTOrF((float) 1.0);
							check+="1";
							
					}
					else 
						{
							userQuestion.setTOrF((float) 0.0);
							check+="0";
						}
					uqDao.saveOrUpadate(userQuestion);
				}
			}
		}
		
		//�õ��������
		String degree=request.getParameter("degree");//�õ��û���Ҫ�����ſε����ճ̶�
		System.out.println("degree��ֵ��:"+degree);
		double threshold=0;//������ֵ
		if(degree!=null)
		{
			if(degree.equals("known"))
			{
				threshold=3.5;
			}
			else if(degree.equals("familiar"))
			{
				threshold=4.0;
			}
			else
			{
				threshold=4.8;
			}
		}
		uqDao.sqlToTxt(user.getUid());//�ȴ����ݿ��еõ����ݴ浽txt�ļ���
		String file="F://myeclipsework/imooc2/WebRoot/data/tainData.txt";
		LRWork lrWork=new LRWork();
		double result=lrWork.calAbility(threshold, file);//��txt�ļ������ݽ�������
		
		request.getRequestDispatcher("../main/check.jsp?check="+check+"&cid="+cid+"&result="+result).forward(request, response);
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
