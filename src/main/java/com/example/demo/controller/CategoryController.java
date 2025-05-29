package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller //Клас обробляє веб-запити та повертає HTML-шаблони
public class CategoryController {

    private final CategoryRepository categoryRepository;

    //Ін’єкція залежності — репозиторію категорій
    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //Відображення сторінки зі списком категорій
    //Підтримує сортування, пошук категорій за назвою
    @GetMapping("/categories")
    public String showCategories(Model model,
                                 @RequestParam(name = "sort", required = false) String sort,
                                 @RequestParam(name = "search", required = false) String search) {

        Iterable<Category> categories;

        //Пошук відповідно до запиту
        if (search != null && !search.isBlank()) {
            categories = categoryRepository.findByNameContainingIgnoreCase(search);
        }

        //Якщо "asc", то сортуємо категорії за алфавітом (А -> Я)
        else if ("asc".equalsIgnoreCase(sort)) {
            categories = categoryRepository.findAllByOrderByNameAsc();
        }

        //Якщо "desc", то сортуємо у зворотному алфавітному порядку (Я -> А)
        else if ("desc".equalsIgnoreCase(sort)) {
            categories = categoryRepository.findAllByOrderByNameDesc();
        }

        //Якщо жодного параметра не вказано — виводимо всі категорії без сортування
        else {
            categories = categoryRepository.findAll();
        }

        //Передаємо список категорій до шаблону
        model.addAttribute("categories", categories);
        model.addAttribute("sort", sort);
        model.addAttribute("search", search);

        return "categories";
    }

    //Перенаправлення з головної сторінки на /categories
    @GetMapping("/")
    public String redirectToCategories() {
        return "redirect:/categories";
    }

    //Показати форму для додавання нової категорії
    @GetMapping("/categories/add")
    public String showAddCategoryForm() {
        return "add-category";
    }

    //Зберегти нову категорію після сабміту форми
    @PostMapping("/categories/save")
    public String saveNewCategory(@RequestParam String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
        return "redirect:/categories";
    }

    //Показати форму редагування для існуючої категорії
    @GetMapping("/categories/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Невірний ID категорії: " + id));
        model.addAttribute("category", category);
        return "edit-category";
    }

    //Зберегти зміни після редагування категорії
    @PostMapping("/categories/update")
    public String updateCategory(@RequestParam Long categoryId,
                                 @RequestParam String name) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Невірний ID категорії: " + categoryId));
        category.setName(name);
        categoryRepository.save(category);
        return "redirect:/categories";
    }

    //Видалити категорію за її ID
    @PostMapping("/categories/delete")
    public String deleteCategory(@RequestParam Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new IllegalArgumentException("Невірний ID категорії: " + categoryId));
        categoryRepository.delete(category);
        return "redirect:/categories";
    }
}
