package com.hejinwei.majiang.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hejinwei.majiang.biz.api.DemoManager;
import com.hejinwei.majiang.common.log.enums.DemoCodeEnum;
import com.hejinwei.majiang.dal.api.DemoClient;
import com.hejinwei.majiang.dal.mybatis.mapper.SmsTemplateMapper;
import com.hejinwei.majiang.dal.mybatis.model.SmsTemplate;
import com.hejinwei.majiang.dal.mybatis.model.SmsTemplateExample;

@Service
public class DemoManagerImpl implements DemoManager {
	@Resource
	private SmsTemplateMapper smsTemplateMapper;
	
	@Resource
	DemoClient demoClient; 

	public String hello(String name, String word) throws Exception {
		
		SmsTemplate smsTemplate = smsTemplateMapper.selectByPrimaryKey("amque_call_reminder");
		if(null == smsTemplate){
			//throw new BusinessValidateException(DemoCodeEnum.TEMPLATE_NOT_EXSIT.getCode(), "");
		}
		System.out.println("--------------smsTemplate1:" + smsTemplate.getContent());
		
		
		SmsTemplateExample example = new SmsTemplateExample();
		example.createCriteria().andDescriptionLike("%取消%").andTemplateIdEqualTo("amque_cancel_staging");
		List<SmsTemplate> smsTemplateList = smsTemplateMapper.selectByExample(example);
		System.out.println("--------------smsTemplate2:" + smsTemplateList.get(0).getContent());
		
		
		
		String msg = demoClient.hello(name, word);
		//一般是接口解析报文异常或返回状态码无法识别等
//		if(xxx){
//			throw new BusinessValidateException(majiangCodeEnum.CODE_CANNOT_IDENTIFY.getCode(), "");
//		}
		
		return msg;
	}
	
}
