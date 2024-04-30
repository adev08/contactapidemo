package learn.springboot.contactapi.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import learn.springboot.contactapi.domain.Order;
import learn.springboot.contactapi.domain.OrderDetail;
import learn.springboot.contactapi.repo.OrderDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    public OrderDetail getOrderDetail(Long id) {
        Optional<OrderDetail> maybeOrderDeOptional = orderDetailRepository.findById(id);

        OrderDetail foundOrderDetail = new OrderDetail();

        if (maybeOrderDeOptional.isPresent()) {
            log.info("Found Order with id: " + id);
            foundOrderDetail = maybeOrderDeOptional.get();
        }

        return foundOrderDetail;
    }
}
