package ftv.infrastructure.repositories;

import ftv.domain.models.Evaluation;
import ftv.domain.models.EvaluationId;
import ftv.domain.models.StudentId;
import ftv.domain.repositories.IEvaluationRepository;

import java.util.List;
import java.util.Optional;

public class InMemoryEvaluationRepository implements IEvaluationRepository {
    @Override
    public void save(Evaluation evaluation) {

    }

    @Override
    public Optional<Evaluation> findById(EvaluationId id) {
        return Optional.empty();
    }

    @Override
    public List<Evaluation> findByStudent(StudentId id) {
        return List.of();
    }
}
