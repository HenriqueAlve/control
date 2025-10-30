package stock.control.response;

import java.util.UUID;

public record ProductResponseDTO(
        UUID id,
        String name,
        Double price
) {
}
