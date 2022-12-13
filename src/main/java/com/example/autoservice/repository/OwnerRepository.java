package com.example.autoservice.repository;

import com.example.autoservice.model.Order;
import com.example.autoservice.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    @Query("select o from Order o join fetch o.car c where c.owner.id = :id")
    List<Order> findAllOrdersById(Long id);
}
