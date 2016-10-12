package com.hejinwei.majiang.api.tomcat;


/** 
* @ClassName: majiang TomcatBootStrap 
* @Description:嵌入式Tomcat
* @author yangjie 
* @date 2015年4月15日18:41:51
*/
public class TomcatBootStrap {
	public static void main(String[] args) {
		new TomcatBootstrapHelper(8998, false, "dev").start();
	}
}