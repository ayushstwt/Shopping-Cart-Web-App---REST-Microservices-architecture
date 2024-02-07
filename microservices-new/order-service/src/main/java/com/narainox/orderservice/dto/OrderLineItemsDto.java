package com.narainox.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderLineItemsDto {
    private Integer id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;

}
