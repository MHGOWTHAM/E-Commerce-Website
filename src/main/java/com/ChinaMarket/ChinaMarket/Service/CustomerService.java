package com.ChinaMarket.ChinaMarket.Service;

import com.ChinaMarket.ChinaMarket.Convertor.CustomerConvertor;
import com.ChinaMarket.ChinaMarket.Model.Cart;
import com.ChinaMarket.ChinaMarket.Model.Customer;
import com.ChinaMarket.ChinaMarket.Repository.CustomerRepository;
import com.ChinaMarket.ChinaMarket.RequestDTO.CustomerRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public String addCutomer(CustomerRequestDto customerRequestDto) {
            Customer customer = CustomerConvertor.customerRequestDtoToCustomer(customerRequestDto);

            //allocate a cart to customer
            Cart cart=new Cart();
            cart.setCartTotal(0);
            cart.setCustomer(customer);

            //set cart in customer
            customer.setCart(cart);

            customerRepository.save(customer);

            return "Congrats!!! . Your customer added successfully";
    }
}
