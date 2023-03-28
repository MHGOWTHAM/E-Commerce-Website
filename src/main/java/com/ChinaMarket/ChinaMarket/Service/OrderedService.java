package com.ChinaMarket.ChinaMarket.Service;

import com.ChinaMarket.ChinaMarket.Repository.OrderedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderedService {
    @Autowired
    OrderedRepository orderedRepository;
}
