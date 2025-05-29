package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Generated;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Автогенерація ID
    private Long orderId;

    private String customerName;

    private LocalDateTime orderDate;

    @OneToMany(
            mappedBy = "order", //Пов’язане з полем "order" у класі OrderItem
            cascade = {CascadeType.ALL}, //Каскадне збереження/видалення дочірніх елементів
            orphanRemoval = true //Видалення дочірніх елементів, якщо вони більше не пов’язані
    )
    private List<OrderItem> orderItems; //Список позицій у замовленні

    //Гетери та сетери
    @Generated
    public Long getOrderId() {
        return this.orderId;
    }

    @Generated
    public String getCustomerName() {
        return this.customerName;
    }

    @Generated
    public LocalDateTime getOrderDate() {
        return this.orderDate;
    }

    @Generated
    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    @Generated
    public void setOrderId(final Long orderId) {
        this.orderId = orderId;
    }

    @Generated
    public void setCustomerName(final String customerName) {
        this.customerName = customerName;
    }

    @Generated
    public void setOrderDate(final LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Generated
    public void setOrderItems(final List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Generated
    public Order() {
        //Порожній конструктор потрібен JPA
    }
}
