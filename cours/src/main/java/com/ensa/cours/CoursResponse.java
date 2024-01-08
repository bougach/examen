package com.ensa.cours;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CoursResponse {

    private String coursName;
    List<Student> students;
}
