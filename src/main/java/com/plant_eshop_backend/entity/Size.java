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
public class Size {

    @Id
    private String sizeId;

    private String sizeName;

    private Double sizePrice;



    @OneToMany(mappedBy = "size", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ProductSize> productSizes;

    @PrePersist
    public void prePersist() {
        if (this.sizeId == null) {
            this.sizeId = "SIZ-" + UUID.randomUUID().toString().replace("-", "").substring(0, 6).toUpperCase();;
        }
    }


}
