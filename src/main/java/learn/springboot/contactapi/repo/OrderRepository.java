package learn.springboot.contactapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learn.springboot.contactapi.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
