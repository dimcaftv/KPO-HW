package ftv.domain.models;

import java.util.UUID;

public record EvaluationId(UUID id) {
    public static EvaluationId generate() {
        return new EvaluationId(UUID.randomUUID());
    }
}
