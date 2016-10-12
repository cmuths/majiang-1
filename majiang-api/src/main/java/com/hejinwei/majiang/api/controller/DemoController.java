package com.hejinwei.majiang.api.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.hejinwei.majiang.api.form.DemoForm;
import com.hejinwei.majiang.biz.api.DemoManager;
import com.hejinwei.majiang.common.log.enums.DemoCodeEnum;

@Controller
@RequestMapping("/majiang")
public class DemoController {

	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

	@Resource
	private DemoManager demoManager;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ResponseEntity<String> getSerial(DemoForm majiangForm) {
		return null;
	}

}