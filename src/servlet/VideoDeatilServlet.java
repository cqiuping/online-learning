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
import com.dao.UserCourseDao;
import com.dao.UserSubjectDao;
import com.dao.UserVideoDao;
import com.dao.VideoDao;
import com.po.Course;
import com.po.User;
import com.po.UserCourse;
import com.po.UserSubject;
import com.po.UserVideo;
import com.po.Video;
import com.po.Type.UserCoursePK;
import com.po.Type.UserSubjectPK;
import com.po.Type.UserVideoPK;

public class VideoDeatilServlet extends HttpServlet {
	private VideoDao vdao=null;
	private CourseDao cdao=null;
	private UserSubjectDao usdao=null;
	private UserVideoDao uvdao=null;
	private UserCourseDao ucdao=null;
	private HttpSession session=null;
	

	/**
	 * Constructor of the object.
	 */
	public VideoDeatilServlet() {
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
	 * 主要负责显示对应vid的video
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int vid=Integer.parseInt(request.getParameter("vid"));
		String look=request.getParameter("look"); //如果look不是2,说明是用户自己点到这个video的链接，如果是2说明这个video已经播放完
		vdao=new VideoDao();
		cdao=new CourseDao();
		ucdao=new UserCourseDao();
		usdao=new UserSubjectDao();
		uvdao=new UserVideoDao();
		Video video=vdao.getVideoByVid(vid);
		Course course=cdao.getCourseByCid(video.getCid());
		session=request.getSession();
		
	
		
		//把相应信息存入User_Course表
		this.saveOrUpdateUserCourse(vid,course);
		//把相应信息存入user_subject表
		this.saveOrUpdateUserSubject(course, look);
		//把相应信息存入user_video表
		this.saveOrUpdateUserVideo(video, look);
		//跳转到video。jsp页面,把vid传给页面
		
		//更新course表中的num
		List<UserCourse> list=ucdao.getUserCourseByCid(course.getCid());
		if(list!=null)
		{
			course.setNum(list.size());
			cdao.updateCourse(course);
		}
		else {
			course.setNum(0);
			cdao.updateCourse(course);
		}
		
		if(!look.equals("2"))
		{
			request.getRequestDispatcher("../main/video.jsp?vid="+vid).forward(request, response);
		}
		else 
		{
			//用户选择跳转到下一个视频
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
	public void saveOrUpdateUserCourse(int vid,Course course){
		UserCourse userCourse=null;
		int cid=course.getCid();
		int uid=((User)session.getAttribute("userLogin")).getUid();
		//如果得到的User_Course为空，就要新增一个
		userCourse=ucdao.getUserCourseByPK(uid, cid);
		if(userCourse==null)
		{
			userCourse=new UserCourse();
			UserCoursePK pk=new UserCoursePK();
			pk.setCid(cid);
			pk.setUid(uid);
			userCourse.setPk(pk);
			userCourse.setTid(course.getTid());
			userCourse.setUser_look_num(1);
			userCourse.setLast_look_vid(vid);
			ucdao.saveInfo(userCourse);
		}
		else 
		{
			int new_user_look_num=userCourse.getUser_look_num()+1;
			userCourse.setUser_look_num(new_user_look_num);
			ucdao.saveInfo(userCourse);
		}
	}
	
	public void saveOrUpdateUserSubject(Course course,String look){
		int sid=course.getSid();
		int uid=((User)session.getAttribute("userLogin")).getUid();
		UserSubject userSubject=null;
		userSubject=new UserSubject();
		UserSubjectPK pk=new UserSubjectPK();
		pk.setSid(sid);
		pk.setUid(uid);
		userSubject.setPk(pk);
		if(!look.equals("2"))
		{
			userSubject.setLook(1);
		}
		else
		{
			userSubject.setLook(2);
		}
		usdao.saveInfo(userSubject);
	}
	
	public void saveOrUpdateUserVideo(Video video,String look){
		int vid=video.getVid();
		int uid=((User)session.getAttribute("userLogin")).getUid();
		UserVideo userVideo=null;
		userVideo=new UserVideo();
		UserVideoPK pk=new UserVideoPK();
		pk.setVid(vid);
		pk.setUid(uid);
		userVideo.setPk(pk);
		if(!look.equals("2"))
		{
			userVideo.setLook(1);
		}
		else
		{
			userVideo.setLook(2);
		}
		uvdao.saveInfo(userVideo);
	}
	
		
}

