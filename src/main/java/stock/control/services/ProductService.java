package stock.control.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stock.control.dto.CreateProductRecordDTO;
import stock.control.dto.UpdateProductRecordDTO;
import stock.control.entities.Product;
import stock.control.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository= repository;
    }

    @Transactional
    public Product save(CreateProductRecordDTO dto) {
        Product product = new Product();
        product.setName(dto.name());
        product.setDescription(dto.description());

        if(dto.price() < 0){
            throw new RuntimeException("O valor não pode ser negativo");
        }
        product.setPrice(dto.price());

        if(dto.currentQuantity() <= 0){
            throw new RuntimeException("A quantidade atual não pode ser 0");
        }
        product.setCurrentQuantity(dto.currentQuantity());

        product.setMinimunStock(dto.minimunStock());

        // CONVERTENDO BASE64 PARA BYTE[]
        if(dto.imageBase64() != null && !dto.imageBase64().isEmpty()){
            product.setImage(java.util.Base64.getDecoder().decode(dto.imageBase64()));
        }

        return repository.save(product);
    }

    public List<Product> listAll() {
        return repository.findAll();
    }

    public Product findByIdProduct(UUID id) {
        Product product = repository.findById(id).orElseThrow(
                () -> new RuntimeException("O produto não foi encontrado")
        );
        return product;
    }

    @Transactional
    public Object update(UUID id, UpdateProductRecordDTO dto) {
        Product  product = repository.findById(id).orElseThrow(
                () -> new RuntimeException("O produto não foi encontrado")
        );

        product.setName(dto.name());
        product.setDescription(dto.description());
        if(dto.price() < 0){
            throw new RuntimeException("O valor não poder ser negativo");
        } else {
            product.setPrice(dto.price());
        }
        if (dto.currentQuantity() < 0){
            throw new RuntimeException("A quantidade atual não pode ser negativa");

        }else {
            product.setCurrentQuantity(dto.currentQuantity());
        }


        product.setMinimunStock(dto.minimunStock());

        return repository.save(product);
    }

    public void delete(UUID id) {
        Product  product = repository.findById(id).orElseThrow(
                () -> new RuntimeException("O produto não foi encontrado")
        );
         repository.delete(product);
    }
}
