package com.ensa.cours.client;

import com.ensa.cours.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "${application.config.students-url}")
public interface StudentClient {

    @GetMapping("/cours/{cours-id}")
    List<Student> findAllStudentWithSameCours(@PathVariable("cours-id") Integer coursId);
}
