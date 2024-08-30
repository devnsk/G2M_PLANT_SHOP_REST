package com.plant_eshop_backend.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Color {

    @Id
    private String colorId;

    private String colorName;

    private Double colorPrice;



    @OneToMany(mappedBy = "color", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ProductColor> productColors;

    @PrePersist
    public void prePersist() {
        if (this.colorId == null) {
            this.colorId = "COL-" + UUID.randomUUID().toString().replace("-", "").substring(0, 6).toUpperCase();;
        }
    }

    // Getters and Setters
}

