
/**
 * 包名：com.hejinwei.otter.dal.config
 * 文件名：ConfigMapper.java
 * 版本信息：
 * 日期：2014年9月2日-上午11:26:54
 * 
 */
 
package com.hejinwei.majiang.dal.config;

import java.util.HashMap;
import java.util.Map;


 /**
 * 
 * 类名称：ConfigMapper
 * 类描述：
 * 创建人：liugang
 * 修改时间：2014年9月2日 上午11:26:54
 * 修改备注：
 * @version 1.0.0
 * 
 */

public class ConfigMapper {
	
	private static ConfigMapper configMapper;
	
	private Map<String,String> configMap = new HashMap<String,String>();
	
	private ConfigMapper(){}
	
	public static synchronized ConfigMapper getInstance(){
		if(null==configMapper){
			configMapper = new ConfigMapper();
		}
		return configMapper;
	}

	
	/**
	 * configMap
	 *
	 * @return  the configMap
	 * @since   1.0.0
	 */
	
	public Map<String, String> getConfigMap() {
		return configMap;
	}

	 public String get(String value){
		 return configMap.get(value);
	 }

}
