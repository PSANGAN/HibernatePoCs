package org.example.entites.relationships;

import jakarta.persistence.Entity;

@Entity
public class Device extends Product {
    private Integer voltage;

    public Integer getVoltage() {
        return voltage;
    }

    public void setVoltage(Integer voltage) {
        this.voltage = voltage;
    }
}
