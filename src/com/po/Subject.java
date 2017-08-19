package com.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Subject implements Serializable{
	//subject��course��һ�Զ��ϵ��subject��һ�������ж෽�ļ���
	private int sid;
	private String courseid;
	private String subname;
	private Set<Course> sub_courses=new HashSet<Course>();
	private String tag;
	
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	//User_Subject
	public Set<Course> getSub_courses() {
		return sub_courses;
	}
	public void setSub_courses(Set<Course> sub_courses) {
		this.sub_courses = sub_courses;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getSubname() {
		return subname;
	}
	public void setSubname(String subname) {
		this.subname = subname;
	}
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "sid=" + sid + ", courseid=" + courseid + ", subname=" + subname
				+ ", sub_courses=" + sub_courses + ", tag=" + tag;
	}
	

}
