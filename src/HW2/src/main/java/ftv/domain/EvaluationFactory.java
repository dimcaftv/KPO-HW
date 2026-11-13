package ftv.domain;

import ftv.domain.models.*;

public class EvaluationFactory {
    public Evaluation createEvaluation(StudentId studentId, CriterionId criterionId, int score, Rubricator rubricator) {
        Criterion criterion = rubricator.getCriterion(criterionId);
        validate(criterion, rubricator, score);
        return new Evaluation(studentId, criterion.id(), score);
    }

    public Evaluation correct(Evaluation evaluation, int newScore, Rubricator rubricator) {
        Criterion criterion = rubricator.getCriterion(evaluation.criterionId());
        validate(criterion, rubricator, newScore);

        return new Evaluation(evaluation.id(), evaluation.studentId(), criterion.id(), newScore);
    }

    void validate(Criterion criterion, Rubricator rubricator, int score) {
        if (criterion == null || rubricator.getCriterion(criterion.id()) == null) {
            throw new IllegalArgumentException("Criterion not found in rubricator");
        }

        if (score < 0 || score > criterion.maxScore()) {
            throw new IllegalArgumentException("Score is out of range");
        }
    }
}
