package stock.control.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateStockEntryRecordDTO(
        UUID product_id,
        UUID supplier_id,
        int quantity,
        LocalDateTime entryDate,
        String observation
) {
}
