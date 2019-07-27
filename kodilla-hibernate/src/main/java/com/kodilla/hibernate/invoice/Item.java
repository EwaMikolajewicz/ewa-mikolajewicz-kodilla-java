package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ITEMS")
public class Item {

    private int id;
    private Product product;
    private BigDecimal price;
    private int quantity;
    private BigDecimal value;
    private Invoice invoice;

    public Item(){

    }

    public Item(BigDecimal price, int quantity, BigDecimal value) {
        this.price = price;
        this.quantity = quantity;
        this.value = value;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID", unique = true, nullable = false)
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    @ManyToOne(
            cascade = CascadeType.PERSIST
    )
    @JoinColumn(name = "PRODUCT_ID")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    @ManyToOne(
            cascade = CascadeType.PERSIST
    )
    @JoinColumn(name = "INVOICE_ID")
    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    @Column(name = "PRICE", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "QUANTITY", nullable = false)
    public int getQuantity() {
        return quantity;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Column(name = "VALUE", nullable = false)
    public BigDecimal getValue() {
        return value;
    }

    private void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof  Item)) return false;
        Item e = (Item) o;
       return id == e.id
               &&(price.equals((e.price)))
               && (quantity == e.quantity)
               &&(value.equals(e.value));
    }

    @Override
    public int hashCode() {
        int result = price.hashCode();
        result = 31 * result + quantity;
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "price=" + price +
                ", quantity=" + quantity +
                ", value=" + value +
                '}';
    }
}
