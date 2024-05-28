package com.kursach.KursachWarehouse.repos;

import com.kursach.KursachWarehouse.domain.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface WarehouseOrderLineRepository extends CrudRepository<WarehouseOrderLine,Long> {
    List<WarehouseOrderLine> findWarehouseOrderLineByWarehouseOrder_Id(Long tag);
    WarehouseOrderLine findByWarehouseOrder_Id(Long tag);
    List<WarehouseOrderLine> findByUser_Id(Long tag);
    Optional<WarehouseOrderLine> findById(Long tag);
    void deleteById(Long tag);
}