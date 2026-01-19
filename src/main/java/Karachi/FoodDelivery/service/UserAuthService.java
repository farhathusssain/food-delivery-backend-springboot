package Karachi.FoodDelivery.service;

import Karachi.FoodDelivery.dto.LoginRequest;
import Karachi.FoodDelivery.dto.RegisterRequest;
import Karachi.FoodDelivery.entity.User;
import Karachi.FoodDelivery.enums.UserRole;
import Karachi.FoodDelivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService {
    @Autowired
    private UserRepository userRepo;

    public User register(RegisterRequest request) {

        if (userRepo.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // plain text (learning)
        user.setRole(String.valueOf(UserRole.USER));

        return userRepo.save(user);
    }

    // USER login
    public User login(LoginRequest request) {

        User user = userRepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }
}
