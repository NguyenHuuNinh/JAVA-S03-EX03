package com.example.Rikkeibb3.service;

import com.example.Rikkeibb3.model.Instructor;
import com.example.Rikkeibb3.repository.InstructorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InstructorService {
    private final InstructorRepository repo;

    public InstructorService(InstructorRepository repo) { this.repo = repo; }

    public List<Instructor> getAllInstructors() { return repo.findAll(); }
    public Instructor getInstructorById(int id) { return repo.findById(id); }
    public Instructor createInstructor(Instructor instructor) { return repo.create(instructor); }
    public Instructor updateInstructor(int id, Instructor instructor) { return repo.update(id, instructor); }
    public Instructor deleteInstructorById(int id) {
        Instructor i = repo.findById(id);
        if (i != null) { repo.deleteById(id); return i; }
        return null;
    }
}