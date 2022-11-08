package com.example.start.testing.product;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class) // @Mock and @InjectMocks annotation - option 1
public class ProductServiceImplJunit4Test {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Mock
    private CurrencyConvertor currencyConvertor;

    @InjectMocks
    private ProductServiceImpl productService;

    @Before // use Mockito.mock() and manually create service trough constructor - option 2
    public void before() {
        currencyConvertor = mock(CurrencyConvertor.class);
        productService = new ProductServiceImpl(currencyConvertor);
    }

    @Test
    public void getPriceIfTheSameCurrency() {
        Product product = new Product();
        product.setName("Mars");
        product.setPrice(100);
        product.setCurrency("UAH");

        int price = productService.getPriceInCurrency(product, product.getCurrency());

        assertEquals(product.getPrice(), price);
    }

    @Test
    public void getPriceIfOtherCurrency() {
        String requestedCurrency = "USD";
        Product product = new Product();
        product.setName("Mars");
        product.setPrice(120);
        product.setCurrency("UAH");
        when(currencyConvertor.convert(product.getCurrency(), requestedCurrency, product.getPrice())).thenReturn(4);

        int price = productService.getPriceInCurrency(product, requestedCurrency);

        assertEquals(4, price);
        verify(currencyConvertor).convert(product.getCurrency(), requestedCurrency, product.getPrice());
    }

    @Test(expected = ProductException.class)
    public void throwsException() {
        productService.shouldBeeOdd(3);
    }

    public void throwsException2() {
        exceptionRule.expect(ProductException.class);
        productService.shouldBeeOdd(3);
    }

}