package com.malchev.hillel.homework19.domain.dto;

import lombok.Data;

@Data
public class ProductReqDTO {
    private String productId;
    private String name;
    private Long cost;
}
