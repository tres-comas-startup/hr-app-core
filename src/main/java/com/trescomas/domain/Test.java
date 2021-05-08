package com.trescomas.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Test")
@Data
public class Test {
    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false)
    String name;
}
