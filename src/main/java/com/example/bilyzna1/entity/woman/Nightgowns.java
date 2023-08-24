package com.example.bilyzna1.entity.woman;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@Table(name = "nightgowns")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Nightgowns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "brand", nullable = false)
    private String brand;
    @Column(name = "article")
    private String article;
    @Column(name = "amount")
    private String amount;
    @Column(name = "price")
    private int price;
    @Column(name = "type")
    private String type;
    @Column(name = "size")
    private String size;
    @Column(name = "description", length = 1000)
    private String description;
    @Column(name = "image1")
    private String image1;
    @Column(name = "image2")
    private String image2;
    @Column(name = "date")
    private Date createdOn;
}
