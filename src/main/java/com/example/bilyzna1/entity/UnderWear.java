package com.example.bilyzna1.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name ="emptybilyzna")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class UnderWear {
    @Id
    @GeneratedValue
    public Long id;
    @Column( name = "title")
    public String title;
    @Column( name = "price")
    public int price;
    @Column( name = "quantity")
    public int quantity;
    @Column( name = "description")
    public String description;
    @Column(name = "img")
    public String img;
}
