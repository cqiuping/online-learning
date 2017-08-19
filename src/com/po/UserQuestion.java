package com.po;

import com.po.Type.UserQuestionPK;

public class UserQuestion {
	private UserQuestionPK pk;
	private float TOrF;
	public UserQuestionPK getPk() {
		return pk;
	}
	public void setPk(UserQuestionPK pk) {
		this.pk = pk;
	}
	public float getTOrF() {
		return TOrF;
	}
	public void setTOrF(float tOrF) {
		TOrF = tOrF;
	}

}
