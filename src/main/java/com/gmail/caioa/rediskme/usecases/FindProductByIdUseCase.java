package com.gmail.caioa.rediskme.usecases;

import com.gmail.caioa.rediskme.domain.model.Product;
import com.gmail.caioa.rediskme.domain.port.ProductRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindProductByIdUseCase {

    private ProductRepositoryPort productRepository;

    public Product execute(String id) throws InterruptedException {
        Thread.sleep(3000);
        return productRepository.findById(id);
    }
}
