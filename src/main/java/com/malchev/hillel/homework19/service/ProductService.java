package com.malchev.hillel.homework19.service;

import com.malchev.hillel.homework19.domain.dto.ProductReqDTO;
import com.malchev.hillel.homework19.domain.dto.ProductRespDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    Optional<ProductRespDTO> getProductById(String productId);
    List<ProductRespDTO> getProducts();
    Optional<ProductRespDTO> createProduct(ProductReqDTO productReqDTO);
    boolean deleteProduct(String productId);
}
