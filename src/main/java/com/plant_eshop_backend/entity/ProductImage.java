package com.plant_eshop_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Getter
@Setter
public class ProductImage {
    @Id
    private String imageId;
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;


    @PrePersist
    public void prePersist() {
        if (this.imageId == null) {
            this.imageId = "IMG-" + UUID.randomUUID().toString().replace("-", "").substring(0, 6).toUpperCase();;
        }
    }

}
