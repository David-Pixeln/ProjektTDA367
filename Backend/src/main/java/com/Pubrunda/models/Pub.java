package com.Pubrunda.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;


@Entity
@Getter
@RequiredArgsConstructor''
@NoArgsConstructor
public class Pub {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NonNull
    @Setter
    private String name;

    @Setter
    private LocalTime openingTime;

    @Setter
    private LocalTime closingTime;

    @Setter
    private LocalDateTime lastUpdatedTime;

    public Pub(String name, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

}
