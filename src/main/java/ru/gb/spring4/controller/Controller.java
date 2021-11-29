package ru.gb.spring4.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import ru.gb.spring4.service.InformationService;

@RestController
public class Controller {
    private final InformationService service;

    @Autowired
    private Controller(InformationService service) {
        this.service = service;
    }

    @GetMapping("/products/{id}")
    @ResponseBody
    public void findProducts(@PathVariable Long id) {
        service.showBuyersByProductId(id);
    }
    @GetMapping("/buyers/{id}")
    @ResponseBody
    public void findBuyers(@PathVariable Long id) {
        service.showProductByBuyerId(id);
    }

}
