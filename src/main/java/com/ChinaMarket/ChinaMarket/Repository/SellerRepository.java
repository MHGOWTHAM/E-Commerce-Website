package com.ChinaMarket.ChinaMarket.Repository;

import com.ChinaMarket.ChinaMarket.Model.Seller;
import com.ChinaMarket.ChinaMarket.RequestDTO.SellerGetAllRequestDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.SellerGetAllResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {

    //Seller findByPan(String panNo);

  // List<SellerGetAllResponseDto> getAllSeller();
}
