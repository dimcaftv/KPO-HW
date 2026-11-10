package ftv.domain.repositories;

import ftv.domain.models.Student;
import ftv.domain.models.StudentId;

import java.util.List;
import java.util.Optional;

public interface IStudentRepository {
    void save(Student student);

    Optional<Student> findById(StudentId id);

    List<Student> findAll();
}
