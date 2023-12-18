package com.example.crudwithmultipledatabase.postgres;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "postgreMultiple")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name ;
    private  String description;
    private Integer price;
}
