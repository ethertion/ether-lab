package com.ethertion.lab.webapp;

import java.util.Arrays;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author amiguel
 */
@SpringBootApplication
@ComponentScan("com.ethertion.lab")
@EnableCaching
@EnableAutoConfiguration
@EnableJpaRepositories("com.ethertion.lab.repository")
@EntityScan(basePackageClasses=com.ethertion.lab.domain.Book.class)
public class Application {

    private static final Logger logger = Logger.getLogger(Application.class);

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        logger.trace ("Let's inspect the beans provided by Spring Boot:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            logger.trace (beanName);
        }

    }

}