package br.com.nicolas.my_stock.controller;

import br.com.nicolas.my_stock.dto.ProductDTO;
import br.com.nicolas.my_stock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/available")
    public List<ProductDTO> getAvailableProducts(){
        return service.getAvailableProducts();
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return service.getProductById(id);
    }

    @GetMapping
    public List<ProductDTO> getProductsByName(@RequestParam(required = false) String name){
        return service.getProductsByName(name);
    }
//    @GetMapping("/{name}")
//    public List<ProductDTO> getProductsByName(@PathVariable String name) {
//        return service.getProductsByName(name);
//    }

    @GetMapping("/teste")
    public String teste() {
        return "Olá mundo";
    }

}
