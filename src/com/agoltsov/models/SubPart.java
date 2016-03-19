package com.agoltsov.models;


import java.util.Objects;

public class SubPart {

    private String name;
    private int quantity;

    public SubPart(String subPart, int quantity) {
        this.name = subPart;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SubPart{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubPart subPart = (SubPart) o;
        return Objects.equals(name, subPart.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
