package br.com.nicolas.my_stock.dto;

import br.com.nicolas.my_stock.model.Product;

public record ProductDto(
        Long id,
        String name,
        String description,
        Integer quantity,
        Double price,
        Boolean active) {
    public ProductDto(Product p) {
        this(p.getId(), p.getName(), p.getDescription(), p.getQuantity(), p.getPrice(), p.getActive());
    }
}
