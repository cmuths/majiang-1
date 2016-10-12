package com.hejinwei.majiang.dal.bo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("INPUT")
public class OutputInput {

	@XStreamAlias("gmsfhm")
	private String gmsfhm;

	@XStreamAlias("xm")
	private String xm;

	public OutputInput() {
		// TODO Auto-generated constructor stub
	}

	public OutputInput(String gmsfhm, String xm) {
		super();
		this.gmsfhm = gmsfhm;
		this.xm = xm;
	}

	public String getGmsfhm() {
		return gmsfhm;
	}

	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

}
