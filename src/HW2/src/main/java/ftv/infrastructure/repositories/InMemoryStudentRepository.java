package ftv.infrastructure.repositories;

import ftv.domain.models.Student;
import ftv.domain.models.StudentId;
import ftv.domain.repositories.IStudentRepository;

import java.util.*;

public class InMemoryStudentRepository implements IStudentRepository {
    private final Map<StudentId, Student> students = new HashMap<>();

    @Override
    public void save(Student student) {
        students.put(student.id(), student);
    }

    @Override
    public Optional<Student> findById(StudentId id) {
        return Optional.ofNullable(students.get(id));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }
}
