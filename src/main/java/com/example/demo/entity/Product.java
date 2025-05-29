package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Generated;

@Entity //Позначає клас як сутність для збереження у базі даних
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Автоматично генерує унікальний ID для продукту
    private Long productId;

    private String name;
    private String description;
    private double price;
    private int stock;

    @ManyToMany //Зв'язок між продуктами і категоріями
    @JoinTable(
            name = "product_category", //Проміжна таблиця для зв’язку
            joinColumns = {@JoinColumn(name = "product_id")}, //Поточна сутність — продукт
            inverseJoinColumns = {@JoinColumn(name = "category_id")} //Пов’язана сутність — категорія
    )
    private Set<Category> categories = new HashSet(); //Список категорій, до яких належить товар

    @OneToMany(
            mappedBy = "product", //Поле, яке вказує на зв’язок у класі OrderItem
            cascade = {CascadeType.ALL}, //Усі операції будуть каскадуватися
            orphanRemoval = true //Якщо OrderItem буде видалено з product, він буде видалений і з БД
    )
    private List<OrderItem> orderItems; //Список елементів замовлення, пов’язаних з цим товаром

    //Гетери
    @Generated
    public Long getProductId() {
        return this.productId;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public String getDescription() {
        return this.description;
    }

    @Generated
    public double getPrice() {
        return this.price;
    }

    @Generated
    public int getStock() {
        return this.stock;
    }

    @Generated
    public Set<Category> getCategories() {
        return this.categories;
    }

    @Generated
    public List<OrderItem> getOrderItems() {
        return this.orderItems;
    }

    // Сетери
    @Generated
    public void setProductId(final Long productId) {
        this.productId = productId;
    }

    @Generated
    public void setName(final String name) {
        this.name = name;
    }

    @Generated
    public void setDescription(final String description) {
        this.description = description;
    }

    @Generated
    public void setPrice(final double price) {
        this.price = price;
    }

    @Generated
    public void setStock(final int stock) {
        this.stock = stock;
    }

    @Generated
    public void setCategories(final Set<Category> categories) {
        this.categories = categories;
    }

    @Generated
    public void setOrderItems(final List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Generated
    public Product() {
        //Порожній конструктор потрібен JPA
    }
}
