package com.rick.desafioanotaai.resources;

import com.rick.desafioanotaai.domain.category.Category;
import com.rick.desafioanotaai.domain.category.CategoryDTO;
import com.rick.desafioanotaai.domain.product.Product;
import com.rick.desafioanotaai.domain.product.ProductDTO;
import com.rick.desafioanotaai.services.CategoryService;
import com.rick.desafioanotaai.services.ProductService;
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
@RequestMapping(value = "/api/product")
public class ProductResource {

    @Autowired
    private ProductService service;

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody ProductDTO productDTO) {
        Product newProduct = service.insert(productDTO);
        return ResponseEntity.ok().body(newProduct);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = service.getAll();
        return ResponseEntity.ok().body(products);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> update(@PathParam("id") String id, @RequestBody ProductDTO productDTO) {
        Product updatedProduct = service.update(id, productDTO);
        return ResponseEntity.ok().body(updatedProduct);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Product> delete(@PathParam("id") String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
