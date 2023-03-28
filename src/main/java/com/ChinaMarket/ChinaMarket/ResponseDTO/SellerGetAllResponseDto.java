package com.ChinaMarket.ChinaMarket.ResponseDTO;

import com.ChinaMarket.ChinaMarket.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SellerGetAllResponseDto {
    private String name;

    private String email;

    private String mobNo;

    private String panNo;

    List<Product> products;

}
