package stock.control.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record StockEntryResponseDTO(
        UUID id,
        int quantity,
        LocalDateTime entryDate,
        String observation,
        ProductResponseDTO product,
        SupplierResponseDTO supplier
) {
}
