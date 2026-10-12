package com.example.Rikkeibb3.service;

import com.example.Rikkeibb3.model.Enrollment;
import com.example.Rikkeibb3.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository repo;

    public EnrollmentService(EnrollmentRepository repo) { this.repo = repo; }

    public List<Enrollment> getAllEnrollments() { return repo.findAll(); }
    public Enrollment getEnrollmentById(int id) { return repo.findById(id); }
    public Enrollment createEnrollment(Enrollment enrollment) { return repo.create(enrollment); }
    public Enrollment updateEnrollment(int id, Enrollment enrollment) { return repo.update(id, enrollment); }
    public Enrollment deleteEnrollmentById(int id) {
        Enrollment e = repo.findById(id);
        if (e != null) { repo.deleteById(id); return e; }
        return null;
    }
}