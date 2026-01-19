package Karachi.FoodDelivery.controller;

import Karachi.FoodDelivery.entity.Product;
import Karachi.FoodDelivery.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/products")
public class ProductController {

    private final ProductService prodser;

    public ProductController(ProductService prodser) {
        this.prodser = prodser;
    }

    // ADD product to category
    @PostMapping("/category/{categoryId}")
    public Product addProduct(@PathVariable Long categoryId,
                              @RequestBody Product product) {
        return prodser.addProduct(categoryId, product);
    }

    // VIEW products by category
    @GetMapping("/category/{categoryId}")
    public List<Product> getProducts(@PathVariable Long categoryId) {
        return prodser.getProductsByCategory(categoryId);
    }

    // UPDATE product
    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable Long productId,
                                 @RequestBody Product product) {
        return prodser.updateProduct(productId, product);
    }

    // DELETE product
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Long productId) {
        prodser.deleteProduct(productId);
        return "Product deleted successfully";
    }

}
