package com.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.po.Type.UserCoursePK;
import com.po.Type.UserSubjectPK;
import com.po.Type.UserTeacherPK;;

public class UserTeacher implements Serializable {
	private UserTeacherPK pk;
	private int score;
	public UserTeacherPK getPk() {
		return pk;
	}
	public void setPk(UserTeacherPK pk) {
		this.pk = pk;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
