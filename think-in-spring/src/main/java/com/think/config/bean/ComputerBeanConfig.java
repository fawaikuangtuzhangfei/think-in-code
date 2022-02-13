package com.think.config.bean;

import com.think.entity.Computer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ConditionalOnMissingBean 不存在则注入
 * @author Java男朋友
 * @date 2022-02-13 10:16
 */
@Configuration
public class ComputerBeanConfig {


    @Bean(name = "notebookPC")
    public Computer computer1() {
        return new Computer("笔记本电脑");
    }

    @ConditionalOnMissingBean(Computer.class)
    @Bean("reservePC")
    public Computer computer2() {
        return new Computer("备用电脑");

    }
}
