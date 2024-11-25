package org.example.entites;

import jakarta.persistence.*;
import org.example.id.generators.UUIDGenerator;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "EmployeeTbl")
public class Employee {
    @Id
    @GeneratedValue(generator = "UUIDGenerator") // Like SQL server Identity...
    @GenericGenerator(name="UUIDGenerator", type = UUIDGenerator.class) // Deprecated
    private String id;
    private String name;
    private String Address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }
}
