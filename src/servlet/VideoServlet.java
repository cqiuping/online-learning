package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VideoDao;

public class VideoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public VideoServlet() {
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
	 * 主要通过courseid跳转到coursedetail.jsp显示当前course的章节video信息
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String  tmpcid=request.getParameter("courseid");
		int cid=Integer.parseInt(tmpcid);
		VideoDao vDao=new VideoDao();
		String videoNames=vDao.getVideoNamesByCid(cid);
		if(videoNames!=null)
		{
			request.setAttribute("cid", cid);
			request.setAttribute("videoNames", videoNames);
			request.getRequestDispatcher("/main/coursedetail.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("/main/404.jsp");
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
