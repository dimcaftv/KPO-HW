package ftv.domain.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rubricator {
    private final Map<CriterionId, Criterion> criteria = new HashMap<>();

    public void addCriterion(Criterion criterion) {
        if (criteria.containsKey(criterion.id()))
            throw new IllegalArgumentException("Criterion already exists: " + criterion.id());

        criteria.put(criterion.id(), criterion);
    }

    public Criterion getCriterion(CriterionId name) {
        return criteria.get(name);
    }

    public List<Criterion> getCriterions() {
        return criteria.values().stream().toList();
    }

    public int getSize() {
        return criteria.size();
    }

    public void validateEvaluation(CriterionId criterionId, int score) {
        Criterion criterion = criteria.get(criterionId);
        if (criterion == null)
            throw new IllegalArgumentException("Criterion not found in rubricator: " + criterionId.name());
        if (score < 0 || score > criterion.maxScore())
            throw new IllegalArgumentException("Score out of range: " + score);
    }
}
