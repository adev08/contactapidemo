package learn.springboot.contactapi.repo;

import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import learn.springboot.contactapi.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findById(Long id);

    // @Query("SELECT DISTINCT o FROM Order o JOIN o.orderDetails od JOIN od.product
    // p"
    // + " WHERE p.name LIKE %?1%")
    // public Page<Order> findAll(String keyword, Pageable pageable);
}
