package stock.control.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import stock.control.entities.Address;
import stock.control.entities.StockEntry;

import java.util.List;

public record CreateSupplierRecordDTO(
         String name,
         String cpf,
         String phone,
         String email,
         CreateAddressRecordDTO address

) {
}
