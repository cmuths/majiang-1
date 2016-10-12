package com.hejinwei.majiang.dal.config;

import java.io.IOException;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class PropertiesLoader {

	private static final Logger logger = LoggerFactory
			.getLogger(PropertiesLoader.class);
	private static Map<String, String> configMap;
	private static Map<String, String> integrationMap;

	@PostConstruct
	public void init() throws IOException {
		logger.info("load config......");

		String env = System.getProperty("spring.profiles.active");
		String configPath = "config/config-" + env + ".properties";
//		configMap = PropertiesUtil.getMapByClasspath(configPath);

		String integrationPath = "integration/integration-" + env
				+ ".properties";
//		integrationMap = PropertiesUtil.getMapByClasspath(integrationPath);
	}

	public static Map<String, String> getConfigMap() {
		return configMap;
	}

	public static Map<String, String> getIntegrationMap() {
		return integrationMap;
	}
}