package com.think.conditional;

import com.think.config.bean.PersonBeanConfig;
import com.think.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @author Java男朋友
 * @date 2022-02-09 21:48
 */
@SpringBootTest
public class PersonConditionalTest  {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersonBeanConfig.class);

    @Test
    public void testBeanConditional(){
        Map<String, Person> map = applicationContext.getBeansOfType(Person.class);
        System.out.println(map);
    }
}
