package com.ddd_example.domain.service;

import com.ddd_example.domain.Price;

import java.math.BigDecimal;

public class DiscountService {

    public static Price discountedPrice(BigDecimal competitorPrice) {
        BigDecimal discountPercent = BigDecimal.valueOf(10);
        BigDecimal newValue = competitorPrice.multiply(discountPercent).divide(BigDecimal.valueOf(100));
        return new Price(newValue);
    }
}
