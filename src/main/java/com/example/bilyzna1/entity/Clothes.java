package com.example.bilyzna1.entity;

import com.example.bilyzna1.Type;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "clothes")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Clothes {
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
    private Type type;
    @Column(name = "size")
    private String size;
    @Column(name = "description", length = 1000)
    private String description;
    @Column(name = "additionaltype")
    private String additionaltype;
    @Column(name = "image1")
    private String image1;
    @Column(name = "image2")
    private String image2;
    @Column(name = "date")
    @CreationTimestamp
    private LocalDateTime createdOn;
}
