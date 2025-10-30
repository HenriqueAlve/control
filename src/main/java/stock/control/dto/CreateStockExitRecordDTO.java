package stock.control.dto;

import stock.control.enums.Type;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateStockExitRecordDTO(
        UUID product_id,
        int quantity,
        LocalDateTime exitDate,
        Type type
) {
}
