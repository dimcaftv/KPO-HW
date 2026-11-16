package ftv.domain.models;

public record Criterion(CriterionId id, int maxScore, double weight) {
    public Criterion {
        if (id == null || id.name() == null || id.name().isBlank()) {
            throw new IllegalArgumentException("Criterion name is empty");
        }
        if (maxScore <= 0) {
            throw new IllegalArgumentException("Max score must be positive");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be positive");
        }
    }
}
