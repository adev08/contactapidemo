package learn.springboot.contactapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import learn.springboot.contactapi.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
