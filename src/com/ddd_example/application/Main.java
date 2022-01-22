package com.ddd_example.application;

import com.ddd_example.domain.*;
import com.ddd_example.domain.service.CheckoutService;
import com.ddd_example.domain.service.DiscountService;
import com.ddd_example.application.service.CompetitorPriceProvider;
import com.ddd_example.application.service.StaticValueCompetitorPriceProvider;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Product ipad = new Product("Ipad Pro", new Price(BigDecimal.TEN));
        Product pen = new Product("Hero Ink Pen", new Price(BigDecimal.TEN));

        CompetitorPriceProvider competitorPriceProvider = new StaticValueCompetitorPriceProvider();
        BigDecimal gmCricketBatPrice = competitorPriceProvider.getCompetitorPrice("GM Cricket bat");
        Price discountedPrice = DiscountService.discountedPrice(gmCricketBatPrice);
        Product bat = new Product("GM Cricket bat", discountedPrice);

        CartItem ipadItem = new CartItem(ipad);
        CartItem penItem = new CartItem(pen);
        CartItem batItem = new CartItem(bat, 2);

        Cart cart = new Cart();
        cart.addToCart(ipadItem, penItem, batItem);

        cart.summary();

        cart.removeFromCart(ipadItem);

        cart.removedItemsSummary();

        CheckoutService checkoutService = new CheckoutService();
        Order order = checkoutService.checkoutAndOrder(cart);

        order.summary();
        System.out.println(cart.isCheckedOut());
    }
}
