package ftv.domain.models;

public record Evaluation(EvaluationId id, StudentId studentId, CriterionId criterionId, int score) {
    public Evaluation {
        if (id == null || studentId == null || criterionId == null)
            throw new IllegalArgumentException("Id is null");
        if (score < 0)
            throw new IllegalArgumentException("Negative score");
    }

    public Evaluation(StudentId student_id, CriterionId criterion_id, int score) {
        this(EvaluationId.generate(), student_id, criterion_id, score);
    }
}
