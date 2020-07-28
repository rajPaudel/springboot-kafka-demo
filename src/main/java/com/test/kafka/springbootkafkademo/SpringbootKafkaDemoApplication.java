package com.test.kafka.springbootkafkademo;

import com.test.kafka.springbootkafkademo.service.AlphaConsumer;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@SpringBootApplication
public class SpringbootKafkaDemoApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext appContext = SpringApplication.run(SpringbootKafkaDemoApplication.class, args);
        AlphaConsumer alphaConsumer= (AlphaConsumer) appContext.getBean(AlphaConsumer.class);
        alphaConsumer.testReplyingListener();
    }

}
