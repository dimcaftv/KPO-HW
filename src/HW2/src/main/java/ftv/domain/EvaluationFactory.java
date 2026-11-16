package ftv.domain;

import ftv.domain.models.CriterionId;
import ftv.domain.models.Evaluation;
import ftv.domain.models.Rubricator;
import ftv.domain.models.StudentId;

public class EvaluationFactory {
    public Evaluation createEvaluation(StudentId studentId, CriterionId criterionId, int score, Rubricator rubricator) {
        rubricator.validateEvaluation(criterionId, score);
        return new Evaluation(studentId, criterionId, score);
    }

    public Evaluation correct(Evaluation evaluation, int newScore, Rubricator rubricator) {
        rubricator.validateEvaluation(evaluation.criterionId(), newScore);
        return new Evaluation(evaluation.id(), evaluation.studentId(), evaluation.criterionId(), newScore);
    }
}
