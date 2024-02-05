package com.example.bilyzna1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.BatchSize;

@Entity
@Table(name = "sizes")
@Data
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clothes_id")
    @JsonIgnore
    @BatchSize(size = 100)
    private Clothes clothes;
    @Column(name = "size")
    private String size;

}
