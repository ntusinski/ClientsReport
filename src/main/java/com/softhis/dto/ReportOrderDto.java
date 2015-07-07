package com.softhis.dto;

import java.io.Serializable;
import java.util.Date;

public class ReportOrderDto implements Serializable {
    Date orderDate;

    int amount;

    public ReportOrderDto() {
    }

    public ReportOrderDto(Date orderDate, int amount) {
        this.orderDate = orderDate;
        this.amount = amount;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
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

        ReportOrderDto that = (ReportOrderDto) o;

        if (amount != that.amount) return false;
        return !(orderDate != null ? !orderDate.equals(that.orderDate) : that.orderDate != null);

    }

    @Override
    public int hashCode() {
        int result = orderDate != null ? orderDate.hashCode() : 0;
        result = 31 * result + amount;
        return result;
    }

    @Override
    public String toString() {
        return "ReportOrderDto{" +
                "orderDate=" + orderDate +
                ", amount=" + amount +
                '}';
    }
}
