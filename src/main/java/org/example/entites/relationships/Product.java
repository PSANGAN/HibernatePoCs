package org.example.entites.relationships;

import jakarta.persistence.*;

@Entity
// Separate Table for each class (Parent/Children(s))
// When we want to query children table then we need to use JOIN clause with Parent.
@Inheritance(strategy =InheritanceType.JOINED)

// abstract is optional; caution - Cannot create instance for Product!
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
