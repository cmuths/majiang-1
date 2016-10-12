package com.hejinwei.majiang.dal.bo;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("ROWS")
public class PersonInfo {

	@XStreamImplicit
	private List<Info> info;

	@XStreamImplicit
	private List<Row> row;

	public PersonInfo() {
		// TODO Auto-generated constructor stub
	}

	public List<Info> getInfo() {
		return info;
	}

	public void setInfo(List<Info> info) {
		this.info = info;
	}

	public List<Row> getRow() {
		return row;
	}

	public void setRow(List<Row> row) {
		this.row = row;
	}

}
