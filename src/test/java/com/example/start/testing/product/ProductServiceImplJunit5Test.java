package com.example.start.testing.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // @Mock and @InjectMocks annotation - option 1
class ProductServiceImplJunit5Test {

    @Mock
    CurrencyConvertor currencyConvertor;
    @Captor
    ArgumentCaptor<String> captor;

    @InjectMocks
    ProductServiceImpl productService;

    @BeforeEach // use Mockito.mock() and manually create service trough constructor - option 2
    void before() {
        currencyConvertor = mock(CurrencyConvertor.class);
        productService = new ProductServiceImpl(currencyConvertor);
    }

    @Test
    void getPriceIfTheSameCurrency() {
        Product product = new Product();
        product.setName("Mars");
        product.setPrice(100);
        product.setCurrency("UAH");

        int price = productService.getPriceInCurrency(product, product.getCurrency());

        assertEquals(product.getPrice(), price);
    }

    @Test
    void getPriceIfOtherCurrency() {
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

    @Test
    void captorExample() {
        String requestedCurrency = "USD";
        Product product = new Product();
        product.setName("Mars");
        product.setPrice(120);
        product.setCurrency("UAH");
        when(currencyConvertor.convert(product.getCurrency(), requestedCurrency, product.getPrice())).thenReturn(4);

        int price = productService.getPriceInCurrency(product, requestedCurrency);

        assertEquals(4, price);
        verify(currencyConvertor).convert(captor.capture(), eq(requestedCurrency), eq(product.getPrice()));
        assertEquals(product.getCurrency(), captor.getValue());
    }

    @Test
    void throwsException() {
        ProductException exception = assertThrows(ProductException.class,
                () -> productService.shouldBeeOdd(3));

        assertNull(exception.getMessage());
    }

}