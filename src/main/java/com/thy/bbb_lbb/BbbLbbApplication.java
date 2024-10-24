package com.thy.bbb_lbb;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class BbbLbbApplication {
    private final static Logger logger = LoggerFactory.getLogger(com.thy.bbb_lbb.BbbLbbApplication.class.getName());

    public static void main(String[] args) {
        final var app = SpringApplication.run(com.thy.bbb_lbb.BbbLbbApplication.class, args);
        final var beanCount = app.getBeanDefinitionCount();
        logger.info("=====================================================================");
        logger.info("启动完成，载入{}个bean", beanCount);
        logger.info("=====================================================================");
    }

}
