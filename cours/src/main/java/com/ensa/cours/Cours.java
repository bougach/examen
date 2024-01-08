package com.ensa.cours;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cours {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String coursName;
}
