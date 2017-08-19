package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.classify.FiflterClass;
import com.dao.CourseDao;
import com.dao.SubjectDao;
import com.dao.UserDao;
import com.po.Course;
import com.po.Subject;
import com.po.User;
import com.util.HibernateSessionFactoryUtil;

public class LoginServlet extends HttpServlet {
	private HttpSession session_mail=null;

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
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
	 * 做了两件事：
	 * 1、把没有subject的course进行自动归类
	 * 2、用户登录检测；如果登录不成功跳转到登录失败页面，
	 *   如果成功，检测用户是否加入过学习路径，如果没有就跳转到
	 *   “学习路径”页面，否则跳转到“所有课程”页面
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user=new User();
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		UserDao userDao=new UserDao();
		session_mail=request.getSession();
		
		//给每门课程进行自动归类
		classifyCourses();
		
		if(userDao.login(user))
		{
			user=userDao.selectUser(user);
			session_mail.setAttribute("userLogin", user);
			if(userDao.getPath(user)!=null)
				response.sendRedirect("/imooc2/main/main.jsp");
			else response.sendRedirect("/imooc2/main/path.jsp");
		}
		else
		{
			 response.sendRedirect("/imooc2/users/Users_loginfail.jsp");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	//主要思路是每门course的tag和subject的tag进行匹配，匹配次数最多的subject就是当前course的subject
	public void classifyCourses(){
		CourseDao cDao=new CourseDao();
		SubjectDao sDao=new SubjectDao();
		List<Course> allCourses=cDao.getAllCourses();
		int max=0;
		int tmpmax=0;
		FiflterClass filter=new FiflterClass();
		int indexSid = 0;
		if(allCourses!=null)
		{
			for(int i=0;i<allCourses.size();i++)
			{
				if(allCourses.get(i).getSid()==null)//如果没有设置类别，也就是没有对应的subject
				{
					//搜索所有的subject的tag组成List<String>(Arrays.asList()),算出出现的keyword的次数，并得出最大的
					List<Subject> allSubjects=sDao.getAllSubjects();
					if(allSubjects!=null)
					{
						for(int j=0;j<allSubjects.size();j++)
						{
							String tag=allSubjects.get(j).getTag();
							if(tag!=null)
							{
								List<String> keywords=sDao.splitTag(tag);
								String text=cDao.getAllString(allCourses.get(i));
								tmpmax=filter.countKeywords(text, keywords);
								
								if(tmpmax>max)
								{
									max=tmpmax;
									indexSid=allSubjects.get(j).getSid();
								}
							}
							
						}
					}
					allCourses.get(i).setSid(indexSid);//设置这个course的sid是当前subject的id
					Subject subject=sDao.getSubjectById(indexSid);
					if(subject.getCourseid()!=null)
					{
						subject.setCourseid(subject.getCourseid()+","+allCourses.get(i).getCid());
					}
					else subject.setCourseid(""+allCourses.get(i).getCid());
					sDao.updateSubject(subject);
					//循环出来之后才更新course
					cDao.updateCourse(allCourses.get(i));
				}
			}
		}
	}

}
