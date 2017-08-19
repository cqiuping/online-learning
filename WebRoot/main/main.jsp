<%@ page language="java" import="java.util.*,com.po.User" contentType="text/html; charset=utf-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
  response.sendRedirect("allCourses.jsp");
%>      