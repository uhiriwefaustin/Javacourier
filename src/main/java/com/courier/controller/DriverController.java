package com.courier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/driver")
public class DriverController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboards/driver";
    }
}
