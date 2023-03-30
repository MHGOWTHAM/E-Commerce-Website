package com.ChinaMarket.ChinaMarket.Controller;

import com.ChinaMarket.ChinaMarket.RequestDTO.OrderRequestDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.OrderResponseDto;
import com.ChinaMarket.ChinaMarket.Service.OrderedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderedController {
    @Autowired
    OrderedService orderedService;

    @PostMapping("/place")
    public ResponseEntity place(@RequestBody OrderRequestDto orderRequestDto){
        OrderResponseDto orderResponseDto;
        try{
            orderResponseDto=orderedService.placeOrder(orderRequestDto);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_GATEWAY);
        }
            return new ResponseEntity(orderResponseDto, HttpStatus.ACCEPTED);
    }
}
