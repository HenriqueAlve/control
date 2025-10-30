package stock.control.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stock.control.dto.CreateStockEntryRecordDTO;
import stock.control.entities.StockEntry;
import stock.control.response.StockEntryResponseDTO;
import stock.control.services.StockEntryService;

@RestController
@RequestMapping("/entrada-estoque")
public class StockEntryController {

    private final StockEntryService stockEntryService;

    public StockEntryController(StockEntryService stockEntryService){
        this.stockEntryService = stockEntryService;
    }

    @PostMapping
    public ResponseEntity<StockEntryResponseDTO> save(@Valid @RequestBody CreateStockEntryRecordDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(stockEntryService.save(dto));
    }

}
