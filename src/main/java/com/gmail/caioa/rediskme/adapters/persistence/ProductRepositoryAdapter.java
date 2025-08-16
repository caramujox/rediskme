package com.gmail.caioa.rediskme.adapters.persistence;

import com.gmail.caioa.rediskme.adapters.mapper.ProductMapper;
import com.gmail.caioa.rediskme.domain.model.Product;
import com.gmail.caioa.rediskme.domain.port.ProductRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private ProductJpaRepository productJpaRepository;
    private final ProductMapper productMapper;

    @Override
    public Product createProduct(Product product) {
        var productEntity = productMapper.toEntity(product);
        productJpaRepository.save(productEntity);
        return product;
    }

    @Override
    public Product findById(String id) {
        return productMapper.toDomain(productJpaRepository.findById(id));
    }

    @Override
    public Product updateProduct(Product product) {
        var inputEntity = productMapper.toEntity(product);
        var savedEntity = productJpaRepository.save(inputEntity);
        return productMapper.toDomain(Optional.of(savedEntity));
    }

    @Override
    public void deleteById(String id) {
        productJpaRepository.deleteById(id);
    }
}
