package ftv.domain.models;

public record Student(StudentId id, String name) {
    public Student {
        if (id == null)
            throw new IllegalArgumentException("Student id is null");
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Student name is empty");
    }

    public Student(String name) {
        this(StudentId.generate(), name);
    }
}
