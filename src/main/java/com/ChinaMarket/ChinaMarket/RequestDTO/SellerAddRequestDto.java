package com.ChinaMarket.ChinaMarket.RequestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerAddRequestDto {

    private String name;

    private String email;

    private String mobNo;

    private String panNo;
}
