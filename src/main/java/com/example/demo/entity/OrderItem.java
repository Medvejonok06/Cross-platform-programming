package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Generated;

@Entity //Позначає клас як сутність для JPA
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Автогенерація ID
    private Long orderItemId;

    @ManyToOne //Багато позицій можуть належати до одного замовлення
    @JoinColumn(name = "order_id") //Зовнішній ключ на таблицю orders
    private Order order;

    @ManyToOne //Багато позицій можуть бути пов’язані з одним товаром
    @JoinColumn(name = "product_id") //Зовнішній ключ на таблицю products
    private Product product;

    private int quantity;

    //Гетери
    @Generated
    public Long getOrderItemId() {
        return this.orderItemId;
    }

    @Generated
    public Order getOrder() {
        return this.order;
    }

    @Generated
    public Product getProduct() {
        return this.product;
    }

    @Generated
    public int getQuantity() {
        return this.quantity;
    }

    //Сетери
    @Generated
    public void setOrderItemId(final Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    @Generated
    public void setOrder(final Order order) {
        this.order = order;
    }

    @Generated
    public void setProduct(final Product product) {
        this.product = product;
    }

    @Generated
    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }

    @Generated
    public OrderItem() {
        //Порожній конструктор потрібен JPA
    }
}
