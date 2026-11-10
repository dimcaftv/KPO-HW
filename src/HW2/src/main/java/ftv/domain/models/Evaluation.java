package ftv.domain.models;

public record Evaluation(EvaluationId id, StudentId student_id, CriterionId criterion_id, Integer score) {
    public Evaluation(StudentId student_id, CriterionId criterion_id, Integer score) {
        this(EvaluationId.generate(), student_id, criterion_id, score);
    }
}
