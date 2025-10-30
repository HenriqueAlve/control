package stock.control.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import stock.control.entities.StockExit;

import java.util.UUID;

@Repository
public interface StockExitRepository extends JpaRepository<StockExit, UUID> {
}
