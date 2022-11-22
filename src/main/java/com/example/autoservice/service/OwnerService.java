package com.example.autoservice.service;

import java.util.List;
import com.example.autoservice.model.Order;
import com.example.autoservice.model.Owner;

public interface OwnerService {
    Owner save(Owner owner);

    Owner update(Owner owner);

    List<Order> findAllOrdersById(Long ownerId);

    Owner findById(Long id);
}
