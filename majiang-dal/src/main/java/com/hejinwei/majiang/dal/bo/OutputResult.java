package com.hejinwei.majiang.dal.bo;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("ROWS")
public class OutputResult {

	@XStreamImplicit
	private List<OutputRows> rows;

	public OutputResult() {

	}

	public OutputResult(List<OutputRows> rows) {
		this.rows = rows;
	}

	public List<OutputRows> getRows() {
		return rows;
	}

	public void setRows(List<OutputRows> rows) {
		this.rows = rows;
	}

}
