package stock.control.services;

import org.springframework.stereotype.Service;
import stock.control.dto.CreateSupplierRecordDTO;
import stock.control.entities.Address;
import stock.control.entities.Supplier;
import stock.control.repository.SupplierRepository;

@Service
public class SupplierService {

    private final SupplierRepository repository;

    public SupplierService(SupplierRepository repository){
        this.repository = repository;
    }

    public Supplier save(CreateSupplierRecordDTO dto) {
        Supplier supplier = new Supplier();
        supplier.setName(dto.name());
        supplier.setCpf(dto.cpf());
        supplier.setPhone(dto.phone());
        supplier.setEmail(dto.email());

        Address address = new Address();
        address.setStreet(dto.address().street());
        address.setNumber(dto.address().number());
        address.setNeighborhood(dto.address().neighborhood());
        address.setCity(dto.address().city());
        address.setState(dto.address().state());
        address.setZipCode(dto.address().zipCode());

        supplier.setAddress(address);

        return repository.save(supplier);
    }
}
