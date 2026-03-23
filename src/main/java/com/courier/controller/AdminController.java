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

    @GetMapping("/clients")
    public String manageClients() {
        return "crud/clients";
    }

    @GetMapping("/receivers")
    public String manageReceivers() {
        return "crud/receivers";
    }

    @GetMapping("/package-types")
    public String managePackageTypes() {
        return "crud/package-types";
    }

    @GetMapping("/bus-routes")
    public String manageBusRoutes() {
        return "crud/bus-routes";
    }

    @GetMapping("/stations")
    public String manageStations() {
        return "crud/stations";
    }

    @GetMapping("/drivers")
    public String manageDrivers() {
        return "crud/drivers";
    }

    @GetMapping("/packages")
    public String managePackages() {
        return "crud/packages";
    }

    @GetMapping("/tracking")
    public String manageTracking() {
        return "crud/tracking";
    }

    @GetMapping("/exceptions")
    public String manageExceptions() {
        return "crud/exceptions";
    }

    @GetMapping("/payments")
    public String managePayments() {
        return "crud/payments";
    }
}
