package com.softhis.dto;

import java.io.Serializable;
import java.util.List;

public class ReportLineDto implements Serializable {
    private String firstName;

    private String lastName;

    private int amount;

    private List<ReportOrderDto> mostExpensiveOrders;

    public ReportLineDto() {
    }

    public ReportLineDto(String firstName, String lastName, int amount, List<ReportOrderDto> mostExpensiveOrders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.amount = amount;
        this.mostExpensiveOrders = mostExpensiveOrders;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<ReportOrderDto> getMostExpensiveOrders() {
        return mostExpensiveOrders;
    }

    public void setMostExpensiveOrders(List<ReportOrderDto> mostExpensiveOrders) {
        this.mostExpensiveOrders = mostExpensiveOrders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReportLineDto that = (ReportLineDto) o;

        if (amount != that.amount) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        return !(mostExpensiveOrders != null ? !mostExpensiveOrders.equals(that.mostExpensiveOrders) : that.mostExpensiveOrders != null);

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + amount;
        result = 31 * result + (mostExpensiveOrders != null ? mostExpensiveOrders.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ReportLineDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", amount=" + amount +
                ", mostExpensiveOrders=" + mostExpensiveOrders +
                '}';
    }
}
