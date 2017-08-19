package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CourseDao;
import com.po.Course;

public class CourseServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CourseServlet() {
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
	 *��Ҫ����չʾcourse�����������������һ������ĳ��subject�����course
	 *�����������е�course��ͨ������"type"����
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session=request.getSession();
		String type=request.getParameter("type");
		int sid;
		CourseDao cDao=new CourseDao();
		//�����bySubject���͵õ�sid��ͨ��sid�õ����е�course
		if(type.equals("bySubject"))
		{
			if(request.getParameter("sid")!=null)
			{
				sid=Integer.parseInt(request.getParameter("sid"));
				List<Course> list=cDao.getCourseBySid(sid);
				request.setAttribute("courses", list);
				request.setAttribute("sid", sid);
				request.getRequestDispatcher("/main/coursesBySub.jsp").forward(request, response);
			}
			else {
				response.sendRedirect("/imooc2/main/404.jsp");
			}
			
		}
		//�����all˵����չʾ���пγ�
		else if(type.equals("all"))
		{
			
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

}
