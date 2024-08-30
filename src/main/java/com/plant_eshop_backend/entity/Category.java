package com.plant_eshop_backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @Column(name = "Cid")
    private String categoryId;

    private String categoryName;


    @PrePersist
    public void prePersist() {
        if (this.categoryId == null) {
            this.categoryId = "CAT-" + UUID.randomUUID().toString().replace("-", "").substring(0, 6).toUpperCase();;
        }
    }


}
