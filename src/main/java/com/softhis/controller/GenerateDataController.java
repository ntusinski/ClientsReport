package com.softhis.controller;

import com.softhis.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/generateData")
public class GenerateDataController {
    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public String generateReport(@RequestParam("clients") int clients, ModelMap model) {
        clientService.generateRandomClientsWithOrders(clients);
        return "generated";
    }
}