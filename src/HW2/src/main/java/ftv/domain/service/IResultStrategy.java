package ftv.domain.service;

import ftv.domain.models.Evaluation;
import ftv.domain.models.Rubricator;

import java.util.List;

public interface IResultStrategy {
    CalculationMode mode();

    double calculate(List<Evaluation> evaluations, Rubricator rubricator);
}
