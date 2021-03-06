package com.sunny;

import com.alibaba.fastjson.JSON;
import com.sunny.controller.ConstantController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * springboot 项目启动类
 *
 * @author Mr Zhao
 * @date 2018/4/16
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableTransactionManagement
@EnableScheduling
@ImportResource({"classpath:spring-dubbo-*.xml"})
@ComponentScan("com.sunny")
public class App {

    private static Logger logger = LoggerFactory.getLogger(App.class);

    @Value("${zookeeper.address}")
    private String zkConnectString;

    public static void main(String[] args){
        SpringApplication.run(App.class,args);
        logger.info("测试静态加载={}", JSON.toJSONString(ConstantController.map));
        logger.info("sunny project start success!");
    }
}
