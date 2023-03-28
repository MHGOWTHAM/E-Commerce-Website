package com.ChinaMarket.ChinaMarket.RequestDTO;

import com.ChinaMarket.ChinaMarket.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CardRequestDto {
    private String cardNo;

    private int cvv;

    private CardType cardType;

    private int customerId;
}
