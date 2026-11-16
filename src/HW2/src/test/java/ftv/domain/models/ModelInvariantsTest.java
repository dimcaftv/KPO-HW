package ftv.domain.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ModelInvariantsTest {
    @Test
    void studentRejectsBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new Student("  "));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void criterionRejectsNonPositiveMaxScore(int maxScore) {
        assertThrows(IllegalArgumentException.class,
                () -> new Criterion(new CriterionId("Exam"), maxScore, 1.0));
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.0, -0.5})
    void criterionRejectsNonPositiveWeight(double weight) {
        assertThrows(IllegalArgumentException.class,
                () -> new Criterion(new CriterionId("Exam"), 10, weight));
    }

    @Test
    void criterionRejectsBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new Criterion(new CriterionId(" "), 10, 1.0));
    }

    @Test
    void rubricatorRejectsDuplicateCriterion() {
        Rubricator rubricator = new Rubricator();
        Criterion criterion = new Criterion(new CriterionId("Exam"), 10, 1.0);
        rubricator.addCriterion(criterion);

        assertThrows(IllegalArgumentException.class, () -> rubricator.addCriterion(criterion));
        assertEquals(1, rubricator.getSize());
    }
}
