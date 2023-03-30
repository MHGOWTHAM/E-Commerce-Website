package com.ChinaMarket.ChinaMarket.Service;

import com.ChinaMarket.ChinaMarket.Enum.ProductStatus;
import com.ChinaMarket.ChinaMarket.Exception.CustomerNotFoundException;
import com.ChinaMarket.ChinaMarket.Exception.InsufficientQuantityException;
import com.ChinaMarket.ChinaMarket.Exception.ProductNotFoundException;
import com.ChinaMarket.ChinaMarket.Model.*;
import com.ChinaMarket.ChinaMarket.Repository.CustomerRepository;
import com.ChinaMarket.ChinaMarket.Repository.OrderedRepository;
import com.ChinaMarket.ChinaMarket.Repository.ProductRepository;
import com.ChinaMarket.ChinaMarket.RequestDTO.OrderRequestDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.ItemResponseDto;
import com.ChinaMarket.ChinaMarket.ResponseDTO.OrderResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderedService {
    @Autowired
    ItemService itemService;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;

    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws CustomerNotFoundException, ProductNotFoundException, InsufficientQuantityException {
        Customer customer;
        try{
            customer=customerRepository.findById(orderRequestDto.getCustomerId()).get();
        }
        catch (Exception e){
            throw new CustomerNotFoundException("Invalid Customer Id");
        }
        Product product;
        try{
            product=productRepository.findById(orderRequestDto.getProductId()).get();
        }
        catch (Exception e){
            throw new ProductNotFoundException("Invalid Product Id");
        }
        if(product.getQuantity()<orderRequestDto.getRequiredQuantity()){
            throw new InsufficientQuantityException("Required Quantity not available");
        }

        //View the item first
//        ItemResponseDto itemResponseDto=itemService.viewItem(orderRequestDto.getProductId());
//        Item item=product.getItem();

        //prepare order
//        int totalCost=;
//        int deliveryCharge=0;
//        if(totalCost<500){
//            deliveryCharge=50;
//            totalCost+=deliveryCharge;
//        }
        Ordered ordered=new Ordered();
        ordered.setTotalCost(orderRequestDto.getRequiredQuantity()*product.getPrice());
        ordered.setDeliveryCharge(40);

        //prepare card String
        Card card=customer.getCards().get(0);
        int cardLength=card.getCardNo().length();
        String cardNo="";
        for(int i=0;i<cardLength-4;i++){
            cardNo+='X';
        }
        cardNo+=card.getCardNo().substring(cardLength-4);
        ordered.setCardUsedForPayment(cardNo);

        Item item= new Item();
        item.setRequiredQuantity(orderRequestDto.getRequiredQuantity());
        item.setProduct(product);
        item.setOrder(ordered);
        ordered.getItems().add(item);
        ordered.setCustomer(customer);

       //update the quantity of product left in warehouse
        int leftQuantity=product.getQuantity()-orderRequestDto.getRequiredQuantity();
        if(leftQuantity<=0)
            product.setProductStatus(ProductStatus.OUT_OF_STOCK);
        product.setQuantity(leftQuantity);

        //update customer's current order list
        customer.getOrders().add(ordered);

        //save the customer
        Customer savedCustomer= customerRepository.save(customer);
        Ordered savedOrder=savedCustomer.getOrders().get(savedCustomer.getOrders().size()-1);


        //prepare response Dto
        OrderResponseDto orderResponseDto=OrderResponseDto.builder()
                .productName(product.getProductName())
                .itemPrice(product.getPrice())
                .quantityOrdered(orderRequestDto.getRequiredQuantity())
                .orderDate(savedOrder.getOrderDate())
                .totalCost(ordered.getTotalCost())
                .deliveryCharge(40)
                .cardUsedForPayment(cardNo)
                .build();

        return  orderResponseDto;
    }
}
