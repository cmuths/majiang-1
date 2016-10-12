package com.hejinwei.majiang.dal.bo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("INFO")
public class Info {

	@XStreamAlias("SBM")
	private String sbm;

	public Info() {

	}

	public Info(String sbm) {
		super();
		this.sbm = sbm;
	}

	public String getSbm() {
		return sbm;
	}

	public void setSbm(String sbm) {
		this.sbm = sbm;
	}
}
