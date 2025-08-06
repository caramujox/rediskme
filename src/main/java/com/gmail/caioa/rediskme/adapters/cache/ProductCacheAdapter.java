package com.gmail.caioa.rediskme.adapters.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.caioa.rediskme.domain.model.Product;
import com.gmail.caioa.rediskme.domain.port.ProductRepositoryPort;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;


import java.time.Duration;

@Component
@Primary
public class ProductCacheAdapter implements ProductRepositoryPort {

    private StringRedisTemplate redisTemplate;
    private ObjectMapper objectMapper;
    @Qualifier("productRepositoryAdapter") ProductRepositoryPort fallbackRepository;

    public ProductCacheAdapter(
            StringRedisTemplate redisTemplate,
            ObjectMapper objectMapper,
            @Qualifier("productRepositoryAdapter") ProductRepositoryPort fallbackRepository
    ){
        this.redisTemplate = redisTemplate;
        this.objectMapper = objectMapper;
        this.fallbackRepository = fallbackRepository;
    }


    @Override
    public Product createProduct(Product product) {
        String productId = product.getId();
        String redisKey = String.format("product:%s", productId);
        System.out.println(redisKey);

        Product savedProduct = fallbackRepository.createProduct(product);
        try {
            redisTemplate.opsForValue().set(
                    redisKey,
                    objectMapper.writeValueAsString(savedProduct),
                    Duration.ofSeconds(60)
            );
        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        return savedProduct;
    }

    @Override
    public Product findById(String id) {
        String redisKey = String.format("product:%s", id);
        System.out.println(redisKey);

        String cachedProduct = redisTemplate.opsForValue().get(redisKey);
        try {
            if (cachedProduct != null) {
                return objectMapper.readValue(cachedProduct, Product.class);
            }

            Product product = fallbackRepository.findById(id);
            redisTemplate.opsForValue().set(
                    redisKey,
                    objectMapper.writeValueAsString(product),
                    Duration.ofSeconds(60)
            );

            return product;
        } catch (JsonProcessingException ex) {
            System.out.println(ex.getMessage());
            return fallbackRepository.findById(id);
        }
    }

    @Override
    public Product updateProduct(Product product) {
        String redisKey = String.format("product:%s", product.getId());
        System.out.println(redisKey);

        try{
            Product savedProduct = fallbackRepository.updateProduct(product);
            redisTemplate.opsForValue().set(
                    redisKey,
                    objectMapper.writeValueAsString(savedProduct),
                    Duration.ofSeconds(60)
            );

            return savedProduct;
        }
        catch(JsonProcessingException ex){
            System.out.println(ex.getMessage());
            return new Product();
        }
    }

    @Override
    public void deleteById(String id) {
        String redisKey = String.format("product:$s", id);
        System.out.println(redisKey);

        fallbackRepository.deleteById(id);
        redisTemplate.delete(redisKey);
    }
}
