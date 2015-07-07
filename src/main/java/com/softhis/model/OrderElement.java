package com.softhis.model;

import javax.persistence.*;

@Entity
@Table(name = "ORDER_ELEMENT")
public class OrderElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @Column(name = "ORDER", nullable = false)
    private Order order;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "AMOUNT", nullable = false)
    private int amount;

    public OrderElement() {
    }

    public OrderElement(Order order, String name, int amount) {
        this.order = order;
        this.name = name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderElement that = (OrderElement) o;

        if (id != that.id) return false;
        if (amount != that.amount) return false;
        return !(name != null ? !name.equals(that.name) : that.name != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + amount;
        return result;
    }

    @Override
    public String toString() {
        return "OrderElement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
