package com.gmail.caioa.rediskme.adapters.mapper;

import com.gmail.caioa.rediskme.adapters.persistence.entity.ProductEntity;
import com.gmail.caioa.rediskme.domain.model.Product;
import java.util.Optional;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T00:53:06-0300",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 24.0.2 (Homebrew)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toDomain(Optional<ProductEntity> productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        Product product = new Product();

        return product;
    }

    @Override
    public ProductEntity toEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        return productEntity;
    }
}
