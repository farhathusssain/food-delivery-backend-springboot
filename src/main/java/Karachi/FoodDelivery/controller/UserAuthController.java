package Karachi.FoodDelivery.controller;

import Karachi.FoodDelivery.dto.LoginRequest;
import Karachi.FoodDelivery.dto.RegisterRequest;
import Karachi.FoodDelivery.entity.User;
import Karachi.FoodDelivery.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/auth")
public class UserAuthController {
    @Autowired
    private UserAuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }


    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}
