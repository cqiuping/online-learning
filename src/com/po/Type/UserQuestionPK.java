package com.po.Type;

import java.io.Serializable;

public class UserQuestionPK implements Serializable{
	private int uid;
	private int qid;
	
	
	public int getUid() {
		return uid;
	}


	public void setUid(int uid) {
		this.uid = uid;
	}


	public int getQid() {
		return qid;
	}


	public void setQid(int qid) {
		this.qid = qid;
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof UserQuestionPK))
			return false;
			UserQuestionPK uPk=(UserQuestionPK)obj;
		if(uPk.equals(this))
			return true;
		if(uPk.getUid()==uid && uPk.getQid()==qid)
			return true;
		else return false;
	}
	
}
