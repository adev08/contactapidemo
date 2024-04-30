package learn.springboot.contactapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import learn.springboot.contactapi.domain.Contact;
import learn.springboot.contactapi.domain.Order;
import learn.springboot.contactapi.service.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrders(@PathVariable Long id) {
        return ResponseEntity.ok().body(orderService.getOrder(id));
    }
}
