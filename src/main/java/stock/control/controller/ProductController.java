package stock.control.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stock.control.dto.CreateProductRecordDTO;
import stock.control.dto.UpdateProductRecordDTO;
import stock.control.entities.Product;
import stock.control.services.ProductService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> save(@Valid @RequestBody CreateProductRecordDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(dto));
    }
    @GetMapping
    public ResponseEntity<List<Product>> listAll(){
        return ResponseEntity.ok(productService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findByIdProduct(@PathVariable UUID id){
        return ResponseEntity.ok(productService.findByIdProduct(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @PathVariable UUID id, @RequestBody UpdateProductRecordDTO dto){
        productService.update(id,dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
