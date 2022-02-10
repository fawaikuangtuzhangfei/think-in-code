package com.think.config;

import com.think.condition.WindowsCondition;
import com.think.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author Java男朋友
 * @date 2022-02-09 21:46
 */
@Configuration
public class PersonBeanConfig {

    @Conditional({WindowsCondition.class})
    @Bean(name = "bill")
    public Person person1() {
        return new Person("Bill Gates", 62);
    }

    @Bean("linus")
    public Person person2() {
        return new Person("Linus", 48);
    }
}
