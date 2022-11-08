package com.example.start.testing.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private final CurrencyConvertor currencyConvertor;

    public ProductServiceImpl(CurrencyConvertor currencyConvertor) {
        this.currencyConvertor = currencyConvertor;
    }

    @Override
    public int getPriceInCurrency(Product product, String currency) {
        if (currency.equals(product.getCurrency())) {
            return product.getPrice();
        }
        // return product.getPrice() / 30;
        return currencyConvertor.convert(product.getCurrency(), currency, product.getPrice());
    }

    public void shouldBeeOdd(int number) {
        if (number % 2 != 0) {
            throw new ProductException();
        }
    }
}
