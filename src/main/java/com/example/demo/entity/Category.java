package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Set;
import lombok.Generated;

//Lombok @Generated — вказує, що ці методи згенеровані автоматично (щоб IDE не попереджали)
//@Entity — позначає клас як сутність (таблицю в базі даних)
@Entity
@Table(name = "categories")
public class Category {

    @Id
    //Стратегія генерації значень: автоматичне збільшення (ідентифікатор з автоінкрементом)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products;

    //Геттери

    @Generated
    public Long getCategoryId() {
        return this.categoryId;
    }

    @Generated
    public String getName() {
        return this.name;
    }

    @Generated
    public Set<Product> getProducts() {
        return this.products;
    }

    //Сеттери
    @Generated
    public void setCategoryId(final Long categoryId) {
        this.categoryId = categoryId;
    }

    @Generated
    public void setName(final String name) {
        this.name = name;
    }

    @Generated
    public void setProducts(final Set<Product> products) {
        this.products = products;
    }

    //Порожній конструктор, потрібен для JPA
    @Generated
    public Category() {
    }
}