package ftv.infrastructure.repositories;

import ftv.domain.models.Student;
import ftv.domain.models.StudentId;
import ftv.domain.repositories.IStudentRepository;

import java.util.List;
import java.util.Optional;

public class InMemoryStudentRepository implements IStudentRepository {
    @Override
    public void save(Student student) {

    }

    @Override
    public Optional<Student> findById(StudentId id) {
        return Optional.empty();
    }

    @Override
    public List<Student> findAll() {
        return List.of();
    }
}
