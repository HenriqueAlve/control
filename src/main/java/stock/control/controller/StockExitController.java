package stock.control.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stock.control.dto.CreateStockExitRecordDTO;
import stock.control.dto.UpdateStockExitRecordDTO;
import stock.control.entities.StockExit;
import stock.control.services.StockExitService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/saida-estoque")
public class StockExitController {

    private final StockExitService stockExitService;

    public StockExitController(StockExitService stockExitService){
        this.stockExitService = stockExitService;
    }

    @PostMapping
    public ResponseEntity<StockExit> save(@RequestBody CreateStockExitRecordDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(stockExitService.save(dto));
    }

    @GetMapping
    public ResponseEntity<List<StockExit>> findALL(){
        return ResponseEntity.ok(stockExitService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockExit> findByIdStockExit(@PathVariable UUID id){
        return ResponseEntity.ok(stockExitService.findByIdStockExit(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable UUID id, @RequestBody UpdateStockExitRecordDTO dto){
        stockExitService.update(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        stockExitService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
