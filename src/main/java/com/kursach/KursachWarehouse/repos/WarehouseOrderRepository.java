package com.kursach.KursachWarehouse.repos;

import com.kursach.KursachWarehouse.domain.WarehouseOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface WarehouseOrderRepository extends CrudRepository<WarehouseOrder,Long> {
    Optional<WarehouseOrder> findById(Long tag);
    WarehouseOrder findAllById(Long tag);
    void deleteById(Long tag);
}