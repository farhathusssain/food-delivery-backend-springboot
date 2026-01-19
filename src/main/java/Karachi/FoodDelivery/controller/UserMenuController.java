package Karachi.FoodDelivery.controller;

import Karachi.FoodDelivery.entity.Category;
import Karachi.FoodDelivery.entity.Product;
import Karachi.FoodDelivery.service.CategoryService;
import Karachi.FoodDelivery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users/menu")
public class UserMenuController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    // View categories
    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.getAllCategories();
    }

    // View products by category
    @GetMapping("/categories/{categoryId}/products")
    public List<Product> getProducts(@PathVariable Long categoryId) {
        return productService.getProductsByCategory(categoryId);
    }
}
