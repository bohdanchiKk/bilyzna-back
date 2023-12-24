package com.example.bilyzna1.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "uniqueclothes")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class SearchItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String image;
    @Column
    @CreationTimestamp
    private LocalDateTime createdOn;
}
