package com.rick.desafioanotaai.repositories;

import com.rick.desafioanotaai.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositories extends MongoRepository<Product, String> {
}
