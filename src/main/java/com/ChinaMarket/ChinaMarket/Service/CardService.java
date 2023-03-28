package com.ChinaMarket.ChinaMarket.Service;

import com.ChinaMarket.ChinaMarket.Exception.CustomerNotFoundException;
import com.ChinaMarket.ChinaMarket.Model.Card;
import com.ChinaMarket.ChinaMarket.Model.Customer;
import com.ChinaMarket.ChinaMarket.Repository.CardRepository;
import com.ChinaMarket.ChinaMarket.Repository.CustomerRepository;
import com.ChinaMarket.ChinaMarket.RequestDTO.CardDto;
import com.ChinaMarket.ChinaMarket.RequestDTO.CardRequestDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.CardResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    CustomerRepository customerRepository;

    public  CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException{
        Customer customer;
        try {
            customer = customerRepository.findById(cardRequestDto.getCustomerId()).get();
        }
        catch(Exception e){
            throw new CustomerNotFoundException("Invalid Customer id");
        }

        //make a card object
        Card card=Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cvv(cardRequestDto.getCvv())
                .cardType(cardRequestDto.getCardType())
                .customer(customer)
                .build();

        //add the card in the list
        customer.getCards().add(card);
        customerRepository.save(customer);  //save both card and customer

        //prepare response Dto
        CardResponseDto cardResponseDto=new CardResponseDto();
        cardResponseDto.setName(customer.getName());
        List<CardDto> cardDtoList=new ArrayList<>();
        for(Card card1:customer.getCards()){
            CardDto cardDto=new CardDto();
            cardDto.setCardNo(card1.getCardNo());
            cardDto.setCardType(card1.getCardType());
            cardDtoList.add(cardDto);
        }
        cardResponseDto.setCardDtos(cardDtoList);
        return cardResponseDto;
    }
}
