package com.malchev.hillel.homework19.mapper;

import com.malchev.hillel.homework19.domain.Product;
import com.malchev.hillel.homework19.domain.dto.ProductReqDTO;
import com.malchev.hillel.homework19.domain.dto.ProductRespDTO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductMapper {
    public Optional<Product> reqDTOProduct(ProductReqDTO productReqDTO) {
        return Optional.of(productReqDTO)
                .map(p -> Product.builder().cost(p.getCost()).name(p.getName()).build());
    }

    public ProductRespDTO productRespDTO(Product product) {
        return ProductRespDTO.builder().cost(product.getCost()).name(product.getName()).productId(product.getId())
                .build();
    }
}
