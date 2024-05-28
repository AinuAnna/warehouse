package com.kursach.KursachWarehouse.repos;

import com.kursach.KursachWarehouse.domain.Cell;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CellRepository extends CrudRepository<Cell, Long> {
    List<Cell> findByWeightGreaterThanEqual(Double tag);

    Optional<Cell> findById(Long tag);

    List<Cell> findByWarehouse_Id(Long tag);

    void deleteById(Long tag);
}