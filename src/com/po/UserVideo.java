package com.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.po.Type.UserCoursePK;
import com.po.Type.UserVideoPK;

public class UserVideo implements Serializable{
	private UserVideoPK pk;
	private int look;
	public UserVideoPK getPk() {
		return pk;
	}
	public void setPk(UserVideoPK pk) {
		this.pk = pk;
	}
	public int getLook() {
		return look;
	}
	public void setLook(int look) {
		this.look = look;
	}
	
	
}

