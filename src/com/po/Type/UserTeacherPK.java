package com.po.Type;

import java.io.Serializable;

public class UserTeacherPK implements Serializable{
	private int uid;
	private int tid;
	
	
	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	


	public int getTid() {
		return tid;
	}


	public void setTid(int tid) {
		this.tid = tid;
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof UserTeacherPK))
			return false;
			UserTeacherPK uPk=(UserTeacherPK)obj;
		if(uPk.equals(this))
			return true;
		if(uPk.getTid()==uid && uPk.getTid()==tid)
			return true;
		else return false;
	}
	
}
