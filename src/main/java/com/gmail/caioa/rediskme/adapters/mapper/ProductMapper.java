package com.gmail.caioa.rediskme.adapters.mapper;



import com.gmail.caioa.rediskme.adapters.persistence.entity.ProductEntity;
import com.gmail.caioa.rediskme.domain.model.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ProductMapper {

     Product toDomain(Optional<ProductEntity> productEntity);
     ProductEntity toEntity(Product product);
}
