package com.example.Rikkeibb3.repository;

import com.example.Rikkeibb3.model.Enrollment;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EnrollmentRepository {
    private List<Enrollment> enrollments = new ArrayList<>();

    public EnrollmentRepository() {
        enrollments.add(new Enrollment(1, "Hoc Vien A", 1));
        enrollments.add(new Enrollment(2, "Hoc Vien B", 2));
    }

    public List<Enrollment> findAll() { return enrollments; }

    public Enrollment findById(int id) {
        return enrollments.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public Enrollment create(Enrollment enrollment) {
        enrollments.add(enrollment);
        return enrollment;
    }

    public Enrollment update(int id, Enrollment updated) {
        for (Enrollment e : enrollments) {
            if (e.getId() == id) {
                e.setStudentName(updated.getStudentName());
                e.setCourseId(updated.getCourseId());
                return e;
            }
        }
        return null;
    }

    public boolean deleteById(int id) {
        return enrollments.removeIf(e -> e.getId() == id);
    }
}