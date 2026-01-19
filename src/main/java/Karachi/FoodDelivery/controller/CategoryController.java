package Karachi.FoodDelivery.controller;

import Karachi.FoodDelivery.entity.Category;
import Karachi.FoodDelivery.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/categories")
public class CategoryController {

    private final CategoryService catser;

    public CategoryController(CategoryService catser) {
        this.catser = catser;
    }

    // ADD category
    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return catser.addcategory(category);
    }

    // VIEW categories
    @GetMapping
    public List<Category> getCategories() {
        return catser.getAllCategories();
    }

    // UPDATE category
    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id,
                                   @RequestBody Category category) {
        return catser.updateCategory(id, category);
    }

    // DELETE category
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Long id) {
        catser.deleteCategory(id);
        return "Category deleted successfully";
    }
}
