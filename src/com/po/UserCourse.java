package com.po;

import java.io.Serializable;

import com.po.Type.UserCoursePK;

public class UserCourse implements Serializable{
	private UserCoursePK pk;
	private int score;
	private int tid;
	private int user_look_num;
	private int last_look_vid;
	
	public int getLast_look_vid() {
		return last_look_vid;
	}
	public void setLast_look_vid(int last_look_vid) {
		this.last_look_vid = last_look_vid;
	}
	public UserCoursePK getPk() {
		return pk;
	}
	public void setPk(UserCoursePK pk) {
		this.pk = pk;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getUser_look_num() {
		return user_look_num;
	}
	public void setUser_look_num(int user_look_num) {
		this.user_look_num = user_look_num;
	}
	
	
	
}
