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
	 * ���������£�
	 * 1�����û������·��id���뵽�û���Ϣ�в��Ҹ��µ�ǰsession�е�"userLogin"
	 * 2��ҳ����ת��"pathdetail"
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
		
		//����û�֮ǰû�м������·������ֱ�Ӵ��� �Ϳ���
		User user=(User)session.getAttribute("userLogin");
		if(user.getPathid()==null)
			user.setPathid(tmppid);
			
		//����û��м����������·���������ݱ�����Ҫ����","�����
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
//				if(!session.getAttribute(path.getPname()).equals("2"))//ֻҪû��ѧϰ�꣬�Ͱѽ�������Ϊ1
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
