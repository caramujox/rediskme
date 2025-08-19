package com.gmail.caioa.rediskme.adapters.mapper;



import com.gmail.caioa.rediskme.adapters.persistence.entity.ProductEntity;
import com.gmail.caioa.rediskme.adapters.web.dto.ProductDTO;
import com.gmail.caioa.rediskme.domain.model.Product;
import org.mapstruct.Mapper;

import java.util.Optional;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface ProductMapper {

     Product mapEntityToDomain(ProductEntity productEntity);
     ProductEntity mapDomainToEntity(Product product);
     ProductDTO mapDomainToDto(Product product);
     Product mapDTOtoDomain(ProductDTO productDTO);

     default String map(UUID value){
          return value.toString();
     }

     default UUID map(String value){
          return value == null ? null : UUID.fromString(value);
     }
}
