package com.ecommerce_backend.Entity;

import com.ecommerce_backend.Enum.ERole;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private ERole name;


    public Role() {

    }

    public Role(ERole name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }


    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
