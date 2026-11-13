package ftv.config;

import ftv.application.IPosFacade;
import ftv.application.PosFacadeImpl;
import ftv.domain.EvaluationFactory;
import ftv.domain.repositories.IEvaluationRepository;
import ftv.domain.repositories.IRubricatorRepository;
import ftv.domain.repositories.IStudentRepository;
import ftv.domain.service.*;
import ftv.infrastructure.export.JsonExporter;
import ftv.infrastructure.repositories.InMemoryEvaluationRepository;
import ftv.infrastructure.repositories.InMemoryRubricatorRepository;
import ftv.infrastructure.repositories.InMemoryStudentRepository;
import ftv.infrastructure.ui.ConsoleUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;
import java.util.List;

@Configuration
public class Config {
    @Bean
    public IStudentRepository studentRepository() {
        return new InMemoryStudentRepository();
    }

    @Bean
    public IRubricatorRepository rubricatorRepository() {
        return new InMemoryRubricatorRepository();
    }

    @Bean
    public IEvaluationRepository evaluationRepository() {
        return new InMemoryEvaluationRepository();
    }

    @Bean
    public EvaluationFactory evaluationFactory() {
        return new EvaluationFactory();
    }

    @Bean
    public ResultCalculator resultCalculator() {
        return new ResultCalculator();
    }

    @Bean
    public IResultStrategy simpleStrategy() {
        return new SimpleStrategy();
    }

    @Bean
    public IResultStrategy fullRubricatorStrategy() {
        return new FullRubricatorStrategy();
    }

    @Bean
    public CalculationMode calculationMode() {
        return CalculationMode.SIMPLE;
    }

    @Bean
    public IExporter exporter() {
        return new JsonExporter(Path.of("results.json"));
    }

    @Bean
    public IPosFacade posFacade(IStudentRepository studentRepository,
                                IRubricatorRepository rubricatorRepository,
                                IEvaluationRepository evaluationRepository,
                                EvaluationFactory evaluationFactory,
                                ResultCalculator resultCalculator,
                                List<IResultStrategy> strategies,
                                CalculationMode calculationMode,
                                IExporter exporter) {
        return new PosFacadeImpl(studentRepository, rubricatorRepository, evaluationRepository,
                evaluationFactory, resultCalculator, strategies, calculationMode, exporter);
    }

    @Bean
    public ConsoleUI consoleUI(IPosFacade facade) {
        return new ConsoleUI(facade);
    }
}
