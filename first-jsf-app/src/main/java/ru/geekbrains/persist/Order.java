package ru.geekbrains.persist;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "orders")
@NamedQueries({
        @NamedQuery(name = "findAll", query = "from Order"),
        @NamedQuery(name = "countAll", query = "select count(*) from Order"),
        @NamedQuery(name = "deleteById", query = "delete from Order o where o.id = :id")
})
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String client;

    @Column(length = 1024)
    private String description;

    @Column
    private BigDecimal price;

    public Order() {
    }

    public Order(Long id, String client, String description, BigDecimal price) {
        this.id = id;
        this.client = client;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getClient() {
        return client;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}