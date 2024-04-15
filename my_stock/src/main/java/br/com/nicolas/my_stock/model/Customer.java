package br.com.nicolas.my_stock.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name = "Customer")
@Table(name = "customers")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;

}
