package com.magicurology.MagicPotionApi.controller;

import com.magicurology.MagicPotionApi.model.FulfillmentRequest;
import com.magicurology.MagicPotionApi.model.Order;
import com.magicurology.MagicPotionApi.model.OrderResponse;
import com.magicurology.MagicPotionApi.model.OrderCreateResponse;
import com.magicurology.MagicPotionApi.model.OrderCreateRequest;
import com.magicurology.MagicPotionApi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/magic")
public class OrdersController {

    private OrderService orderService;

    public OrdersController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderCreateResponse createOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
        return orderService.createOrder(orderCreateRequest);
    }

    @GetMapping("/{uid}")
    public OrderResponse getOrder(@PathVariable("uid") String uid) {
        return orderService.getOrder(uid);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> updateFulfillment(@RequestBody FulfillmentRequest fulfillmentRequest) {
        return orderService.updateOrder(fulfillmentRequest);
    }

    @DeleteMapping("/{uid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<String> deleteOrder(@PathVariable("uid") String uid) {
        return orderService.deleteOrder(uid);
    }

}
