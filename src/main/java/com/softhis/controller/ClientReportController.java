package com.softhis.controller;

import com.softhis.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class ClientReportController {
    @Autowired
    private ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public String generateReport(ModelMap model) {
        clientService.generateRandomClientsWithOrders();
        model.addAttribute("report", clientService.getClientReport(3));
        return "report";
    }
}