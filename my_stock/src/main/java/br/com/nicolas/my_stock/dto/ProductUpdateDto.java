package br.com.nicolas.my_stock.dto;

import jakarta.validation.constraints.NotNull;

public record ProductUpdateDto(
        @NotNull
        Long id,
        String name,
        String description,
        Integer quantity,
        Double price,
        Boolean active
) {
}
