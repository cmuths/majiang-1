package com.hejinwei.majiang.dal.bo;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("ROW")
public class OutputRows {
	
	@XStreamAlias("INPUT")
	private OutputInput input;
	
	@XStreamAlias("OUTPUT")
	private OutputInfo info;
	
	public OutputRows() {
		
	}

	public OutputInput getInput() {
		return input;
	}

	public void setInput(OutputInput input) {
		this.input = input;
	}

	public OutputInfo getInfo() {
		return info;
	}

	public void setInfo(OutputInfo info) {
		this.info = info;
	}

}
