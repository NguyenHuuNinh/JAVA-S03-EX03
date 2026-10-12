package com.example.Rikkeibb3.service;

import com.example.Rikkeibb3.model.Course;
import com.example.Rikkeib3.repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository repo;

    public CourseService(CourseRepository repo) { this.repo = repo; }

    public List<Course> getAllCourses() { return repo.findAll(); }
    public Course getCourseById(int id) { return repo.findById(id); }
    public Course createCourse(Course course) { return repo.create(course); }
    public Course updateCourse(int id, Course course) { return repo.update(id, course); }
    public Course deleteCourseById(int id) {
        Course c = repo.findById(id);
        if (c != null) { repo.deleteById(id); return c; }
        return null;
    }
}