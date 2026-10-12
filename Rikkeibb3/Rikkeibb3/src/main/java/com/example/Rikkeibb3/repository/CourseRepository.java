package com.example.Rikkeib3.repository;

import com.example.Rikkeibb3.model.Course;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        courses.add(new Course(1, "Java Core", "ACTIVE", 1));
    }

    public List<Course> findAll() { return courses; }
    public Course findById(int id) {
        return courses.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }
    public Course create(Course course) { courses.add(course); return course; }
    public Course update(int id, Course updated) {
        for (Course c : courses) {
            if (c.getId() == id) {
                c.setTitle(updated.getTitle()); c.setStatus(updated.getStatus()); c.setInstructorId(updated.getInstructorId());
                return c;
            }
        }
        return null;
    }
    public boolean deleteById(int id) { return courses.removeIf(c -> c.getId() == id); }
}