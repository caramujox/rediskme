package com.gmail.caioa.rediskme.adapters.persistence;

import com.gmail.caioa.rediskme.adapters.mapper.ProductMapper;
import com.gmail.caioa.rediskme.adapters.persistence.entity.ProductEntity;
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
        var productEntity = productMapper.mapDomainToEntity(product);
        ProductEntity savedEntity = productJpaRepository.save(productEntity);
        return productMapper.mapEntityToDomain(savedEntity);
    }

    @Override
    public Product findById(String id) {
        ProductEntity productEntity = productJpaRepository.findById(id).orElseThrow(RuntimeException::new);
        return productMapper.mapEntityToDomain(productEntity);
    }

    @Override
    public Product updateProduct(Product product) {
        var inputEntity = productMapper.mapDomainToEntity(product);
        var savedEntity = productJpaRepository.save(inputEntity);
        return productMapper.mapEntityToDomain(savedEntity);
    }

    @Override
    public void deleteById(String id) {
        productJpaRepository.deleteById(id);
    }
}
