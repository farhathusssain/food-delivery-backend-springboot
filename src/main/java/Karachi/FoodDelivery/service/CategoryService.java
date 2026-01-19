package Karachi.FoodDelivery.service;

import Karachi.FoodDelivery.entity.Category;
import Karachi.FoodDelivery.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository catrepo;

    public CategoryService(CategoryRepository catrepo) {
        this.catrepo = catrepo;
    }

//    Add Formula --> entity method name entity data)
    public Category addcategory(Category c){
        return catrepo.save(c);
    }


    // GET all categories Formula --> List<Entity> method name
    public List<Category> getAllCategories() {
        return catrepo.findAll();
    }

    // UPDATE category Formula --> Entity methodName LongId, Entity
    public Category updateCategory(Long id, Category newData) {
        Category category = catrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(newData.getName());
        return catrepo.save(category);
    }

    // DELETE category formula --> void methodName LongId
    public void deleteCategory(Long id) {
        catrepo.deleteById(id);
    }

}
