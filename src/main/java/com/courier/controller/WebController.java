package com.courier.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String landingPage() {
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboardRouter(Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            String role = authority.getAuthority();
            if (role.equals("ROLE_ADMIN")) return "redirect:/admin/dashboard";
            if (role.equals("ROLE_MANAGER")) return "redirect:/manager/dashboard";
            if (role.equals("ROLE_CLERK")) return "redirect:/clerk/dashboard";
            if (role.equals("ROLE_DRIVER")) return "redirect:/driver/dashboard";
            if (role.equals("ROLE_AUDITOR")) return "redirect:/auditor/dashboard";
        }
        
        return "redirect:/login";
    }
}
