package com.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable{
	//user��video�Ƕ�Զ��ϵ���������һ�Զ��ϵ
	private int uid;
	private String username;
	private String password;
	private String pathid; //���û�ѧϰ·�����ö��ŷָ�����ͬ
	private String courseid;//���û�ѧ�Ŀγ�
	
	
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
