package com.example.start.testing.product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private CurrencyConvertor currencyConvertor;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void shouldBeeOddWhenNumberIsEvenThenNotThrowException() {
        int number = 2;
        assertDoesNotThrow(() -> productService.shouldBeeOdd(number));
    }

    @Test
    void shouldBeeOddWhenNumberIsOddThenThrowException() {
        int number = 3;
        assertThrows(ProductException.class, () -> productService.shouldBeeOdd(number));
    }
}