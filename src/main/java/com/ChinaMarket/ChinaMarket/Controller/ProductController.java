package com.ChinaMarket.ChinaMarket.Controller;

import com.ChinaMarket.ChinaMarket.Enum.ProductCategory;
import com.ChinaMarket.ChinaMarket.Exception.SellerNotFoundException;
import com.ChinaMarket.ChinaMarket.Repository.SellerRepository;
import com.ChinaMarket.ChinaMarket.RequestDTO.ProductRequestDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.ProductResponseDto;
import com.ChinaMarket.ChinaMarket.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody ProductRequestDto productRequestDto)  {
        ProductResponseDto productResponseDto;
        try{
            productResponseDto=productService.addProduct(productRequestDto);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(productResponseDto,HttpStatus.ACCEPTED);
    }
    @GetMapping("/get/category/{productCategory}")
    public List<ProductResponseDto> getAllProductByCategory(@PathVariable("productCategory")ProductCategory productCategory){
        return productService.getProductByCategory(productCategory);
    }

}
