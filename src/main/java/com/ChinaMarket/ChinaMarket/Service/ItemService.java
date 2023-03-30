package com.ChinaMarket.ChinaMarket.Service;

import com.ChinaMarket.ChinaMarket.Exception.ProductNotFoundException;
import com.ChinaMarket.ChinaMarket.Model.Item;
import com.ChinaMarket.ChinaMarket.Model.Product;
import com.ChinaMarket.ChinaMarket.Repository.ItemRepository;
import com.ChinaMarket.ChinaMarket.Repository.ProductRepository;
import com.ChinaMarket.ChinaMarket.ResponseDTO.ItemResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ProductRepository productRepository;

    public ItemResponseDto viewItem(int productId) throws ProductNotFoundException {
        Product product;
        try{
            product=productRepository.findById(productId).get();
        }
        catch (Exception e){
            throw new ProductNotFoundException("Invalid product Id");
        }
        Item item=Item.builder()
                .requiredQuantity(0)
                .product(product)
                .build();

        //   Map item to product
        product.setItem(item);

        productRepository.save(product);

        //prepare the response Dto

        ItemResponseDto itemResponseDto=ItemResponseDto.builder()
                .productName(product.getProductName())
                .price(product.getPrice())
                .category(product.getCategory())
                .productStatus(product.getProductStatus())
                .build();

        return itemResponseDto;
    }
}
