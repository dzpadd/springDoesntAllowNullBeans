package com.dpadd;

import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public CardNumberProvider cardNumberProvider() {
        return new CardNumberProvider("5555 5555 5555 4444");
    }

    @Bean
    public MaskingService maskingService(CardNumberProvider cardNumberProvider) {
        return new MaskingService(cardNumberProvider);
    }
}

