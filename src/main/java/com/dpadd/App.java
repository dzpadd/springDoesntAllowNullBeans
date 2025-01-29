package com.dpadd;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            var maskedCardNumberProvider = context.getBean(MaskingService.class);
            var maskedCardNumber = maskedCardNumberProvider.getMaskedCardNumber();
            System.out.println(maskedCardNumber);
        }
    }
}
