package com.plant_eshop_backend.service;

import com.plant_eshop_backend.dto.ProductDto;
import com.plant_eshop_backend.dto.ProductResponse;


import java.util.List;

public interface ProductService {
    public ProductResponse saveProduct(ProductDto product);
    public List<ProductDto> getAllProduct();

    public ProductResponse getProductById(String pid);
}
