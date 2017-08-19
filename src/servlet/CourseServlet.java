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
	 *主要负责展示course，会有两种情况请求，一是请求某个subject下面的course
	 *二是请求所有的course，通过参数"type"区分
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session=request.getSession();
		String type=request.getParameter("type");
		int sid;
		CourseDao cDao=new CourseDao();
		//如果是bySubject，就得到sid，通过sid得到所有的course
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
		//如果是all说明是展示所有课程
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
