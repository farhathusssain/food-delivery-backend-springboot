package Karachi.FoodDelivery.repository;

import Karachi.FoodDelivery.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
