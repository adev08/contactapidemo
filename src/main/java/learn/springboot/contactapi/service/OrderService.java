package learn.springboot.contactapi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import learn.springboot.contactapi.domain.Order;
import learn.springboot.contactapi.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public Order getOrder(Long id) {
        Optional<Order> maybeOrder = orderRepository.findById(id);

        Order founOrder = new Order();

        if (maybeOrder.isPresent()) {
            log.info("Found Order with id: " + id);
            founOrder = maybeOrder.get();
        }

        return founOrder;
    }
}
