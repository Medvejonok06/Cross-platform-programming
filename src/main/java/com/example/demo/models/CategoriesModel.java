package com.example.demo.models;

import com.example.demo.entity.Category;
import java.util.List;

//Модель, що містить список категорій
public class CategoriesModel {

    //Публічне фінальне поле — список об'єктів Category
    public final List<Category> categories;

    //Конструктор, який ініціалізує список категорій
    public CategoriesModel(List<Category> categories) {
        this.categories = categories;
    }
}
