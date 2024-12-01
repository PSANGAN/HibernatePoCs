package org.example.entites.jpql;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="view_simple_student")
public class DistinctStudent {

    @Id
    private Integer id;

    private  String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DistinctStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
