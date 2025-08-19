package com.gmail.caioa.rediskme.adapters.mapper;

import com.gmail.caioa.rediskme.adapters.persistence.entity.ProductEntity;
import com.gmail.caioa.rediskme.adapters.web.dto.ProductDTO;
import com.gmail.caioa.rediskme.domain.model.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-18T23:37:23-0300",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 24.0.2 (Homebrew)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product mapEntityToDomain(ProductEntity productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.id( map( productEntity.getId() ) );
        product.name( productEntity.getName() );
        product.value( productEntity.getValue() );

        return product.build();
    }

    @Override
    public ProductEntity mapDomainToEntity(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setId( map( product.getId() ) );
        productEntity.setName( product.getName() );
        productEntity.setValue( product.getValue() );

        return productEntity;
    }

    @Override
    public ProductDTO mapDomainToDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO.ProductDTOBuilder productDTO = ProductDTO.builder();

        productDTO.name( product.getName() );
        productDTO.value( product.getValue() );

        return productDTO.build();
    }

    @Override
    public Product mapDTOtoDomain(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.name( productDTO.getName() );
        product.value( productDTO.getValue() );

        return product.build();
    }
}
