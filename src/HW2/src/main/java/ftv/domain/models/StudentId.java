package ftv.domain.models;

import java.util.UUID;

public record StudentId(UUID id) {
    public static StudentId generate() {
        return new StudentId(UUID.randomUUID());
    }
}
