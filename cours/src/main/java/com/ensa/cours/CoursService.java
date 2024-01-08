package com.ensa.cours;

import com.ensa.cours.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final CoursRepository repository;
    private final StudentClient client;

    public void saveCours(Cours cours) {
        repository.save(cours);
    }

    public List<Cours> findAllCours() {
        return repository.findAll();
    }

    public CoursResponse findCoursStudent(Integer coursId) {
        var cours = repository.findById(coursId)
                .orElse(
                        Cours.builder()
                                .coursName("ther is no  cours  whith that name")
                                .build()
                );
        var students = client.findAllStudentWithSameCours(coursId);
        return CoursResponse.builder()
                .name(cours.getName())
                .students(students)
                .build();
    }
}
