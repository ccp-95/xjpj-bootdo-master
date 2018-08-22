package com.zztlj.xjpj.utils;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.bootdo.common.utils.BDException;

public class ConfigUtil {

	/**
     * 获取配置信息
     */
    public static Configuration getConfig() {
        try {
            return new PropertiesConfiguration("application.properties");
        } catch (ConfigurationException e) {
            throw new BDException("获取配置文件失败，", e);
        }
    }
    
}
