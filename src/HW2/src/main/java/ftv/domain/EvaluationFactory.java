package ftv.domain;

import ftv.domain.models.*;

public class EvaluationFactory {
    public Evaluation createEvaluation(Integer score, StudentId student_id, Criterion criterion, Rubricator rubricator) {
        if (score < 0 || score > criterion.max_score())
            throw new IllegalArgumentException("Score must be in range");

        if (rubricator.getCriterion(criterion.name()) == null)
            throw new IllegalArgumentException("Criterion not found");

        return new Evaluation(EvaluationId.generate(), student_id, criterion.name(), score);
    }
}
