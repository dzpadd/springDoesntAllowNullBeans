package com.dpadd;

import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public CardNumberProvider exampleDependency() {
        return new CardNumberProvider("5555 5555 5555 4444");
    }

    @Bean
    public MaskingService exampleService(CardNumberProvider cardNumberProvider) {
        return new MaskingService(cardNumberProvider);
    }
}

