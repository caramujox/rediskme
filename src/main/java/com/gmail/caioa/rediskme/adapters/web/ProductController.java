package com.gmail.caioa.rediskme.adapters.web;

import com.gmail.caioa.rediskme.adapters.mapper.ProductMapper;
import com.gmail.caioa.rediskme.adapters.web.dto.ProductDTO;
import com.gmail.caioa.rediskme.domain.model.Product;
import com.gmail.caioa.rediskme.usecases.CreateProductUseCase;
import com.gmail.caioa.rediskme.usecases.DeleteProductUseCase;
import com.gmail.caioa.rediskme.usecases.FindProductByIdUseCase;
import com.gmail.caioa.rediskme.usecases.UpdateProductUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final FindProductByIdUseCase findProductByIdUseCase;
    private final ProductMapper productMapper;

    @GetMapping(name = "/{productId}")
    public Product getProductById(@PathVariable("productId") String productId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO product){
        return ResponseEntity.ok(createProductUseCase.execute(productMapper.mapDTOtoDomain(product)));
    }

    @PutMapping("/{productId}")
    public Product updateProductById(@PathVariable("productId") String productId,
                                     @RequestBody Product newProduct){
        return null;
    }

    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable("productId") String productId){

    }
}
