package com.hejinwei.majiang.common.log.enums;

import java.util.ArrayList;
import java.util.List;


public enum FaceLogicCodeEnum {
	//格式校验错误码，只有一个
	SUCCESS("0","调用成功"),
		
	//格式校验错误码，只有一个
	PATTARN_ERROR("10011001","参数格式校验失败"),
	
	//业务校验错误码，有0..n个
	TEMPLATE_NOT_EXSIT("10012001","短信模板不存在"),		//每个业务校验失败一个码，例如下一个为10012002
	
	//业务处理错误码，有0..n个
	RESULT_IS_NULL("10013001","外部返回结果为空"),	//每一个业务处理异常一个码，例如下一个为10013002
	
	//配置错误码，有0..n个
	MOCKURL_CONFIG_ERROR("10014001","mock接口调用地址配置错误"),	//每一个业务处理异常一个码，例如下一个为10014002
	
	//系统异常码，只有一个
	SYSTEM_ERROR("10010001","系统异常");
	
	/** 枚举值 */
	private final String	code;
	
	/** 枚举描述 */
	private final String	message;
	
	/**
	 * 构造一个<code>DomainResultCodeEnum</code>枚举对象
	 *
	 * @param code
	 * @param message
	 */
	private FaceLogicCodeEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String code() {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String message() {
		return message;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 *
	 * @param code
	 * @return DomainResultCodeEnum
	 */
	public static FaceLogicCodeEnum getByCode(String code) {
		for (FaceLogicCodeEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<DomainResultCodeEnum>
	 */
	public List<FaceLogicCodeEnum> getAllEnum() {
		List<FaceLogicCodeEnum> list = new ArrayList<FaceLogicCodeEnum>();
		for (FaceLogicCodeEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}
	
	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public List<String> getAllEnumCode() {
		List<String> list = new ArrayList<String>();
		for (FaceLogicCodeEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
}

