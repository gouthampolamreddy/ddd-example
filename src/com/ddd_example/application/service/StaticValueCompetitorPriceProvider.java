package com.ddd_example.application.service;

import java.math.BigDecimal;
import java.util.Map;

public class StaticValueCompetitorPriceProvider implements CompetitorPriceProvider {

    private static final Map<String, BigDecimal> competitorPriceMap = Map.of("GM Cricket bat", BigDecimal.ONE);

    @Override
    public BigDecimal getCompetitorPrice(String productName) {
        return competitorPriceMap.get(productName);
    }
}
