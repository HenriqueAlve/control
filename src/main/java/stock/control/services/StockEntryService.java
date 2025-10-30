package stock.control.services;

import org.springframework.stereotype.Service;
import stock.control.dto.CreateStockEntryRecordDTO;
import stock.control.entities.Product;
import stock.control.entities.StockEntry;
import stock.control.entities.Supplier;
import stock.control.repository.ProductRepository;
import stock.control.repository.StockEntryRepository;
import stock.control.repository.SupplierRepository;
import stock.control.response.ProductResponseDTO;
import stock.control.response.StockEntryResponseDTO;
import stock.control.response.SupplierResponseDTO;

@Service
public class StockEntryService {

    private final StockEntryRepository repository;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public StockEntryService(StockEntryRepository repository, ProductRepository productRepository, SupplierRepository supplierRepository){
        this.repository = repository;
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    public StockEntryResponseDTO save(CreateStockEntryRecordDTO dto) {
        // 1. Busca entidades
        Product product = productRepository.findById(dto.product_id())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Supplier supplier = supplierRepository.findById(dto.supplier_id())
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

        // 2. Cria e popula StockEntry
        StockEntry stockEntry = new StockEntry();
        stockEntry.setProduct(product);
        stockEntry.setSupplier(supplier);
        stockEntry.setEntryDate(dto.entryDate());
        stockEntry.setQuantity(dto.quantity());
        stockEntry.setObservation(dto.observation());

        // 3. Salva StockEntry no banco
        StockEntry savedEntry = repository.save(stockEntry);

        // 4. Cria ProductResponseDTO
        ProductResponseDTO productDTO = new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice()
        );

        // 5. Cria SupplierResponseDTO (sem stockEntries para evitar loop)
        SupplierResponseDTO supplierDTO = new SupplierResponseDTO(
                supplier.getId(),
                supplier.getName(),
                supplier.getCpf(),
                supplier.getPhone(),
                supplier.getEmail(),
                supplier.getAddress()
        );

        // 6. Cria StockEntryResponseDTO
        return new StockEntryResponseDTO(
                savedEntry.getId(),
                savedEntry.getQuantity(),
                savedEntry.getEntryDate(),
                savedEntry.getObservation(),
                productDTO,
                supplierDTO
        );
    }

}
