package ftv.domain.repositories;

import ftv.domain.models.Evaluation;
import ftv.domain.models.EvaluationId;
import ftv.domain.models.StudentId;

import java.util.List;
import java.util.Optional;

public interface IEvaluationRepository {
    void save(Evaluation evaluation);

    Optional<Evaluation> findById(EvaluationId id);

    List<Evaluation> findByStudent(StudentId id);

    void delete(EvaluationId id);
}
