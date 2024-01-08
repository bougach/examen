package com.ensa.school;

import com.ensa.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;
    private final StudentClient client;

    public void saveCourse(Course course) {
        repository.save(course);
    }

    public List<Course> findAllCourses() {
        return repository.findAll();
    }

    public FullCourseResponse findCoursesWithStudents(String courseId) {
        var school = repository.findById(UUID.fromString(courseId))
                .orElse(
                        Course.builder()
                                .name("NOT_FOUND")
                                .build()
                );
        var students = client.findAllStudentWithSameCours(courseId);
        return FullCourseResponse.builder()
                .name(school.getName())
                .students(students)
                .build();
    }
}
