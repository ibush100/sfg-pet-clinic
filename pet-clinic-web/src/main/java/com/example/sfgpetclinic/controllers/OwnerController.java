package com.example.sfgpetclinic.controllers;

import com.example.sfgpetclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/html"})
    public String listOwners(Model model){

        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }
}
