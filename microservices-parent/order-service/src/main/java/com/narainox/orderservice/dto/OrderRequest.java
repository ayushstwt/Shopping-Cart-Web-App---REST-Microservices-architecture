package com.narainox.orderservice.dto;

import com.narainox.orderservice.model.OrderLineItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {
    private List<OrderLineItemsDto> orderLineItemsLine=new ArrayList<>();
}
