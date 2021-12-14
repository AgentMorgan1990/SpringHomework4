package ru.gb.spring4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDtoInCard {
    private Long id;
    private String title;
    private Integer price;
    private Integer count;
}