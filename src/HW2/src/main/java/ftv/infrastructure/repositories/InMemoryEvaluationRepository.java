package ftv.infrastructure.repositories;

import ftv.domain.models.Evaluation;
import ftv.domain.models.EvaluationId;
import ftv.domain.models.StudentId;
import ftv.domain.repositories.IEvaluationRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryEvaluationRepository implements IEvaluationRepository {
    private final Map<EvaluationId, Evaluation> evaluations = new HashMap<>();

    @Override
    public void save(Evaluation evaluation) {
        evaluations.put(evaluation.id(), evaluation);
    }

    @Override
    public Optional<Evaluation> findById(EvaluationId id) {
        return Optional.ofNullable(evaluations.get(id));
    }

    @Override
    public List<Evaluation> findByStudent(StudentId id) {
        return evaluations.values().stream().filter(evaluation -> evaluation.studentId().equals(id)).toList();
    }

    @Override
    public void delete(EvaluationId id) {
        evaluations.remove(id);
    }
}
