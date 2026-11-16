package ftv.domain.models;

public record Student(StudentId id, String name) {
    public Student {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Student name must not be blank");
    }

    public Student(String name) {
        this(StudentId.generate(), name);
    }
}
