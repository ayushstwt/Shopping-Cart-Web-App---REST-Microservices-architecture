package com.narainox.orderservice.service;

import com.narainox.orderservice.dto.OrderLineItemsDto;
import com.narainox.orderservice.dto.OrderRequest;
import com.narainox.orderservice.model.Order;
import com.narainox.orderservice.model.OrderLineItems;
import com.narainox.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest)
    {
        Order order=new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> items = orderRequest.getOrderLineItemsLine()
                .stream()
                .map(this:: mapToDto).toList();

        order.setOrderLineItemsList(items);
        orderRepository.save(order);
    }
    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto)
    {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setId(orderLineItemsDto.getId());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
