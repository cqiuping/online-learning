package com.po;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Video implements Serializable {
	//user��video�Ƕ�Զ��ϵ����ΪҪ���м�����ֶΣ����Բ���������һ��ϵ
	private int  vid;
	private String vname;
	private int cid;
	private int tid;
	private String url;
	private String tag;
	private int base;
	
	
	public int getBase() {
		return base;
	}
	public void setBase(int base) {
		this.base = base;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	private Set<User> vid_users=new HashSet<User>();
	
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Set<User> getVid_users() {
		return vid_users;
	}
	public void setVid_users(Set<User> vid_users) {
		this.vid_users = vid_users;
	}
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}
}
