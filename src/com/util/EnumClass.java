package com.util;

public class EnumClass {
	public enum Look{
		NEVER("0"),DOING("1"),EVER("1");
		private Look(String num)
		{
			this.num=num;
		}
		private String num;
		public String getNum() {
			return num;
		}
		public void setNum(String num) {
			this.num = num;
		}
	}

}
