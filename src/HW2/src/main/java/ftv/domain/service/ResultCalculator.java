package ftv.domain.service;

import ftv.domain.models.Evaluation;
import ftv.domain.models.Result;
import ftv.domain.models.Rubricator;
import ftv.domain.models.StudentId;

import java.util.List;

public class ResultCalculator {
    public Result calculate(StudentId student_id, List<Evaluation> evaluations, Rubricator rubricator, IResultStrategy strategy) {
        return new Result(student_id, strategy.calculate(evaluations, rubricator));
    }
}
