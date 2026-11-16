package ftv.domain;

import ftv.domain.models.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EvaluationFactoryTest {
    private final EvaluationFactory factory = new EvaluationFactory();
    private final Rubricator rubricator = new Rubricator();

    private CriterionId addCriterion(String name, int maxScore) {
        CriterionId id = new CriterionId(name);
        rubricator.addCriterion(new Criterion(id, maxScore, 1.0));
        return id;
    }

    @Test
    void createsEvaluationWithScoreInsideRange() {
        CriterionId criterionId = addCriterion("Exam", 10);

        Evaluation evaluation = factory.createEvaluation(StudentId.generate(), criterionId, 10, rubricator);

        assertEquals(criterionId, evaluation.criterionId());
        assertEquals(10, evaluation.score());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    void rejectsScoreOutsideCriterionRange(int score) {
        CriterionId criterionId = addCriterion("Exam", 10);

        assertThrows(IllegalArgumentException.class,
                () -> factory.createEvaluation(StudentId.generate(), criterionId, score, rubricator));
    }

    @Test
    void rejectsCriterionMissingFromRubricator() {
        CriterionId missing = new CriterionId("Missing");

        assertThrows(IllegalArgumentException.class,
                () -> factory.createEvaluation(StudentId.generate(), missing, 1, rubricator));
    }

    @Test
    void correctKeepsIdentityAndChangesScore() {
        CriterionId criterionId = addCriterion("Exam", 10);
        Evaluation evaluation = factory.createEvaluation(StudentId.generate(), criterionId, 5, rubricator);

        Evaluation corrected = factory.correct(evaluation, 8, rubricator);

        assertEquals(evaluation.id(), corrected.id());
        assertEquals(evaluation.studentId(), corrected.studentId());
        assertEquals(8, corrected.score());
    }

    @Test
    void correctRejectsScoreOutsideCriterionRange() {
        CriterionId criterionId = addCriterion("Exam", 10);
        Evaluation evaluation = factory.createEvaluation(StudentId.generate(), criterionId, 5, rubricator);

        assertThrows(IllegalArgumentException.class, () -> factory.correct(evaluation, 11, rubricator));
    }
}
