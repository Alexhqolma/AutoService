package com.example.autoservice.service.impl;

import com.example.autoservice.model.Order;
import com.example.autoservice.model.Owner;
import com.example.autoservice.repository.OwnerRepository;
import com.example.autoservice.service.OwnerService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner update(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public List<Order> findAllOrdersById(Long id) {
        return findById(id).getOrders();
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find owner by id " + id));
    }
}
