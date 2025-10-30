package stock.control.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record CreateProductRecordDTO(
        @NotBlank(message = "O nome é obrigatorio.")
        String name,
        @NotBlank(message = "A descrição é obrigatoria")
        String description,
         @NotNull(message = "O preço é obrigatorio.")
         Double price,
         @NotNull(message = "A quantidade atual é obrigatoria.")
         int currentQuantity,
         @NotNull(message = "A quantidade minima no estoque é obrigatoria.")
         int minimunStock,

        String imageBase64
) {
}
