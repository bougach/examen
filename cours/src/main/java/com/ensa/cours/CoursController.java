package com.ensa.cours;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cours")
@RequiredArgsConstructor
public class CoursController {

    private final CoursService service;

    @PostMapping("saveCours")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody Cours cours
    ) {
        service.saveCours(cours);
    }

    @GetMapping("allcours")
    public ResponseEntity<List<Cours>> findAll() {
        return ResponseEntity.ok(service.findAllCours());
    }

    @GetMapping("/student-cours/{cours-id}")
    public ResponseEntity<FullSchoolResponse> findAllCours(
            @PathVariable("cours-id") Integer coursId
    ) {
        return ResponseEntity.ok(service.findCoursStudent(coursId));
    }
}
