package com.plant_eshop_backend.dto;

import com.plant_eshop_backend.entity.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import java.util.List;
@Getter
@Setter
public class ProductDto {
    private String productId;

    private String catagoryName;

    private String productName;

    private Double basePrice;


    private String productDesc;


    private String productRating;

    private String productQuantity;

    private AvailabilityStatus availabilityStatus;


    private Category category;



    private List<ProductSizeDto> productSizes;


    private List<ProductColorDto> productColors;


    private List<ProductImageDto> productImages;
}
