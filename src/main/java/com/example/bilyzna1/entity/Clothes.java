package com.example.bilyzna1.entity;

import com.example.bilyzna1.Type;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @OneToMany(mappedBy = "clothes",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @BatchSize(size = 100)
    private List<Size> size = new ArrayList<>();
    @Column(name = "description", length = 1000)
    private String description;
    @Column(name = "additionaltype")
    private String additionaltype;
    @OneToMany(mappedBy = "clothes",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @BatchSize(size = 100)
    private List<Image> images = new ArrayList<>();
    @Column(name = "date")
    @CreationTimestamp
    private LocalDateTime createdOn;
}
