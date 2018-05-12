package com.examtime.constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.project.examtime.framework.utils.StringUtils;

public enum EnvProperties {

	IMAGE_PATH("imagePath");

	public String value;

	private static final Properties properties = loadProperties();

	EnvProperties(String value) {
		this.value = value;
	}

	public static String findProperty(EnvProperties key) {
		return properties.getProperty(key.value);
	}

	private static Properties loadProperties() {
		InputStream is = null;
		Properties property = new Properties();
		String env = System.getProperty("environment");
		String envConfig = System.getProperty("configPath");
		try {
			if (!StringUtils.isEmpty(env) || "Development".equals(env)) {
				property.load(EnvProperties.class.getClassLoader()
						.getResourceAsStream("com\\deliverando\\logistics\\envConfig.properties"));
			} else {
				StringBuilder filePath = new StringBuilder(envConfig);
				filePath.append("envConfig.properties");
				File configFile = new File(filePath.toString());
				is = new FileInputStream(configFile);
				property.load(is);
			}
		} catch (Exception th) {

		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {

				}
			}
		}
		return property;
	}

}
