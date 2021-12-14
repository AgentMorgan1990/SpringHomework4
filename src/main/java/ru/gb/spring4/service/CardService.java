package ru.gb.spring4.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import ru.gb.spring4.dto.ProductDto;
import ru.gb.spring4.dto.ProductDtoInCard;

@Data
@Slf4j
@Service
public class CardService {

   private ArrayList<ProductDtoInCard> productInCards = new ArrayList<>();

   public void delete(Long id) {
      ArrayList<ProductDtoInCard> productInCardsForIteration = new ArrayList<>(productInCards);
      for (ProductDtoInCard product : productInCardsForIteration) {
         if (product.getId().equals(id)) {
            productInCards.remove(product);
         }
      }
   }

   public ProductDtoInCard addProduct(ProductDto productDto) {
      boolean isPresent = false;
      ProductDtoInCard productDtoInCard = new ProductDtoInCard(
              productDto.getId(),
              productDto.getTitle(),
              productDto.getPrice(),
              1);
      for (ProductDtoInCard product : productInCards) {
         if (product.getId().equals(productDto.getId())) {
            isPresent = true;
            break;
         }
      }
      if (!isPresent) {
         productInCards.add(productDtoInCard);
      }
      return productDtoInCard;
   }


   public ProductDtoInCard changeProductCount(Long id, Integer count) {
      ArrayList<ProductDtoInCard> productInCardsForIteration = new ArrayList<>(productInCards);
      Integer newCount;
      ProductDtoInCard newNewProductDtoInCard = null;
      for (ProductDtoInCard product : productInCardsForIteration) {
         if (product.getId().equals(id)) {
            newCount = product.getCount() + count;
            if (newCount<1){
               newCount=1;
            }
            ProductDtoInCard newProductDtoInCard = new ProductDtoInCard(
                    product.getId(),
                    product.getTitle(),
                    product.getPrice(),
                    newCount);
            newNewProductDtoInCard = newProductDtoInCard;
            productInCards.remove(product);
            productInCards.add(newProductDtoInCard);
            break;
         }
      }
      return newNewProductDtoInCard;
   }
}

