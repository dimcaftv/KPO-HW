package ftv.domain.service;

import ftv.domain.models.Evaluation;
import ftv.domain.models.Rubricator;

import java.util.List;

public class SimpleStrategy implements IResultStrategy {

    @Override
    public double calculate(List<Evaluation> evaluations, Rubricator rubricator) {
        double res = 0;
        for (Evaluation evaluation : evaluations) {
            res += evaluation.score() * rubricator.getCriterion(evaluation.criterion_id()).weight();
        }
        return res;
    }
}
