package stock.control.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stock.control.entities.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
