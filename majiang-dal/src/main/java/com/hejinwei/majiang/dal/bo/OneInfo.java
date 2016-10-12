package com.hejinwei.majiang.dal.bo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ITEM")
public class OneInfo {

	// 身份证
	@XStreamAlias("gmsfhm")
	private String gmsfhm;

	@XStreamAlias("result_gmsfhm")
	private String result_gmsfhm;

	// 姓名
	@XStreamAlias("xm")
	private String xm;

	@XStreamAlias("result_xm")
	private String result_xm;

	// 相片
	@XStreamAlias("xp")
	private String xp;

	@XStreamAlias("result_xp")
	private String result_xp;

	// 这另两个属性大家都有
	@XStreamAlias("result_fx")
	private String result_fx;

	@XStreamAlias("result_fs")
	private String result_fs;

	// 错误消息提示
	@XStreamAlias("errormesage")
	private String errormesage;

	@XStreamAlias("errormesagecol")
	private String errormesagecol;

	public OneInfo() {

	}

	public String getGmsfhm() {
		return gmsfhm;
	}

	public void setGmsfhm(String gmsfhm) {
		this.gmsfhm = gmsfhm;
	}

	public String getResult_gmsfhm() {
		return result_gmsfhm;
	}

	public void setResult_gmsfhm(String result_gmsfhm) {
		this.result_gmsfhm = result_gmsfhm;
	}

	public String getResult_fx() {
		return result_fx;
	}

	public void setResult_fx(String result_fx) {
		this.result_fx = result_fx;
	}

	public String getResult_fs() {
		return result_fs;
	}

	public void setResult_fs(String result_fs) {
		this.result_fs = result_fs;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getResult_xm() {
		return result_xm;
	}

	public void setResult_xm(String result_xm) {
		this.result_xm = result_xm;
	}

	public String getXp() {
		return xp;
	}

	public void setXp(String xp) {
		this.xp = xp;
	}

	public String getResult_xp() {
		return result_xp;
	}

	public void setResult_xp(String result_xp) {
		this.result_xp = result_xp;
	}

	public String getErrormesage() {
		return errormesage;
	}

	public void setErrormesage(String errormesage) {
		this.errormesage = errormesage;
	}

	public String getErrormesagecol() {
		return errormesagecol;
	}

	public void setErrormesagecol(String errormesagecol) {
		this.errormesagecol = errormesagecol;
	}

}
