package com.hejinwei.majiang.dal.helper;

import java.io.Serializable;

public class CheckObject implements Serializable {

	private String SJGSDW = "";
	private String HCNY = "";
	private String HCZRS = "";
	private String YZRS = "";
	private String YZSWZP = "";
	private String HMYZXMBYZS = "";
	private String TQSJ = "";
	private String SHENG = "";
	private String YZL = "";
	private String DF = "";

	public java.lang.String getSJGSDW() {
		return this.SJGSDW;
	}

	public void setSJGSDW(java.lang.String sj) {
		this.SJGSDW = change(sj);
	}

	public java.lang.String getHCNY() {
		return this.HCNY;
	}

	public void setHCNY(java.lang.String hc) {
		this.HCNY = change(hc);
	}

	public java.lang.String getHCZRS() {
		return this.HCZRS;
	}

	public void setHCZRS(java.lang.String zrs) {
		this.HCZRS = change(zrs);
	}

	public java.lang.String getYZRS() {
		return this.YZRS;
	}

	public void setYZRS(java.lang.String yz) {
		this.YZRS = change(yz);
	}

	public java.lang.String getYZSWZP() {
		return this.YZSWZP;
	}

	public void setYZSWZP(java.lang.String wzp) {
		this.YZSWZP = change(wzp);
	}

	public java.lang.String getHMYZXMBYZS() {
		return this.HMYZXMBYZS;
	}

	public void setHMYZXMBYZS(java.lang.String hmxm) {
		this.HMYZXMBYZS = change(hmxm);
	}

	public java.lang.String getTQSJ() {
		return this.TQSJ;
	}

	public void setTQSJ(java.lang.String tq) {
		this.TQSJ = change(tq);
	}

	public java.lang.String getSHENG() {
		return this.SHENG;
	}

	public void setSHENG(java.lang.String sh) {
		this.SHENG = change(sh);
	}

	public java.lang.String getYZL() {
		return this.YZL;
	}

	public void setYZL(java.lang.String yzl) {
		this.YZL = change(yzl);
	}

	public java.lang.String getDF() {
		return this.DF;
	}

	public void setDF(java.lang.String df) {
		this.DF = change(df);
	}

	/**
	 */
	private String change(String s) {
		if (s == null) {
			return "";
		} else {
			return s;
		}
	}
}
