package com.example.Rikkeibb3.controller;

import com.example.Rikkeibb3.dto.ApiResponse;
import com.example.Rikkeibb3.model.Instructor;
import com.example.Rikkeibb3.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    private final InstructorService service;

    public InstructorController(InstructorService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>> getAllInstructors() {
        List<Instructor> list = service.getAllInstructors();
        return ResponseEntity.ok(new ApiResponse<>(true, "Fetched instructors successfully", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> getInstructorById(@PathVariable int id) {
        Instructor data = service.getInstructorById(id);
        if (data != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Fetched instructor successfully", data));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Instructor not found", null));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> createInstructor(@RequestBody Instructor instructor) {
        Instructor created = service.createInstructor(instructor);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "Instructor created successfully", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructor(@PathVariable int id, @RequestBody Instructor instructor) {
        Instructor updated = service.updateInstructor(id, instructor);
        if (updated != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Instructor updated successfully", updated));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Instructor not found for update", null));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Instructor>> deleteInstructorById(@PathVariable int id) {
        Instructor deleted = service.deleteInstructorById(id);
        if (deleted != null) {
            return ResponseEntity.ok(new ApiResponse<>(true, "Instructor deleted successfully", deleted));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse<>(false, "Instructor not found for deletion", null));
    }
}