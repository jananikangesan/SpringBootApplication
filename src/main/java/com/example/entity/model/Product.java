package com.example.entity.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator ="system-uuid")
    @GenericGenerator(name="system-uuid", strategy="uuid2")
    private String id;
    private String name;
    private  String category;
    private String type;
    private String sector;
    private Double price;
    private String description;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{"+
                "id="+id+"\'"+
                "name="+name+"\'"+
                "type="+type+"\'"+
                "price="+price+"\'"+
                "category="+category+"\'"+
                "sector="+sector+"\'"+
                "description="+description+"\'"+
                "}";
    }
}
