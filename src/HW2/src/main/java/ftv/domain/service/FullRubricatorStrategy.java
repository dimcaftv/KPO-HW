package ftv.domain.service;

import ftv.domain.models.Criterion;
import ftv.domain.models.Evaluation;
import ftv.domain.models.Rubricator;

import java.util.List;

public class FullRubricatorStrategy implements IResultStrategy {
    @Override
    public double calculate(List<Evaluation> evaluations, Rubricator rubricator) {
        double res = 0;
        for (Evaluation evaluation : evaluations) {
            Criterion criterion = rubricator.getCriterion(evaluation.criterionId());
            res += evaluation.score() * criterion.weight() / criterion.maxScore();
        }
        res /= rubricator.getSize();
        return res;
    }
}
