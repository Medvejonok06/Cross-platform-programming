package com.example.demo.models;

import com.example.demo.entity.Category;
import java.util.List;

public class CategoriesModel {
    public final List<Category> categories;

    public CategoriesModel(List<Category> categories) {
        this.categories = categories;
    }
}
