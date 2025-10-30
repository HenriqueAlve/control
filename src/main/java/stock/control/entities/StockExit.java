package stock.control.entities;

import jakarta.persistence.*;
import stock.control.enums.Type;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "saida_estoque")
public class StockExit {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    private int quantity;
    private LocalDateTime exitDate;
    @Enumerated(EnumType.STRING)
    private Type type;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDateTime exitDate) {
        this.exitDate = exitDate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
