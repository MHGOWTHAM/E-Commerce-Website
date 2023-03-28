package com.ChinaMarket.ChinaMarket.Service;

import com.ChinaMarket.ChinaMarket.Convertor.ProductConvertor;
import com.ChinaMarket.ChinaMarket.Enum.ProductCategory;
import com.ChinaMarket.ChinaMarket.Exception.SellerNotFoundException;
import com.ChinaMarket.ChinaMarket.Model.Product;
import com.ChinaMarket.ChinaMarket.Model.Seller;
import com.ChinaMarket.ChinaMarket.Repository.ProductRepository;
import com.ChinaMarket.ChinaMarket.Repository.SellerRepository;
import com.ChinaMarket.ChinaMarket.RequestDTO.ProductRequestDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    SellerRepository sellerRepository;

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException {
        Seller seller;
        try{
            seller=sellerRepository.findById(productRequestDto.getSellerId()).get();
        }
        catch (Exception e){
            throw new SellerNotFoundException("Invalid SellerId");
        }
        Product product= ProductConvertor.productRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);

        seller.getProducts().add(product);
        //saved the seller and product
         sellerRepository.save(seller);

         ProductResponseDto productResponseDto=ProductConvertor.productToProductResponseDto(product);
         return  productResponseDto;
    }
    public List<ProductResponseDto> getProductByCategory(ProductCategory productCategory) {
        List<Product> products=productRepository.findAllProductByCategory(productCategory);
        List<ProductResponseDto> productResponseDtos=new ArrayList<>();
        for(Product product:products){
           ProductResponseDto productResponseDto=ProductConvertor.productToProductResponseDto(product);
           productResponseDtos.add(productResponseDto);
        }
        return productResponseDtos;
    }
}
