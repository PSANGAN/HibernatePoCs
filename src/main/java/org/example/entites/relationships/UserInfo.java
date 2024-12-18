package org.example.entites.relationships;

import jakarta.persistence.*;

@Entity
@SecondaryTable(
        name = "user_details",
        pkJoinColumns = @PrimaryKeyJoinColumn(name="id")
)
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(table = "user_details")
    private String description;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
