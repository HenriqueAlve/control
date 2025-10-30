package stock.control.dto;

public record CreateAddressRecordDTO(
         String street,
         String number,
         String neighborhood,
         String city,
         String state,
         String zipCode
) {
}
