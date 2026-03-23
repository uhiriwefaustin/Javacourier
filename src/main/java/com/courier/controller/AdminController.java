package com.courier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboards/admin";
    }
    
    @GetMapping("/users")
    public String manageUsers() {
        return "crud/users";
    }
    
    @GetMapping("/companies")
    public String manageCompanies() {
        return "crud/companies";
    }
}
