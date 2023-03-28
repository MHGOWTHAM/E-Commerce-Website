package com.ChinaMarket.ChinaMarket.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerGetAllRequestDto {
    private String name;

    private String email;

    private String mobNo;

    private String panNo;

    private int productId;
}
