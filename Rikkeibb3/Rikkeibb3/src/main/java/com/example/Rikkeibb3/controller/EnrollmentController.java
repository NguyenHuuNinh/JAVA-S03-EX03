package com.example.Rikkeibb3.controller;

import com.example.Rikkeibb3.dto.ApiResponse;
import com.example.Rikkeibb3.model.Enrollment;
import com.example.Rikkeibb3.service.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    private final EnrollmentService service;

    public EnrollmentController(EnrollmentService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Enrollment>>> getAllEnrollments() {
        List<Enrollment> list = service.getAllEnrollments();
        return ResponseEntity.ok(new ApiResponse<>(true, "Fetched enrollments successfully", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> getEnrollmentById(@PathVariable int id) {
        Enrollment data = service.getEnrollmentById(id);
        if (data != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Fetched enrollment successfully", data));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Enrollment not found", null));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Enrollment>> createEnrollment(@RequestBody Enrollment enrollment) {
        Enrollment created = service.createEnrollment(enrollment);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "Enrollment created successfully", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> updateEnrollment(@PathVariable int id, @RequestBody Enrollment enrollment) {
        Enrollment updated = service.updateEnrollment(id, enrollment);
        if (updated != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Enrollment updated successfully", updated));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Enrollment not found for update", null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Enrollment>> deleteEnrollmentById(@PathVariable int id) {
        Enrollment deleted = service.deleteEnrollmentById(id);
        if (deleted != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Enrollment deleted successfully", deleted));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Enrollment not found for deletion", null));
    }
}