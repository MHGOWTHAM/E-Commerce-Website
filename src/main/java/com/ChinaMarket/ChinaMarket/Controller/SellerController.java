package com.ChinaMarket.ChinaMarket.Controller;

import com.ChinaMarket.ChinaMarket.Model.Seller;
import com.ChinaMarket.ChinaMarket.RequestDTO.SellerAddRequestDto;
import com.ChinaMarket.ChinaMarket.RequestDTO.SellerGetAllRequestDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.SellerGetAllResponseDto;
import com.ChinaMarket.ChinaMarket.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")

public class SellerController {
    @Autowired
    SellerService sellerService;

    @PostMapping("/add")
    public String addSeller(@RequestBody SellerAddRequestDto sellerRequestDto){
        return sellerService.addSeller(sellerRequestDto);
    }

//    @GetMapping("/getAllSeller")
//    public List<SellerGetAllResponseDto> getListOfSeller(){
//        return sellerService.getAllTheSeller();
//    }
}
