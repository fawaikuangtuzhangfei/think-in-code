package com.think.ConditionalOnMissingBean;

import com.think.config.bean.ComputerBeanConfig;
import com.think.entity.Computer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * @author Java男朋友
 * @date 2022-02-13 10:18
 */
@SpringBootTest
public class ComputerConditionalOnMissingBeanTest {

    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComputerBeanConfig.class);

    @Test
    public void testBeanConditional(){
        Map<String, Computer> map = applicationContext.getBeansOfType(Computer.class);
        System.out.println(map);
    }

}
