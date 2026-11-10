package ftv.application;

import ftv.domain.models.*;

import java.util.List;

public interface IPosFacade {
    void addStudent(Student student);

    void addCriterion(Criterion criterion);

    List<Student> getStudents();

    List<Criterion> getCriterions();

    Evaluation evaluateStudent(StudentId studentId, CriterionId criterionId, int score);

    void correctEvaluation(EvaluationId evaluationId, int newScore);

    void removeEvaluation(EvaluationId evaluationId);

    List<Evaluation> getEvaluations(StudentId studentId);

    Result getResult(StudentId studentId);

    void exportResults();
}
