package com.rick.desafioanotaai.resources;

import com.rick.desafioanotaai.domain.category.Category;
import com.rick.desafioanotaai.domain.category.CategoryDTO;
import com.rick.desafioanotaai.services.CategoryService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody CategoryDTO categoryDTO) {
        Category newCategory = service.insert(categoryDTO);
        return ResponseEntity.ok().body(newCategory);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categories = service.getAll();
        return ResponseEntity.ok().body(categories);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Category> update(@PathParam("id") String id, @RequestBody CategoryDTO categoryDTO) {
        Category updatedCategory = service.update(id, categoryDTO);
        return ResponseEntity.ok().body(updatedCategory);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Category> delete(@PathParam("id") String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
