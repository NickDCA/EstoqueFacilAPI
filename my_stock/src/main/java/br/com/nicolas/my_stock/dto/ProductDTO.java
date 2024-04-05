package br.com.nicolas.my_stock.dto;

public record ProductDTO(
        Long id,
        String name,
        String description,
        Integer quantity,
        Double price) {
}
