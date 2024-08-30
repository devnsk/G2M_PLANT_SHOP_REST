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
public class ProductColor {

    @Id
    private String p_colorId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "color_id")
    private Color color;




    @PrePersist
    public void prePersist() {
        if (this.p_colorId == null) {
            this.p_colorId = "PCOL-" + UUID.randomUUID().toString().replace("-", "").substring(0, 6).toUpperCase();;
        }
    }
}
