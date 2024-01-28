package com.rick.desafioanotaai.services;

import com.rick.desafioanotaai.domain.category.Category;
import com.rick.desafioanotaai.domain.category.CategoryDTO;
import com.rick.desafioanotaai.domain.category.exceptions.CategoryNotFoundException;
import com.rick.desafioanotaai.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoriesRepository repository;

    public Category insert(CategoryDTO categoryDTO) {
        Category newCategory = new Category(categoryDTO);
        repository.save(newCategory);
        return  newCategory;
    }

    public Optional<Category> findById(String id) {
        return repository.findById(id);
    }

    public List<Category> getAll() {
        return repository.findAll();
    }

    public Category update(String id, CategoryDTO categoryDTO) {
        Category category = repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        return repository.save(category);
    }

    public void delete(String id) {
        Category category = repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
        repository.delete(category);
    }
}
