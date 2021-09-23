package com.think.common.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author yc
 * @description 使用ClassLoader加载properties配置文件生成对应的输入流
 * @date 2021-09-18 15:59
 */
public class ReadPropertiesByClassLoader {

    public static String getStrFromProperties(String fileName, String key) throws IOException {
        Properties properties = new Properties();
        // 使用ClassLoader加载properties配置文件生成对应的输入流
        InputStreamReader in = new InputStreamReader(ReadPropertiesByClassLoader.class.getClassLoader().getResourceAsStream(fileName), "UTF-8");
        // 使用properties对象加载输入流
        properties.load(in);
        //获取key对应的value值
        return properties.getProperty(key);
    }
}
