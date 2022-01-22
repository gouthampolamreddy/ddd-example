package com.ddd_example.domain;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

class CartTest {
    @Test
    public void twoCartsShouldBeDifferent() {
        Product ipad = new Product("Ipad Pro", new Price(BigDecimal.TEN));
        Product pen = new Product("Hero Ink Pen", new Price(BigDecimal.TEN));
        Product bat = new Product("GM Cricket bat", new Price(BigDecimal.ONE));

        CartItem ipadItem = new CartItem(ipad);
        CartItem penItem = new CartItem(pen);
        CartItem batItem = new CartItem(bat, 2);

        Cart cart = new Cart();
        cart.addToCart(ipadItem, penItem, batItem);

        Cart secondCart = new Cart();
        secondCart.addToCart(ipadItem, penItem, batItem);

        Assert.assertNotEquals(cart, secondCart);
    }
}