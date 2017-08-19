package com.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.po.Type.UserCoursePK;
import com.po.Type.UserSubjectPK;

public class UserSubject implements Serializable {
	private UserSubjectPK pk;
	private int look;
	public UserSubjectPK getPk() {
		return pk;
	}
	public void setPk(UserSubjectPK pk) {
		this.pk = pk;
	}
	public int getLook() {
		return look;
	}
	public void setLook(int look) {
		this.look = look;
	}
	
}
