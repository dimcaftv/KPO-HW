package ftv.application;

import ftv.domain.models.*;

import java.util.List;

public interface IPosFacade {
    void addStudent(Student student);

    void addCriterion(Criterion criterion);

    List<Student> getStudents();

    List<Criterion> getCriterions();

    void evaluateStudent(StudentId student_id, CriterionId criterion_id, Integer score);

    List<Evaluation> getEvaluations(StudentId student_id);

    Result getResult(StudentId student_id);

    void exportResults();
}
