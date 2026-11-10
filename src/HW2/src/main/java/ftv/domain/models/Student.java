package ftv.domain.models;

import lombok.Getter;

public class Student {
    @Getter
    private final StudentId id;

    public String name;

    public Student(StudentId id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String name) {
        this.id = StudentId.generate();
        this.name = name;
    }
}
