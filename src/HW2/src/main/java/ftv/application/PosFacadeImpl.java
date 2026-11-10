package ftv.application;

import ftv.domain.EvaluationFactory;
import ftv.domain.models.*;
import ftv.domain.repositories.IEvaluationRepository;
import ftv.domain.repositories.IRubricatorRepository;
import ftv.domain.repositories.IStudentRepository;
import ftv.domain.service.IExporter;
import ftv.domain.service.IResultStrategy;
import ftv.domain.service.ResultCalculator;

import java.util.List;

public class PosFacadeImpl implements IPosFacade {
    private final IStudentRepository studentRepository;
    private final IRubricatorRepository rubricatorRepository;
    private final IEvaluationRepository evaluationRepository;
    private final EvaluationFactory evaluationFactory;
    private final ResultCalculator resultCalculator;
    private final IResultStrategy resultStrategy;
    private final IExporter exporter;

    public PosFacadeImpl(IStudentRepository studentRepository,
                         IRubricatorRepository rubricatorRepository,
                         IEvaluationRepository evaluationRepository,
                         EvaluationFactory evaluationFactory,
                         ResultCalculator resultCalculator,
                         IResultStrategy resultStrategy,
                         IExporter exporter) {
        this.studentRepository = studentRepository;
        this.rubricatorRepository = rubricatorRepository;
        this.evaluationRepository = evaluationRepository;
        this.evaluationFactory = evaluationFactory;
        this.resultCalculator = resultCalculator;
        this.resultStrategy = resultStrategy;
        this.exporter = exporter;
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void addCriterion(Criterion criterion) {
        Rubricator rubricator = rubricatorRepository.load();
        rubricator.addCriterion(criterion);
        rubricatorRepository.save(rubricator);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Criterion> getCriterions() {
        return rubricatorRepository.load().getCriterions();
    }

    @Override
    public Evaluation evaluateStudent(StudentId studentId, CriterionId criterionId, int score) {
        studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found: " + studentId.id()));

        Rubricator rubricator = rubricatorRepository.load();
        Evaluation evaluation = evaluationFactory.createEvaluation(studentId, criterionId, score, rubricator);
        evaluationRepository.save(evaluation);
        return evaluation;
    }

    @Override
    public void correctEvaluation(EvaluationId evaluationId, int newScore) {
        Evaluation evaluation = evaluationRepository.findById(evaluationId)
                .orElseThrow(() -> new IllegalArgumentException("Evaluation not found: " + evaluationId.id()));

        Rubricator rubricator = rubricatorRepository.load();
        evaluation = evaluationFactory.correct(evaluation, newScore, rubricator);
        evaluationRepository.save(evaluation);
    }

    @Override
    public void removeEvaluation(EvaluationId evaluationId) {
        evaluationRepository.delete(evaluationId);
    }

    @Override
    public List<Evaluation> getEvaluations(StudentId studentId) {
        return evaluationRepository.findByStudent(studentId);
    }

    @Override
    public Result getResult(StudentId studentId) {
        Rubricator rubricator = rubricatorRepository.load();
        List<Evaluation> evaluations = evaluationRepository.findByStudent(studentId);
        return resultCalculator.calculate(studentId, evaluations, rubricator, resultStrategy);
    }

    @Override
    public void exportResults() {
        List<Result> results = studentRepository.findAll().stream().map(student -> getResult(student.id())).toList();
        exporter.export(results);
    }
}
