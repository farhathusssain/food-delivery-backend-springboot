package Karachi.FoodDelivery.controller;

import Karachi.FoodDelivery.dto.LoginRequest;
import Karachi.FoodDelivery.service.AdminAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class AdminAuthController {
        @Autowired
        private final AdminAuthService adminAuthService;

    public AdminAuthController(AdminAuthService adminAuthService) {
        this.adminAuthService = adminAuthService;
    }

    @PostMapping("/login")
        public String adminLogin(@RequestBody LoginRequest request) {
            return adminAuthService.login(request);
        }
}
