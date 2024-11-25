package org.example.entites;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import org.example.id.generators.keys.ProductKey;

@Entity
@IdClass(ProductKey.class)
public class ProductTbl {

    @Id
    private String code;
    @Id
    private long number;
    private String Color;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    @Override
    public String toString() {
        return "ProductTbl{" +
                "code='" + code + '\'' +
                ", number=" + number +
                ", Color='" + Color + '\'' +
                '}';
    }
}
