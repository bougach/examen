package com.ensa.cours;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private String firstname;
    private String lastname;
    private String email;
    private String codeMassar;
}
