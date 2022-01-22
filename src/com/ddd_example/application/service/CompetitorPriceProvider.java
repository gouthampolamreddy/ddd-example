package com.ddd_example.application.service;

import java.math.BigDecimal;

public interface CompetitorPriceProvider {
    BigDecimal getCompetitorPrice(String productName);
}
