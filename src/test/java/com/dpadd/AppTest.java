package com.dpadd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class AppTest {

    @Autowired
    private MaskingService maskingService;

    @Test
    void testMaskedValue() {
        String maskedCardNumber = maskingService.getMaskedCardNumber();
        Assertions.assertEquals("**** **** **** 4444", maskedCardNumber);
    }

//    @Test
//    void testNullCardNumberProvider() {
//        // Test that substituting the CardNumberProvider with null throws an exception
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
//            new MaskedCardNumberProvider(null);
//        });
//        assertEquals("cardNumberProvider is marked non-null but is null", exception.getMessage());
//    }

//    @Configuration
//    static class TestConfig {
//
//        @Bean
//        @Primary
//        public CardNumberProvider cardNumberProvider() {
//            return null;
//        }
//    }
}
