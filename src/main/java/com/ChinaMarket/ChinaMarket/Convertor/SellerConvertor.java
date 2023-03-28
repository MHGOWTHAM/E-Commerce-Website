package com.ChinaMarket.ChinaMarket.Convertor;

import com.ChinaMarket.ChinaMarket.Model.Seller;
import com.ChinaMarket.ChinaMarket.RequestDTO.SellerAddRequestDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.SellerGetAllResponseDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SellerConvertor {
    public static Seller sellerRequestDtoToSeller(SellerAddRequestDto sellerRequestDto){
        return Seller.builder()
                .name(sellerRequestDto.getName())
                .panNo(sellerRequestDto.getPanNo())
                .mobNo(sellerRequestDto.getMobNo())
                .email(sellerRequestDto.getEmail()).build();
    }
    public static SellerGetAllResponseDto sellerToSellerResponseDto(SellerGetAllResponseDto sellerGetAllResponseDto){
        return SellerGetAllResponseDto.builder()
                .email(sellerGetAllResponseDto.getEmail())
                .panNo(sellerGetAllResponseDto.getPanNo())
                .name(sellerGetAllResponseDto.getName())
                .mobNo(sellerGetAllResponseDto.getMobNo())
                .build();
    }
}
