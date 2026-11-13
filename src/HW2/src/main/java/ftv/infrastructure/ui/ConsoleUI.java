package ftv.infrastructure.ui;

import ftv.application.IPosFacade;
import ftv.domain.models.Criterion;
import ftv.domain.models.CriterionId;
import ftv.domain.models.Evaluation;
import ftv.domain.models.Student;
import ftv.domain.service.CalculationMode;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private final IPosFacade facade;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleUI(IPosFacade facade) {
        this.facade = facade;
    }

    public void run() {
        while (true) {
            System.out.println("""
                    1 - Add student
                    2 - Add criterion
                    3 - Evaluate student
                    4 - Show student evaluations
                    5 - Correct evaluation
                    6 - Remove evaluation
                    7 - Show results
                    8 - Change evaluation formula
                    9 - Export file
                    0 - exit""");
            System.out.print("> ");
            if (!scanner.hasNextLine()) return;

            String command = scanner.nextLine().trim();
            if (command.equals("0")) return;

            try {
                switch (command) {
                    case "1" -> addStudent();
                    case "2" -> addCriterion();
                    case "3" -> evaluate();
                    case "4" -> showEvaluations();
                    case "5" -> correctEvaluation();
                    case "6" -> removeEvaluation();
                    case "7" -> showResult();
                    case "8" -> changeMode();
                    case "9" -> export();
                    default -> System.out.println("No such command");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addStudent() {
        facade.addStudent(new Student(ask("Student name: ")));
        System.out.println("Student added");
    }

    private void addCriterion() {
        String name = ask("Criterion name: ");
        int maxScore = askInt("Maximum: ");
        double weight = askDouble("Weight: ");
        facade.addCriterion(new Criterion(new CriterionId(name), maxScore, weight));
        System.out.println("Criterion added");
    }

    private void evaluate() {
        Student student = pickStudent();
        Criterion criterion = pickCriterion();

        int score = askInt("Score: ");
        facade.evaluateStudent(student.id(), criterion.id(), score);
        System.out.println("Evaluation recorded");
    }

    private void showEvaluations() {
        Student student = pickStudent();
        List<Evaluation> evaluations = facade.getEvaluations(student.id());
        if (evaluations.isEmpty()) {
            System.out.println("No evaluations");
            return;
        }
        printEvaluations(evaluations);
    }

    private void correctEvaluation() {
        Student student = pickStudent();
        Evaluation evaluation = pickEvaluation(student);
        int score = askInt("New score: ");
        facade.correctEvaluation(evaluation.id(), score);
        System.out.println("Evaluation corrected");
    }

    private void removeEvaluation() {
        Student student = pickStudent();
        facade.removeEvaluation(pickEvaluation(student).id());
        System.out.println("Evaluation removed");
    }

    private void showResult() {
        Student student = pickStudent();
        System.out.printf("%s: %.3f%n", student.name(), facade.getResult(student.id()).result());
    }

    private void changeMode() {
        List<CalculationMode> modes = facade.getAvailableCalculationModes();
        for (int i = 0; i < modes.size(); i++)
            System.out.printf("%d. %s%n", i + 1, modes.get(i));

        int number = askInt("Mode: ");
        if (number < 1 || number > modes.size())
            throw new IllegalArgumentException("No such mode");

        facade.setCalculationMode(modes.get(number - 1));
        System.out.println("Current mode: " + facade.getCalculationMode());
    }

    private void export() {
        facade.exportResults();
        System.out.println("Results exported");
    }

    private Student pickStudent() {
        List<Student> students = facade.getStudents();
        if (students.isEmpty())
            throw new IllegalStateException("No students");

        for (int i = 0; i < students.size(); i++)
            System.out.printf("%d. %s%n", i + 1, students.get(i).name());

        int number = askInt("Student number: ");
        if (number < 1 || number > students.size())
            throw new IllegalArgumentException("No such student");

        return students.get(number - 1);
    }

    private Criterion pickCriterion() {
        List<Criterion> criteria = facade.getCriterions();
        if (criteria.isEmpty())
            throw new IllegalStateException("No criteria");

        for (int i = 0; i < criteria.size(); i++) {
            Criterion criterion = criteria.get(i);
            System.out.printf("%d. %s (max. %d, weight %.2f)%n",
                    i + 1, criterion.id().name(), criterion.maxScore(), criterion.weight());
        }

        int number = askInt("Criterion number: ");
        if (number < 1 || number > criteria.size())
            throw new IllegalArgumentException("No such criterion");

        return criteria.get(number - 1);
    }

    private Evaluation pickEvaluation(Student student) {
        List<Evaluation> evaluations = facade.getEvaluations(student.id());
        if (evaluations.isEmpty())
            throw new IllegalStateException("Student has no evaluations");

        printEvaluations(evaluations);

        int number = askInt("Evaluation number: ");
        if (number < 1 || number > evaluations.size())
            throw new IllegalArgumentException("No such evaluation");
        return evaluations.get(number - 1);
    }

    private void printEvaluations(List<Evaluation> evaluations) {
        for (int i = 0; i < evaluations.size(); i++) {
            Evaluation evaluation = evaluations.get(i);
            System.out.printf("%d. %s: %d%n", i + 1, evaluation.criterionId().name(), evaluation.score());
        }
    }

    private String ask(String prompt) {
        System.out.print(prompt);
        if (!scanner.hasNextLine())
            throw new IllegalStateException("Input ended");
        return scanner.nextLine().trim();
    }

    private int askInt(String prompt) {
        try {
            return Integer.parseInt(ask(prompt));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Expected an integer");
        }
    }

    private double askDouble(String prompt) {
        try {
            return Double.parseDouble(ask(prompt));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Expected a number");
        }
    }
}
