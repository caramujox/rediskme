package com.gmail.caioa.rediskme.adapters.persistence;

import com.gmail.caioa.rediskme.adapters.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductEntity, String> {

    // JpaRepository provides methods like findById, save, delete, etc.
    // No additional methods are needed here unless custom queries are required.

}
