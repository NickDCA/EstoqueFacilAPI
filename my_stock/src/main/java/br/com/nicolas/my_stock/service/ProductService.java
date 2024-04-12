package br.com.nicolas.my_stock.service;

import br.com.nicolas.my_stock.dto.ProductDto;
import br.com.nicolas.my_stock.dto.ProductUpdateDto;
import br.com.nicolas.my_stock.model.Product;
import br.com.nicolas.my_stock.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;


    public void createProduct(ProductDto data) {
        repository.save(new Product(data));
    }

    public Page<ProductDto> getProducts(Pageable pageable) {
        return repository.findAll(pageable).map(ProductDto::new);
    }

    public void updateProduct(Long id, ProductUpdateDto data) {
        Product product = repository.getReferenceById(id);
        product.update(data);

    }

    public void deactivateProduct(Long id) {
        Product product = repository.getReferenceById(id);
        product.setActive(false);
    }

    private List<ProductDto> productToDTO(List<Product> products) {
        return products
                .stream()
                .map(p -> new ProductDto(
                        p.getId(),
                        p.getName(),
                        p.getDescription(),
                        p.getQuantity(),
                        p.getPrice(),
                        p.getActive())
                )
                .collect(Collectors.toList());
    }



}
