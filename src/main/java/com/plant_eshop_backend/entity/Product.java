package com.plant_eshop_backend.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @Column(name = "Pid")
    private String productId;

    private String productName;

    private Double basePrice;

    @Column(name = "Description")
    private String productDesc;

    @Column(name = "Rating")
    private String productRating;

    private String productQuantity;

    @Enumerated(EnumType.STRING)
    private AvailabilityStatus availabilityStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductSize> productSizes;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductColor> productColors;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProductImage> productImages;


    @PrePersist
    public void prePersist() {
        if (this.productId == null) {
            this.productId = "PRO-"+ UUID.randomUUID().toString().replace("-", "").substring(0, 6).toUpperCase();
        }
    }

}
