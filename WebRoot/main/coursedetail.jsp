<%@ page language="java" import="java.util.*,com.po.*,com.dao.*"
	contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>course</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">




<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<meta name="renderer" content="webkit">
<meta property="qc:admins" content="77103107776157736375" />
<meta property="wb:webmaster" content="c4f857219bfae3cb" />
<meta http-equiv="Access-Control-Allow-Origin" content="*" />
<meta http-equiv="Cache-Control" content="no-transform " />

<meta name="Keywords" content="" />

<meta name="description"
	content="通过PHP入门视频教程能够了解PHP中的变量、变量的类型、常量等概念、认识PHP中的运算符，掌握PHP中顺序结构、条件结构、循环结构语句，本课程适用于没有任何WEB经验的WEB应用程序开发者及对WEB前端技术兴趣的用户" />







<link rel="stylesheet"
	href="/static/moco/v1.0/dist/css/moco.min.css?t=201703281204"
	type="text/css" />

<script type="text/javascript">

eval(function(p,a,c,k,e,d){e=function(c){return(c<a?"":e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)d[e(c)]=k[c]||e(c);k=[function(e){return d[e]}];e=function(){return'\\w+'};c=1;};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p;}('!4(){3 6=a;3 l=4(){3 b,e=9 y("(^| )"+"c=([^;]*)(;|$)");j(b=h.g.z(e)){k w(b[2])}x{k a}};3 8=4(t){3 f=l();3 7=9 o();7.A(7.d()+B*i*i*r);h.g="c="+t+";s="+7.M()+";N=/;L=O.m";j(t&&t!=f){Q.P.G()}};3 5=9 E();5.H=4(){K(6);6=a;8(0)};5.J=4(){8(1)};6=I(4(){5.n="";8(1)},F);5.n=\'R://p.u.m/p/v/q/D.C?t=\'+9 o().d()}()',54,54,'|||var|function|imgobj|timer|exp|setcookie|new|null|arr|IMCDNS|getTime|reg|_0|cookie|document|60|if|return|getcookie|com|src|Date|static|common|1000|expires||mukewang|img|unescape|else|RegExp|match|setTime|24|png|logo|Image|3000|reload|onload|setTimeout|onerror|clearTimeout|domain|toGMTString|path|imooc|location|window|http'.split('|'),0,{}))

</script>
  <style>
    /* FROM HTTP://WWW.GETBOOTSTRAP.COM
     * Glyphicons
     *
     * Special styles for displaying the icons and their classes in the docs.
     */

    .bs-glyphicons {
      padding-left: 0;
      padding-bottom: 1px;
      margin-bottom: 20px;
      list-style: none;
      overflow: hidden;
    }

    .bs-glyphicons li {
      float: left;
      width: 25%;
      height: 115px;
      padding: 10px;
      margin: 0 -1px -1px 0;
      font-size: 12px;
      line-height: 1.4;
      text-align: center;
      border: 1px solid #ddd;
    }

    .bs-glyphicons .glyphicon {
      margin-top: 5px;
      margin-bottom: 10px;
      font-size: 24px;
    }

    .bs-glyphicons .glyphicon-class {
      display: block;
      text-align: center;
      word-wrap: break-word; /* Help out IE10+ with class names */
    }

    .bs-glyphicons li:hover {
      background-color: rgba(86, 61, 124, .1);
    }

    @media (min-width: 768px) {
      .bs-glyphicons li {
        width: 12.5%;
      }
    }
  </style>


<script type="text/javascript">

var OP_CONFIG={"module":"course","page":"learn","userInfo":{"uid":1977020}};
var isLogin = 1;
var is_choice = "";
var seajsTimestamp="v=201703281204";
var _msg_unread = 0; 
var _not_unread = 0; 
var _cart_num = 0;
</script>








<script>
/*学习页通用配置*/
var GC = {
  course: {
    id: 54,
    name: 'PHP入门篇',
    pic: '',
    video_url: ''
  },
  classmates: 20 // 你的同学一页显示数量
};


</script>
<script>

var hasLearn;
    var learnChapter = 862;
    hasLearn = 1;

</script>




<link rel="stylesheet"
	href="http://static.mukewang.com/static/css/??base.css,common/common-less.css?t=2.5,course/common-less.css,course/view-less.css,course/learn-less.css,u/dynamic/home-less.css?v=201703281204"
	type="text/css" />






<!-- Bootstrap 3.3.6 -->
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="../dist/css/skins/_all-skins.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
<body class="hold-transition skin-blue layout-top-nav">
	<div class="wrapper">
		<% 
        	User user=(User)session.getAttribute("userLogin");
        	
        %>

		<header class="main-header">
			<nav class="navbar navbar-static-top">
				<div class="container">
					<div class="navbar-header">
						<a href="../main/main.html" class="navbar-brand"><b>OPLearning</a>
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar-collapse">
							<i class="fa fa-bars"></i>
						</button>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse pull-left"
						id="navbar-collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">Link <span
									class="sr-only">(current)</span></a></li>
							<li><a href="#">Link</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Dropdown <span class="caret"></span></a>
								<ul class="dropdown-menu" role="menu">
									<li><a href="#">Action</a></li>
									<li><a href="#">Another action</a></li>
									<li><a href="#">Something else here</a></li>
									<li class="divider"></li>
									<li><a href="#">Separated link</a></li>
									<li class="divider"></li>
									<li><a href="#">One more separated link</a></li>
								</ul></li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
					<!-- Navbar Right Menu -->
					<div class="navbar-custom-menu">
						<ul class="nav navbar-nav">
							<!-- Messages: style can be found in dropdown.less-->
							<li class="dropdown messages-menu">
								<!-- Menu toggle button --> <a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="fa fa-envelope-o"></i> <span
									class="label label-success">4</span>
							</a>
								<ul class="dropdown-menu">
									<li class="header">You have 4 messages</li>
									<li>
										<!-- inner menu: contains the messages -->
										<ul class="menu">
											<li>
												<!-- start message --> <a href="#">
													<div class="pull-left">
														<!-- User Image -->
														<img src="../dist/img/user2-160x160.jpg"
															class="img-circle" alt="User Image">
													</div> <!-- Message title and timestamp -->
													<h4>
														Support Team <small><i class="fa fa-clock-o"></i>
															5 mins</small>
													</h4> <!-- The message -->
													<p>Why not buy a new awesome theme?</p>
											</a>
											</li>
											<!-- end message -->
										</ul> <!-- /.menu -->
									</li>
									<li class="footer"><a href="#">See All Messages</a></li>
								</ul>
							</li>
							<!-- /.messages-menu -->

							<!-- Notifications Menu -->
							<li class="dropdown notifications-menu">
								<!-- Menu toggle button --> <a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="fa fa-bell-o"></i> <span
									class="label label-warning">10</span>
							</a>
								<ul class="dropdown-menu">
									<li class="header">You have 10 notifications</li>
									<li>
										<!-- Inner Menu: contains the notifications -->
										<ul class="menu">
											<li>
												<!-- start notification --> <a href="#"> <i
													class="fa fa-users text-aqua"></i> 5 new members joined
													today
											</a>
											</li>
											<!-- end notification -->
										</ul>
									</li>
									<li class="footer"><a href="#">View all</a></li>
								</ul>
							</li>
							<!-- Tasks Menu -->
							<li class="dropdown tasks-menu">
								<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <i class="fa fa-flag-o"></i> <span
									class="label label-danger">9</span>
							</a>
								<ul class="dropdown-menu">
									<li class="header">You have 9 tasks</li>
									<li>
										<!-- Inner menu: contains the tasks -->
										<ul class="menu">
											<li>
												<!-- Task item --> <a href="#"> <!-- Task title and progress text -->
													<h3>
														Design some buttons <small class="pull-right">20%</small>
													</h3> <!-- The progress bar -->
													<div class="progress xs">
														<!-- Change the css width attribute to simulate progress -->
														<div class="progress-bar progress-bar-aqua"
															style="width: 20%" role="progressbar" aria-valuenow="20"
															aria-valuemin="0" aria-valuemax="100">
															<span class="sr-only">20% Complete</span>
														</div>
													</div>
											</a>
											</li>
											<!-- end task item -->
										</ul>
									</li>
									<li class="footer"><a href="#">View all tasks</a></li>
								</ul>
							</li>
							<!-- User Account Menu -->
							<li class="dropdown user user-menu">
								<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> <!-- The user image in the navbar-->
									<img src="../dist/img/user2-160x160.jpg" class="user-image"
									alt="User Image"> <!-- hidden-xs hides the username on small devices so only the image appears. -->
									<span class="hidden-xs">
										<%out.print(user!=null?user.getUsername():"");%>
								</span>
							</a>
								<ul class="dropdown-menu">
									<!-- The user image in the menu -->
									<li class="user-header"><img
										src="../dist/img/user2-160x160.jpg" class="img-circle"
										alt="User Image">

										<p>
											<%out.print(user!=null?user.getUsername():"");%>- Web Developer
											<small>Member since Nov. 2012</small>
										</p></li>
									<!-- Menu Body -->
									<li class="user-body">
										<div class="row">
											<div class="col-xs-4 text-center">
												<a href="#">Followers</a>
											</div>
											<div class="col-xs-4 text-center">
												<a href="#">Sales</a>
											</div>
											<div class="col-xs-4 text-center">
												<a href="#">Friends</a>
											</div>
										</div> <!-- /.row -->
									</li>
									<!-- Menu Footer-->
									<li class="user-footer">
										<div class="pull-left">
											<a href="#" class="btn btn-default btn-flat">Profile</a>
										</div>
										<div class="pull-right">
											<a href="../servlet/SignOutServlet"
												class="btn btn-default btn-flat">Sign out</a>
										</div>
									</li>
								</ul>
							</li>
						</ul>
					</div>
					<!-- /.navbar-custom-menu -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		</header>
		<!-- Full Width Column -->
		<div class="content-wrapper">
			<div class="container">

				<%
					int cid=(Integer)request.getAttribute("cid");
					CourseDao cdao=new CourseDao();
					SubjectDao sdao=new SubjectDao();
					Course course=cdao.getCourseByCid(cid);
						if(course!=null)
						{
						
				%>
				<section class="content-header">
					<h1>
						<%=course.getCname()%>
						<%
			}
        %>
						<small><%=course.getNum() %>人在学习|评分(<%=course.getCouscore() %>)</small>
					</h1>
					<ol class="breadcrumb">
						<li><a href="../main/main.jsp"><i class="fa fa-dashboard"></i>
								Home</a></li>
					</ol>
				</section>
				<section class="content">
					<div class="box box-primary"></div>

					<div class="course-brief">
						<p class="auto-wrap">
							简介:<%=course.getCoudesc() %></p>
					</div>
					<div>
						对于这门课，您想要达到的学习程度:&nbsp;&nbsp;&nbsp; <label><input
							name="degree" type="radio" value="known" onclick="work()"/><span
							class="text-red">了解</span> </label> &nbsp;&nbsp;&nbsp;<label><input
							name="degree" type="radio" value="familiar" onclick="work()"/><span
							class="text-red">熟悉</span> </label> &nbsp;&nbsp;&nbsp;<label><input
							name="degree" type="radio" value="master" onclick="work()" /><span
							class="text-red">精通</span> </label>
					</div>

					<div class="mod-chapters">
					<div class="chapter chapter-active">
				<%
					VideoDao vdao=new VideoDao();
					UserVideoDao uvdao=new UserVideoDao();
					UserVideo userVideo=null;
					String couvideo=course.getCouvideo();
					//所有章
					String chapters[]=vdao.splitVideoName(couvideo, "\\|");
					//每一章具有的videoss
					String[] videoids=null;
					Video video=null;
					if(chapters!=null)
					{
						for(int i=0;i<chapters.length;i++)
						{
							videoids=vdao.splitVideoName(chapters[i], "\\,");
							
				%>


							<!-- 章节标题 -->
							<h3>

								<span class="icon-drop_down js-close"></span> <strong>
									<i class="icon-chapter"></i> 第<%=i+1 %>章 <%=videoids[0] %>
									<div class="icon-info chapter-info">
									</div>
								</strong>

							</h3>
							<!-- 章节小节 -->
							<ul class="video">
							<!-- 章节标题 end -->
							
							<%
								for(int j=1;j<videoids.length;j++)
								{
									video=vdao.getVideoByVid(Integer.parseInt(videoids[j]));
									userVideo=uvdao.getUserVideoByPK(user.getUid(), video.getVid());
									if(userVideo!=null)
									{
										if(userVideo.getLook()==1)
										{
											
							%>
							
								<li data-media-id="856" class="base<%=video.getBase() %>" style="display: block"><a href='../servlet/VideoDeatilServlet?vid=<%=video.getVid()%>&look=1 '
									class="J-media-item"> <i class="icon-code type"></i> <%=i+1 %>-<%=j %>
										<%=video.getVname() %> <i class="fa fa-fw fa-circle-o text-green"  ></i>


								</a> <!-- 未登录时 --> <!-- <a target="_blank" href="/video/1430" class="J-media-item studyvideo">1-1 Java简介 (05:49)
                                <button class="r moco-btn moco-btn-blue preview-btn">预览</button>
                            </a> --></li>
                            <%			}
										else if(userVideo.getLook()==2)
										{
											
									 %>
									 <li data-media-id="856" class="base<%=video.getBase() %>" style="display: block"><a href='../servlet/VideoDeatilServlet?vid=<%=video.getVid()%>&look=1 '
									class="J-media-item"> <i class="icon-code type"></i> <%=i+1 %>-<%=j %>
										<%=video.getVname() %> <i class="fa fa-fw fa-check-circle text-green"></i>


								</a> <!-- 未登录时 --> <!-- <a target="_blank" href="/video/1430" class="J-media-item studyvideo">1-1 Java简介 (05:49)
                                <button class="r moco-btn moco-btn-blue preview-btn">预览</button>
                            </a> --></li>
                            	
								<%
									} 
								}
									else
									{
										
								%>
								 <li data-media-id="856" class="base<%=video.getBase() %>" style="display: block"><a href='../servlet/VideoDeatilServlet?vid=<%=video.getVid()%>&look=1 '
									class="J-media-item"> <i class="icon-code type"></i> <%=i+1 %>-<%=j %>
										<%=video.getVname() %>

								</a> <!-- 未登录时 --> <!-- <a target="_blank" href="/video/1430" class="J-media-item studyvideo">1-1 Java简介 (05:49)
                                <button class="r moco-btn moco-btn-blue preview-btn">预览</button>
                            </a> --></li>
								
							
							<%
										}
									
									}
							%>
							</ul>
							<%
									}
								} 
							%>
							<!-- 章节小节 end -->
							
							<h3>

								<span class="icon-drop_down js-close"></span> <strong>
									<i class="icon-chapter"></i> 课程测试
									<div class="icon-info chapter-info">
									</div>
								</strong>
	
							</h3>
							
							
							 <li data-media-id="856"><a href='../main/question.jsp?cid=<%=course.getCid() %> '
									class="J-media-item"> <i class="icon-code type"></i> 
									测试入口

								</a> <!-- 未登录时 --> <!-- <a target="_blank" href="/video/1430" class="J-media-item studyvideo">1-1 Java简介 (05:49)
                                <button class="r moco-btn moco-btn-blue preview-btn">预览</button>
                            </a> --></li>
							
						</div>
						<script language="javascript">
						//点击提交按钮触发下面的函数  
						function work() {
							var name="degree";
							var degree=$("input[name="+name+"]:checked").val();
							var base0=document.getElementsByClassName("base0");
							var base2=document.getElementsByClassName("base2");
							if(degree=="known")
							{
								
								for(var i=0;i<base0.length;i++)
								{
									base0[i].style.display="none";
								}	
								for(var j=0;j<base2.length;j++)
								{
									base2[j].style.display="none";
								}
							}
							else if(degree=="familiar")
							{
								for(var j=0;j<base2.length;j++)
								{
									base2[j].style.display="none";
								}
								for(var i=0;i<base0.length;i++)
								{
									base0[i].style.display="block";
								}
							}
							else if(degree=="master")
							{
								for(var j=0;j<base2.length;j++)
								{
									base2[j].style.display="block";
								}
								for(var i=0;i<base0.length;i++)
								{
									base0[i].style.display="block";
								}
							}
						}
					</script>



					</div>
					<!-- /.container -->
			</div>
			<!-- /.content-wrapper -->
			<footer class="main-footer">
				<div class="container">
					<div class="pull-right hidden-xs">
						<b>Version</b> 2.3.8
					</div>
					<strong>Copyright &copy; 2014-2016 <a
						href="http://almsaeedstudio.com">Almsaeed Studio</a>.
					</strong> All rights reserved.
				</div>
				<!-- /.container -->
			</footer>
		</div>
		<!-- ./wrapper -->

		<!-- jQuery 2.2.3 -->
		<script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
		<!-- Bootstrap 3.3.6 -->
		<script src="../bootstrap/js/bootstrap.min.js"></script>
		<!-- SlimScroll -->
		<script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
		<!-- FastClick -->
		<script src="../plugins/fastclick/fastclick.js"></script>
		<!-- AdminLTE App -->
		<script src="../dist/js/app.min.js"></script>
		<!-- AdminLTE for demo purposes -->
		<script src="../dist/js/demo.js"></script>

		<!--script-->
		<script src="/passport/static/scripts/ssologin.js?v=2.0"></script>
		<script type="text/javascript"
			src="/static/sea-modules/seajs/seajs/2.1.1/sea.js"></script>
		<script type="text/javascript" src="/static/sea_config.js?v="></script>
		<script type="text/javascript">seajs.use("/static/page/"+OP_CONFIG.module+"/"+OP_CONFIG.page);</script>
		


		<script type="text/javascript">
  (function(){
    var imgPic = GC.course.pic || 'http://img.mukewang.com/static/img/common/logo.png',
        text = '我正在参加@慕课网  的一门课程【' + GC.course.name + '】，很不错哦！快来一起学习吧！', //节名称
        url = 'http://www.imooc.com' + window.location.pathname;

    window._bd_share_config = {
        "common": {
            "bdUrl": url,
            "bdSnsKey": {
              'tsina':'2254855082'
            },
            "bdText": text,
            "bdMini": "2",
            "bdMiniList": false,
            "bdPic": imgPic,
            "bdStyle": "0",
            "bdSize": "16"
        },
        "share": {}
    };
    setTimeout(function(){
            with(document) 0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion=' + ~(-new Date() / 36e5)];
        },1000)

  })();
</script>
		<div class="mask"></div>


		<div style="display: none">
			<script type="text/javascript">
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Ff0cfcccd7b1393990c78efdeebff3968' type='text/javascript'%3E%3C/script%3E"));
(function (d) {
window.bd_cpro_rtid="rHT4P1c";
var s = d.createElement("script");s.type = "text/javascript";s.async = true;s.src = location.protocol + "//cpro.baidu.com/cpro/ui/rt.js";
var s0 = d.getElementsByTagName("script")[0];s0.parentNode.insertBefore(s, s0);
})(document);
</script>
			<script>
(function(){
    var bp = document.createElement('script');
    bp.src = '//push.zhanzhang.baidu.com/push.js';
    var s = document.getElementsByTagName("script")[0];
    s.parentNode.insertBefore(bp, s);
})();
</script>
</body>
</html>
