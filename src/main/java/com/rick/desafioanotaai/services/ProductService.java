package com.rick.desafioanotaai.services;

import com.rick.desafioanotaai.domain.category.Category;
import com.rick.desafioanotaai.domain.category.CategoryDTO;
import com.rick.desafioanotaai.domain.category.exceptions.CategoryNotFoundException;
import com.rick.desafioanotaai.domain.product.Product;
import com.rick.desafioanotaai.domain.product.ProductDTO;
import com.rick.desafioanotaai.domain.product.exceptions.ProductNotFoundException;
import com.rick.desafioanotaai.repositories.CategoriesRepository;
import com.rick.desafioanotaai.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepositories repository;

    @Autowired
    private CategoryService categoryService;

    public Product insert(ProductDTO productDTO) {
        Category category = categoryService.findById(productDTO.categoryId()).orElseThrow(CategoryNotFoundException::new);
        Product newProduct = new Product(productDTO, category);

        return repository.save(newProduct);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product update(String id, ProductDTO productDTO) {
        Product product = repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        categoryService.findById(productDTO.categoryId()).ifPresent(product::setCategory);

        return repository.save(product);
    }

    public void delete(String id) {
        Product product = repository.findById(id)
                .orElseThrow(ProductNotFoundException::new);
        repository.delete(product);
    }
}
