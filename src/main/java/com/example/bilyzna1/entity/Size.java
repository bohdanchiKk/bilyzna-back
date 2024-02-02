package com.example.bilyzna1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

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
    private Clothes clothes;
    @Column(name = "size")
    private String size;

}
