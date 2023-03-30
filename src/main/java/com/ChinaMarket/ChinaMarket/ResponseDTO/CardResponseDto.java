package com.ChinaMarket.ChinaMarket.ResponseDTO;

import com.ChinaMarket.ChinaMarket.RequestDTO.CardDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardResponseDto {

    private String name;

    List<CardDto> cardDtos;
}
