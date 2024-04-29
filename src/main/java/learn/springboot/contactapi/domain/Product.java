package learn.springboot.contactapi.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "alias")
    private String alias;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "in_stock")
    private Boolean inStock;

    @Column(name = "list_price")
    private Double listPrice;

    @Column(name = "discount_percentage")
    private Double discountPercentage;

    @Column(name = "brand_id")
    private Long brandID;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "length")
    private Double length;
}
