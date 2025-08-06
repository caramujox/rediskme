package com.gmail.caioa.rediskme.adapters.web;

import com.gmail.caioa.rediskme.domain.model.Product;
import com.gmail.caioa.rediskme.usecases.CreateProductUseCase;
import com.gmail.caioa.rediskme.usecases.DeleteProductUseCase;
import com.gmail.caioa.rediskme.usecases.FindProductByIdUseCase;
import com.gmail.caioa.rediskme.usecases.UpdateProductUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/products")
public class ProductController {

    private CreateProductUseCase createProductUseCase;
    private DeleteProductUseCase deleteProductUseCase;
    private UpdateProductUseCase updateProductUseCase;
    private FindProductByIdUseCase findProductByIdUseCase;

    @GetMapping(name = "/{productId}")
    public Product getProductById(@PathVariable("productId") String productId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(Product product){
        return ResponseEntity.ok(createProductUseCase.execute(product));
    }

    @PutMapping("/{productId}")
    public Product updateProductById(@PathVariable("productId") String productId){
        return null;
    }

    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable("productId") String productId){

    }
}
