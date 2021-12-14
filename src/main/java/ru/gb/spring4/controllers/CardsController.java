package ru.gb.spring4.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import ru.gb.spring4.converters.ProductConverter;
import ru.gb.spring4.dto.ProductDto;
import ru.gb.spring4.dto.ProductDtoInCard;
import ru.gb.spring4.service.CardService;
import ru.gb.spring4.entity.Product;
import ru.gb.spring4.exceptions.ResourceNotFoundException;
import ru.gb.spring4.service.ProductsService;


@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardsController {
    private final ProductsService productsService;
    private final CardService card;
    private final ProductConverter productConverter;


    @GetMapping
    public ArrayList<ProductDtoInCard> getCardList() {
        return card.getProductInCards();
    }

    @PostMapping()
    public ProductDtoInCard addProductToCard(@RequestParam(value = "id") Long id) {
        Product product = productsService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not " +
                "found, id: " + id));
        ProductDto productDto = productConverter.entityToDto(product);
        return card.addProduct(productDto);
    }

    @PutMapping
    public ProductDtoInCard updateProductCount(@RequestParam(value = "id") Long id,
                                               @RequestParam(value = "count") Integer count) {
        productsService.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
        return card.changeProductCount(id, count);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productsService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not " +
                "found, id: " + id));
        card.delete(id);
    }
}

