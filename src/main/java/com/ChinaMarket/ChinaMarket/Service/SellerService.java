package com.ChinaMarket.ChinaMarket.Service;

import com.ChinaMarket.ChinaMarket.Convertor.ProductConvertor;
import com.ChinaMarket.ChinaMarket.Convertor.SellerConvertor;
import com.ChinaMarket.ChinaMarket.Model.Product;
import com.ChinaMarket.ChinaMarket.Model.Seller;
import com.ChinaMarket.ChinaMarket.Repository.SellerRepository;
import com.ChinaMarket.ChinaMarket.RequestDTO.SellerAddRequestDto;
import com.ChinaMarket.ChinaMarket.RequestDTO.SellerGetAllRequestDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.ProductResponseDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.SellerGetAllResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class SellerService {
    @Autowired
    SellerRepository sellerRepository;
    public String addSeller(SellerAddRequestDto sellerRequestDto) {
       Seller seller= SellerConvertor.sellerRequestDtoToSeller(sellerRequestDto);

       sellerRepository.save(seller);

       return "Congrats!!!. Now you can sell your product on China Market.";
    }

//    public List<SellerGetAllResponseDto> getAllTheSeller() {
//        List<SellerGetAllResponseDto> seller=sellerRepository.getAllSeller();
//
//       List<SellerGetAllResponseDto> sellerGetAllResponseDtos=new ArrayList<>();
//       for(SellerGetAllResponseDto sellerGetAllResponseDto:seller){
//           SellerGetAllResponseDto sellerGetAllResponseDto1=SellerConvertor.sellerToSellerResponseDto(sellerGetAllResponseDto);
//            sellerGetAllResponseDtos.add(sellerGetAllResponseDto1);
//       }
//       return sellerGetAllResponseDtos;
//    }
}
