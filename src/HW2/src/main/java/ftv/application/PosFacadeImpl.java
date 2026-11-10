package ftv.application;

import ftv.domain.models.*;

import java.util.List;

public class PosFacadeImpl implements IPosFacade {
    @Override
    public void addStudent(Student student) {

    }

    @Override
    public void addCriterion(Criterion criterion) {

    }

    @Override
    public List<Student> getStudents() {
        return List.of();
    }

    @Override
    public List<Criterion> getCriterions() {
        return List.of();
    }

    @Override
    public void evaluateStudent(StudentId student_id, CriterionId criterion_id, Integer score) {

    }

    @Override
    public List<Evaluation> getEvaluations(StudentId student_id) {
        return List.of();
    }

    @Override
    public Result getResult(StudentId student_id) {
        return null;
    }

    @Override
    public void exportResults() {

    }
}
