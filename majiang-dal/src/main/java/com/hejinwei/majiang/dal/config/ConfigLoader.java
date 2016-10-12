package com.hejinwei.majiang.dal.config;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ConfigLoader {
	private static final Logger logger = LoggerFactory.getLogger(ConfigLoader.class);

	@PostConstruct
	public void init() {
		ConfigMapper configMapper = ConfigMapper.getInstance();
		Map<String, String> map = configMapper.getConfigMap();
		logger.debug("load config......");

		fillPropertiesConfig(map);
	}

	private void fillPropertiesConfig(Map<String, String> map) {
//		String profiles = System.getProperty("spring.profiles.active", "dev");
//		String fileName = "config/config-" + profiles + ".properties";
//		Map<String, String> propertiesMap = PropertiesUtil.getPropMap(fileName);
//		map.putAll(propertiesMap);
	}

}