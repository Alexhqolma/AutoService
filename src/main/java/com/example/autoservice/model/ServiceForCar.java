package com.example.autoservice.model;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "services")
public class ServiceForCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Order order;
    @OneToOne
    private Master master;
    private double price;
    @Enumerated(EnumType.STRING)
    private Status status;
}
