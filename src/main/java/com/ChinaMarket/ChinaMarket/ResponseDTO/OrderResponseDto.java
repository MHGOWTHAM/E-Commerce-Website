package com.ChinaMarket.ChinaMarket.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDto {
    private String productName;

    private int itemPrice;

    private  int quantityOrdered;

    private Date orderDate;

    private int totalCost;

    private int deliveryCharge;

    private String cardUsedForPayment;
}
