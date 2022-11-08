package com.example.start.testing.examples;

import com.example.start.testing.product.Product;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    @Disabled
    void stringCheck() {
        String myString = "test string";
        assertThat(myString).isEqualTo("expected");
    }

    @Test
    void collectionCheck() {
        List<String> list = Arrays.asList("one", "two");
        assertThat(list).hasSize(2);
        assertThat(list).contains("one", "two");
    }

    @Test
    void objectCheck() {
        Product product = getProduct();

        assertThat(product).usingRecursiveComparison()
                .isEqualTo(getProduct());
    }

    Product getProduct() {
        Product product = new Product();
        product.setName("Mars");
        product.setPrice(100);
        return product;
    }

}
