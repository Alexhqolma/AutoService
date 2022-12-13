package com.example.autoservice.service.impl;

import com.example.autoservice.model.Master;
import com.example.autoservice.model.Order;
import com.example.autoservice.model.Status;
import com.example.autoservice.repository.MasterRepository;
import com.example.autoservice.service.MasterService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService {
    private static final double SALARY_PERCENT = 0.4;
    private final MasterRepository masterRepository;

    public MasterServiceImpl(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    public Master save(Master master) {
        return masterRepository.save(master);
    }

    public Master update(Master master) {
        return masterRepository.save(master);
    }

    @Override
    public List<Order> findReadyOrder(Long id) {
        return findById(id).getReadyOrders();
    }

    @Override
    public double getSalary(Long masterId) {
        List<Order> orders = masterRepository.findReadyOrder(masterId);
        double result = 0.0;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getStatus() != Status.PAID) {
                result += result + orders.get(i).getPrice().doubleValue();
                orders.get(i).setStatus(Status.PAID);
            }
        }
        return result * SALARY_PERCENT;
    }

    @Override
    public Master findById(Long id) {
        return masterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find master by id " + id));
    }
}
