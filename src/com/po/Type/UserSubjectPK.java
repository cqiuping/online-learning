package com.po.Type;

import java.io.Serializable;

public class UserSubjectPK implements Serializable{
	private int uid;
	private int sid;
	
	
	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof UserSubjectPK))
			return false;
			UserSubjectPK uPk=(UserSubjectPK)obj;
		if(uPk.equals(this))
			return true;
		if(uPk.getUid()==uid && uPk.getSid()==sid)
			return true;
		else return false;
	}
	
}
