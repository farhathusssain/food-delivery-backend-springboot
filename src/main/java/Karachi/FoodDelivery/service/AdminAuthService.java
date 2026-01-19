package Karachi.FoodDelivery.service;

import Karachi.FoodDelivery.dto.LoginRequest;
import Karachi.FoodDelivery.entity.User;
import Karachi.FoodDelivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAuthService {

    @Autowired
    private final UserRepository userrepo;

    public AdminAuthService(UserRepository userrepo) {
        this.userrepo = userrepo;
    }

    public String login(LoginRequest request){
        User admin = userrepo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        if (!admin.getRole().equals("ADMIN")) {
            throw new RuntimeException("Not an admin");
        }

        if (!admin.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return "Admin login successful";
    }
}

