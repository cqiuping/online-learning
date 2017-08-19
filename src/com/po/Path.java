package com.po;

public class Path {
	private int pid;
	private String pname;
	private String pathsub;
	private String pathdesc;
	public String getPathdesc() {
		return pathdesc;
	}
	public void setPathdesc(String pathdesc) {
		this.pathdesc = pathdesc;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPathsub() {
		return pathsub;
	}
	public void setPathsub(String pathsub) {
		this.pathsub = pathsub;
	}
	public Path(String pname, String pathsub) {
		super();
		this.pname = pname;
		this.pathsub = pathsub;
	}
	public Path() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "pid=" + pid + ", pname=" + pname + ", pathsub=" + pathsub+",pathdesc"+pathdesc;
	}
}
