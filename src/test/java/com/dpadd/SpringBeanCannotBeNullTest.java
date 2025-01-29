package com.dpadd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import static org.junit.jupiter.api.Assertions.*;

public class SpringBeanCannotBeNullTest {

    @Test
    void testThatDeclaringBeanAsNullThrowsException() {
        // when
        var exception = assertThrows(
                UnsatisfiedDependencyException.class,
                () -> {
                    try (var context = new AnnotationConfigApplicationContext(AppConfig.class, AppConfigWithNullBean.class)) {
                        context.getBean(MaskingService.class);
                    }
                });
        // then
        var cause = exception.getCause();
        assertInstanceOf(NoSuchBeanDefinitionException.class, cause);
        assertTrue(cause.getMessage().contains("No qualifying bean of type 'com.dpadd.CardNumberProvider'"));
    }

    @Configuration
    static class AppConfigWithNullBean {

        @Bean
        @Primary
        public CardNumberProvider cardNumberProvider() {
            return null;
        }
    }
}
