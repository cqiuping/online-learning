package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import com.dao.PathDao;
import com.dao.UserDao;
import com.po.Path;
import com.po.User;

public class PathServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PathServlet() {
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
	 * 1、把用户加入的路径id存入到用户信息中并且更新当前session中的"userLogin"
	 * 2、页面跳转到"pathdetail"
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String tmppid=(String)request.getParameter("pid");
		System.out.println(tmppid);
		int pid= Integer.valueOf(tmppid).intValue();
		PathDao pdao=new PathDao();
		UserDao udao=new UserDao();
		Path path=pdao.getPathById(pid);
		
		//如果用户之前没有加入过“路径”，直接存入 就可以
		User user=(User)session.getAttribute("userLogin");
		if(user.getPathid()==null)
			user.setPathid(tmppid);
			
		//如果用户有加入过其他“路径”，数据表中需要增添","做间隔
		else {
			HashMap<Integer, Integer> userpaths=udao.splitPathid(user);
			if(!userpaths.containsKey(pid))
				user.setPathid(user.getPathid()+","+tmppid);
		}
		udao.updateUser(user);
		session.setAttribute("userLogin", user);
		if(path!=null)
		{
//			if(session.getAttribute(path.getPname())!=null)
//			{
//				if(!session.getAttribute(path.getPname()).equals("2"))//只要没有学习完，就把进度设置为1
//					session.setAttribute(path.getPname(), "1");
//				else 
//					session.setAttribute(path.getPname(), "2");
//			}
//			else {
//					session.setAttribute(path.getPname(), "1");
//			}
//			
			request.setAttribute("path", path); 
			request.getRequestDispatcher("/main/pathdetail.jsp").forward(request, response);
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
