package ftv.domain.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Rubricator {
    private final Map<CriterionId, Criterion> criteria = new HashMap<>();

    public void addCriterion(CriterionId name, Criterion criterion) {
        if (criteria.containsKey(name)) throw new IllegalArgumentException("Duplicate criterion name");
        criteria.put(name, criterion);
    }

    public Criterion getCriterion(CriterionId name) {
        return criteria.get(name);
    }

    public List<Criterion> getCriterions() {
        return criteria.values().stream().toList();
    }

    public Integer getSize() {
        return criteria.size();
    }
}
