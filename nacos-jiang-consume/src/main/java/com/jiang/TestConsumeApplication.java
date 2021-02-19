package com.jiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class TestConsumeApplication {

    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>>>>>>>>>>启动(消费者)");
        ConfigurableApplicationContext applicationContext = SpringApplication.run(TestConsumeApplication.class, args);
        String userName = applicationContext.getEnvironment().getProperty("user.name");
        String userAge = applicationContext.getEnvironment().getProperty("user.age");
        System.err.println("user name :" +userName+"; age: "+userAge);
        System.out.println(">>>>>>>>>>>>>>>>>完成(消费者)");
    }
}
