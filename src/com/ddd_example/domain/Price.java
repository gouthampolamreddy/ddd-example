package com.ddd_example.domain;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

public class Price {
    BigDecimal value;
    Currency currency = Currency.getInstance("USD");

    public Price(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return value.equals(price.value) && currency.equals(price.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                ", currency=" + currency +
                '}';
    }
}
