package com.agoltsov.models;

import java.util.Objects;

public class Element {

    private String part;
    private String subPart;
    private int quantity;

    public Element(String part, String subPart, Integer quantity) {
        this.part = part;
        this.subPart = subPart;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return Objects.equals(quantity, element.quantity) &&
                Objects.equals(part, element.part) &&
                Objects.equals(subPart, element.subPart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(part, subPart);
    }

    @Override
    public String toString() {
        return "Element{" +
                "part='" + part + '\'' +
                ", subPart='" + subPart + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getSubPart() {
        return subPart;
    }

    public void setSubPart(String subPart) {
        this.subPart = subPart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
