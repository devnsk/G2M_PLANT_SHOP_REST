package com.plant_eshop_backend.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.UUID;

@Entity
@Getter
@Setter
public class ProductSize {

    @Id
    private String p_SizeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "size_id")
    private Size size;



    @PrePersist
    public void prePersist() {
        if (this.p_SizeId == null) {
            this.p_SizeId = "PSIZ-" + UUID.randomUUID().toString().replace("-", "").substring(0, 6).toUpperCase();;
        }
    }
}
