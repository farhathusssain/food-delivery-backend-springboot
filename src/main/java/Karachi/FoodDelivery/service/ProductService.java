package Karachi.FoodDelivery.service;

import Karachi.FoodDelivery.entity.Category;
import Karachi.FoodDelivery.entity.Product;
import Karachi.FoodDelivery.repository.CategoryRepository;
import Karachi.FoodDelivery.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    private final ProductRepository prorepo;
    private final CategoryRepository catrepo;


    public ProductService(ProductRepository prorepo, CategoryRepository catrepo) {
        this.prorepo = prorepo;
        this.catrepo = catrepo;
    }

//    Add Product
    public Product addProduct(Long categoryId, Product P){

        Category category = catrepo.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category is not Found"));

        P.setCategory(category);
        return prorepo.save(P);
    }

    // VIEW products by category
    public List<Product> getProductsByCategory(Long categoryId) {
        return prorepo.findByCategory_Id(categoryId);
    }

    // UPDATE product
    public Product updateProduct(Long productId, Product newData) {

        Product product = prorepo.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setName(newData.getName());
        product.setName(newData.getDescription());
        product.setPrice(newData.getPrice());

        return prorepo.save(product);
    }

    // DELETE product
    public void deleteProduct(Long productId) {
        prorepo.deleteById(productId);
    }
}
