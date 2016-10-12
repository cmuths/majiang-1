package com.hejinwei.majiang.dal.bo;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("OUTPUT")
public class OutputInfo {

	@XStreamImplicit
	private List<OneInfo> oneInfo;

	public OutputInfo() {

	}

	public List<OneInfo> getOneInfo() {
		return oneInfo;
	}

	public void setOneInfo(List<OneInfo> oneInfo) {
		this.oneInfo = oneInfo;
	}

}