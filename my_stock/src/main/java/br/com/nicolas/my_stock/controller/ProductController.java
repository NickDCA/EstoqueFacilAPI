package br.com.nicolas.my_stock.controller;

import br.com.nicolas.my_stock.dto.ProductDto;
import br.com.nicolas.my_stock.dto.ProductUpdateDto;
import br.com.nicolas.my_stock.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService service;

    @PostMapping
    @Transactional
    public void createProduct(@RequestBody ProductDto data) {
        service.createProduct(data);
    }

    @GetMapping
    public Page<ProductDto> getProducts(@PageableDefault(sort = {"name"}) Pageable pageable) {
        return service.getProducts(pageable);
    }

    @PutMapping(value = "/{id}", consumes = {"application/json"})
    @Transactional
    public String updateProduct(@PathVariable Long id, @RequestBody ProductUpdateDto data) {
        service.updateProduct(id, data);
        return "Deu certo";
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deactivateProduct(@PathVariable Long id) {
        service.deactivateProduct(id);
    }

    @GetMapping("/teste")
    public String teste() {
        return "Olá mundo";
    }

}
