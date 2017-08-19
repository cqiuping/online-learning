package com.po.Type;

import java.io.Serializable;

public class UserCoursePK implements Serializable{
	private int uid;
	private int cid;
	
	
	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof UserCoursePK))
			return false;
			UserCoursePK uPk=(UserCoursePK)obj;
		if(uPk.equals(this))
			return true;
		if(uPk.getUid()==uid && uPk.getCid()==cid)
			return true;
		else return false;
	}
	
}
