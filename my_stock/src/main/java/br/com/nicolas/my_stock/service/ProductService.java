package br.com.nicolas.my_stock.service;

import br.com.nicolas.my_stock.dto.ProductDTO;
import br.com.nicolas.my_stock.model.Product;
import br.com.nicolas.my_stock.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

    public List<ProductDTO> getAvailableProducts() {
        List<Product> products = repository.findAll();
        return productToDTO(products);
    }

    public ProductDTO getProductById(Long id) {
        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            Product p = product.get();
            return new ProductDTO(p.getId(), p.getName(), p.getDescription(), p.getQuantity(), p.getPrice());
        }
        return null;
    }

    public List<ProductDTO> getProductsByName(String name) {
        List<Product> products = repository.findByNameContainingIgnoreCase(name);
        return productToDTO(products);
    }

    private List<ProductDTO> productToDTO(List<Product> products) {
        return products
                .stream()
                .map(p -> new ProductDTO(p.getId(), p.getName(), p.getDescription(), p.getQuantity(), p.getPrice()))
                .collect(Collectors.toList());
    }
}
