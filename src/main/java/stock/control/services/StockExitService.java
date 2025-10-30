package stock.control.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import stock.control.dto.CreateStockExitRecordDTO;
import stock.control.dto.UpdateStockExitRecordDTO;
import stock.control.entities.Product;
import stock.control.entities.StockExit;
import stock.control.repository.ProductRepository;
import stock.control.repository.StockExitRepository;

import java.util.List;
import java.util.UUID;

@Service
public class StockExitService {

    private final StockExitRepository repository;
    private final ProductRepository productRepository;

    public StockExitService(StockExitRepository repository, ProductRepository productRepository){
        this.repository = repository;
        this.productRepository = productRepository;
    }

    @Transactional
    public StockExit save(CreateStockExitRecordDTO dto) {
        Product product = productRepository.findById(dto.product_id()).orElseThrow(
                () -> new RuntimeException("Produto não encontrado")
        );
        StockExit stockExit = new StockExit();
        if (dto.quantity() > product.getCurrentQuantity()){
            throw new RuntimeException("Quantidade de estoque indisponivel");
        }else{
            stockExit.setQuantity(dto.quantity());
            product.setCurrentQuantity(product.getCurrentQuantity() - dto.quantity());
        }
        stockExit.setExitDate(dto.exitDate());
        stockExit.setType(dto.type());
        stockExit.setProduct(product);
        productRepository.save(product);
        return repository.save(stockExit);
    }


    public List<StockExit> findAll() {
        return repository.findAll();
    }

    public StockExit findByIdStockExit(UUID id) {
        StockExit stockExit = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Saída de estoque não encontrada")
        );
        return stockExit;
    }

    @Transactional
    public void update(UUID id, UpdateStockExitRecordDTO dto) {
        StockExit stockExit = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Estoque de saida não encontrado")
        );
        stockExit.setExitDate(dto.exitDate());
         repository.save(stockExit);
    }

    @Transactional
    public void delete(UUID id) {
        StockExit stockExit = repository.findById(id).orElseThrow(
                () -> new RuntimeException("Estoque de saida não encontrado")
        );
        repository.delete(stockExit);
    }
}
