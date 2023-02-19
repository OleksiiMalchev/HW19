package com.malchev.hillel.homework19.service.impl;

import com.malchev.hillel.homework19.domain.dto.ProductReqDTO;
import com.malchev.hillel.homework19.domain.dto.ProductRespDTO;
import com.malchev.hillel.homework19.mapper.ProductMapper;
import com.malchev.hillel.homework19.repository.ProductRepository;
import com.malchev.hillel.homework19.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public Optional<ProductRespDTO> getProductById(String productId) {
        return productRepository.findById(productId).map(productMapper::productRespDTO);
    }

    @Override
    public List<ProductRespDTO> getProducts() {
        return productRepository.findAll().stream().map(productMapper::productRespDTO).toList();
    }

    @Override
    public Optional<ProductRespDTO> createProduct(ProductReqDTO productReqDTO) {
        return productMapper.reqDTOProduct(productReqDTO)
                .map(productRepository::save)
                .map(productMapper::productRespDTO);
    }

    @Override
    public boolean deleteProduct(String productId) {
        if (productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
            return true;
        }
        return false;
    }
}
