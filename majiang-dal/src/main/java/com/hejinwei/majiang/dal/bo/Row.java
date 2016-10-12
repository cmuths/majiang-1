package com.hejinwei.majiang.dal.bo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("ROW")
public class Row {
	// xml字段
	@XStreamAlias("GMSFHM")
	private String gmsfhm;

	@XStreamAlias("XM")
	private String xm;

	@XStreamAlias("XP")
	private String xp;

	// xml属性
	@XStreamAsAttribute()
	@XStreamAlias("FSD")
	private String fsd;

	@XStreamAsAttribute()
	@XStreamAlias("YWLX")
	private String ywlx;

	public Row() {
		// TODO Auto-generated constructor stub
	}

	public Row(String gmsfhm, String xm, String xp, String fsd, String ywlx) {
		this.gmsfhm = gmsfhm;
		this.xm = xm;
		this.xp = xp;
		this.fsd = fsd;
		this.ywlx = ywlx;
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

	public String getXp() {
		return xp;
	}

	public void setXp(String xp) {
		this.xp = xp;
	}

	public String getFsd() {
		return fsd;
	}

	public void setFsd(String fsd) {
		this.fsd = fsd;
	}

	public String getYwlx() {
		return ywlx;
	}

	public void setYwlx(String ywlx) {
		this.ywlx = ywlx;
	}

}
