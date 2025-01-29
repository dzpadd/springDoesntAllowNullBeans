package com.dpadd;

import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
class MaskingService {

    private static final String SPACE = " ";
    private static final String MASKED_4_DIGITS = "****";

    private final CardNumberProvider cardNumberProvider;

    public String getMaskedCardNumber() {
        String[] splits = cardNumberProvider.getValue().split(" ");
        return IntStream.range(0, splits.length)
                .mapToObj(i -> maskSplit(i, splits))
                .collect(Collectors.joining(SPACE));
    }

    private String maskSplit(int i, String[] splits) {
        return isLastIndex(splits, i) ? splits[i] : MASKED_4_DIGITS;
    }

    private boolean isLastIndex(String[] array, int index) {
        return index == array.length - 1;
    }
}
