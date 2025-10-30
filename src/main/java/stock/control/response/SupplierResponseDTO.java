package stock.control.response;

import java.util.UUID;

public record SupplierResponseDTO(
        UUID id,
        String name,
        String cpf,
        String email,
        String phone,

        stock.control.entities.Address address
) {
}
