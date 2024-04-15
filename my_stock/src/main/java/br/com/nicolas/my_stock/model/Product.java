package br.com.nicolas.my_stock.model;

import br.com.nicolas.my_stock.dto.ProductDto;
import br.com.nicolas.my_stock.dto.ProductUpdateDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "Product")
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
    private Boolean active;
    @ManyToMany(mappedBy = "products")
    private List<Order> orders;

    public Product(ProductDto p) {
        this.name = p.name();
        this.description = p.description();
        this.quantity = p.quantity();
        this.price = p.price();
        this.active = true;
    }

    public void update(ProductUpdateDto data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.description() != null) {
            this.description = data.description();
        }
        if (data.quantity() != null) {
            this.quantity = data.quantity();
        }
        if (data.price() != null) {
            this.price = data.price();
        }
        if (data.active() != null) {
            this.active = data.active();
        }
    }
}
