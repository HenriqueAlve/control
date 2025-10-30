package stock.control.response;

public record AddressResponseDTO(
        String street,
        String number,
        String neighborhood,
        String city,
        String state,
        String zipCode
) {
}
