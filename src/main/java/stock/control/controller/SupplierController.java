package stock.control.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stock.control.dto.CreateSupplierRecordDTO;
import stock.control.entities.Supplier;
import stock.control.services.SupplierService;

@RestController
@RequestMapping("/fornecedor")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService){
        this.supplierService = supplierService;
    }

    @PostMapping
    public ResponseEntity<Supplier> save(@Valid @RequestBody CreateSupplierRecordDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.save(dto))   ;
    }
}
