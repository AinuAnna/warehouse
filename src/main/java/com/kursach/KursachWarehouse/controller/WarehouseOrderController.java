package com.kursach.KursachWarehouse.controller;

import com.kursach.KursachWarehouse.domain.WarehouseOrder;
import com.kursach.KursachWarehouse.domain.enums.WarehouseOrderType;
import com.kursach.KursachWarehouse.repos.WarehouseOrderLineRepository;
import com.kursach.KursachWarehouse.repos.WarehouseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class WarehouseOrderController {
    @Autowired
    private WarehouseOrderRepository WarehouseOrderRepo;

    @Autowired
    private WarehouseOrderLineRepository WarehouseOrderLineRepo;

    @GetMapping("/warehouseOrder")
    public String warehouseOrder(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        if (filter != null && !filter.isEmpty()) {
            model.addAttribute("warehouseOrders", WarehouseOrderRepo.findById(Long.parseLong(filter)));
        } else {
            model.addAttribute("warehouseOrders", WarehouseOrderRepo.findAll());
        }
        model.addAttribute("filter", filter);
        return "warehouseOrder";
    }

    @Transactional
    @GetMapping("/delWarehouseOrder")
    public String delWarehouseOrder(@RequestParam(name = "id", required = false, defaultValue = "0") Long ID) {
        if (WarehouseOrderLineRepo.findByWarehouseOrder_Id(ID) == null) {
            WarehouseOrderRepo.deleteById(ID);

        }
        return "redirect:/warehouseOrder";
    }

    @GetMapping("/addWarehouseOrder")
    public String addWarehouseOrder(Map<String, Object> model) {
        model.put("tableName", "Складские заказы");
        model.put("message", "Впишите данные");
        model.put("action", "/addWarehouseOrder");
        model.put("crudName", "Добавить");
        model.put("OrderTypeR", WarehouseOrderType.RECEIPT);
        model.put("OrderTypeS", WarehouseOrderType.SHIPMENT);
        model.put("OrderTypeM", WarehouseOrderType.MOVING);
        return "warehouseOrderChange";
    }

    @PostMapping("/addWarehouseOrder")
    public String addWarehouseOrder(WarehouseOrder order, Map<String, Object> model) {
        WarehouseOrderRepo.save(order);
        return "redirect:/warehouseOrder";
    }
}
