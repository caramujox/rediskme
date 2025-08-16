package com.gmail.caioa.rediskme.usecases;

import com.gmail.caioa.rediskme.domain.model.Product;
import com.gmail.caioa.rediskme.domain.port.ProductRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateProductUseCase {

    private ProductRepositoryPort productRepositoryPort;

    public Product execute(Product product){
        return productRepositoryPort.createProduct(product);
    }
}
