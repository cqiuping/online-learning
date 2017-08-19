package com.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable{
	//user和video是多对多关系，拆成两个一对多关系
	private int uid;
	private String username;
	private String password;
	private String pathid; //该用户学习路径，用逗号分隔，下同
	private String courseid;//该用户学的课程
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPathid() {
		return pathid;
	}
	public void setPathid(String pathid) {
		this.pathid = pathid;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "uid=" + uid + ", username=" + username + ", password="
				+ password + ", pathid=" + pathid + ", courseid=" + courseid;
	}
	
}
