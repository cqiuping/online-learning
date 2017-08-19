package com.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Teacher implements Serializable{
	//��ʦ��course��һ�Զ࣬teacher��һ��,һ�����ж෽������
	//��ʦ��Video��һ�Զ࣬һ�����ж෽video������
	private int tid;
	private String tname;
	private String tdesc;
	private float tscore;
	private Set<Course> tea_courses=new HashSet<Course>();
	private Set<Video> tea_videos=new HashSet<Video>();
	
	public Set<Course> getTea_courses() {
		return tea_courses;
	}
	public void setTea_courses(Set<Course> tea_courses) {
		this.tea_courses = tea_courses;
	}
	public Set<Video> getTea_videos() {
		return tea_videos;
	}
	public void setTea_videos(Set<Video> tea_videos) {
		this.tea_videos = tea_videos;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTdesc() {
		return tdesc;
	}
	public void setTdesc(String tdesc) {
		this.tdesc = tdesc;
	}
	public float getTscore() {
		return tscore;
	}
	public void setTscore(float tscore) {
		this.tscore = tscore;
	}
	public Set<Course> getCourses() {
		return tea_courses;
	}
	public void setCourses(Set<Course> tea_courses) {
		this.tea_courses = tea_courses;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
}
