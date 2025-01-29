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
}
