package ftv.domain.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rubricator {
    private final Map<CriterionId, Criterion> criteria = new HashMap<>();

    public void addCriterion(Criterion criterion) {
        if (criteria.containsKey(criterion.id())) {
            throw new IllegalArgumentException("Criterion already exists: " + criterion.id());
        }
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
}
