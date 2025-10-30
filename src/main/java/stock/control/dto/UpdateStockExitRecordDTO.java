package stock.control.dto;

import stock.control.enums.Type;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateStockExitRecordDTO(

        LocalDateTime exitDate

) {
}
