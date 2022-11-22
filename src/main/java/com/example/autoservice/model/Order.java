package com.example.autoservice.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Car car;
    private String problemDescription;
    private LocalDate startDate;
    @OneToMany
    private List<ServiceForCar> services;
    @OneToMany
    private List<Product> products;
    @Enumerated(EnumType.STRING)
    private Status status;
    private double price;
    private LocalDate finishDate;
}
