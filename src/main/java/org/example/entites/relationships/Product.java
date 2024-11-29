package org.example.entites.relationships;

import jakarta.persistence.*;

@Entity
// Each Child has own Table with its own and parent properties
// If we want to know any one of the children table values then UNION query
// will be generated
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)

// abstract is optional; caution - Cannot create instance for Product!
public abstract class Product {
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
