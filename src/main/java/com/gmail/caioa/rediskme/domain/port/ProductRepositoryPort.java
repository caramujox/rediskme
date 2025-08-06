package com.gmail.caioa.rediskme.domain.port;

import com.gmail.caioa.rediskme.domain.model.Product;

public interface ProductRepositoryPort {
    Product createProduct(Product product);
    Product findById(String id);
    Product updateProduct(Product product);
    void deleteById(String id);

}
