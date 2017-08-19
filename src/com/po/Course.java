package com.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Course implements Serializable{
	//course和video是一对多关系，一方持有多方的引用
	private int cid;
	private String cname;
	private float couscore;
	private int num;
	private int tid;
	private String coudesc;
	private  String couvideo;
	private Integer sid;
	private Set<Video> cou_videos=new HashSet<Video>();
	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Set<Video> getCou_videos() {
		return cou_videos;
	}
	public void setCou_videos(Set<Video> cou_videos) {
		this.cou_videos = cou_videos;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public float getCouscore() {
		return couscore;
	}
	public void setCouscore(float couscore) {
		this.couscore = couscore;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getCoudesc() {
		return coudesc;
	}
	public void setCoudesc(String coudesc) {
		this.coudesc = coudesc;
	}
	public String getCouvideo() {
		return couvideo;
	}
	public void setCouvideo(String couvideo) {
		this.couvideo = couvideo;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
}
