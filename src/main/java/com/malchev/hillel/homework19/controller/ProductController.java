package com.malchev.hillel.homework19.controller;

import com.malchev.hillel.homework19.domain.dto.ProductReqDTO;
import com.malchev.hillel.homework19.domain.dto.ProductRespDTO;
import com.malchev.hillel.homework19.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @GetMapping("/products")
    public ResponseEntity<? super List<ProductRespDTO>> getProducts() {
        List<ProductRespDTO> products = productService.getProducts();
        if (products.isEmpty()) {
            return new ResponseEntity<>("Products not found ", HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.status(200).body(products);
        }
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<? super ProductRespDTO> getProductById(@PathVariable("id") String productId) {
        Optional<ProductRespDTO> productById = productService.getProductById(productId);
        if (productById.isPresent()) {
            return ResponseEntity.status(200).body(productById);
        } else {
            return new ResponseEntity<>("Product by id" + productId + " not found. No action taken.",
                    HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/products")
    public ResponseEntity<? super ProductRespDTO> createProduct(@RequestBody ProductReqDTO productReqDTO) {
        if (productReqDTO != null) {
            Optional<ProductRespDTO> product = productService.createProduct(productReqDTO);
            return ResponseEntity.status(201).body(product);
        } else {
            return new ResponseEntity<>("Product not create. No action taken.", HttpStatus.BAD_REQUEST);
        }
    }
}
