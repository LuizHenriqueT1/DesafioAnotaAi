package com.rick.desafioanotaai.repositories;

import com.rick.desafioanotaai.domain.category.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends MongoRepository<Category, String> {


}
