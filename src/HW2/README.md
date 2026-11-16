# Отчет

**Запуск:**:

```
.\gradlew :src:HW2:build
java -jar .\src\HW2\build\libs\HW2.jar
```

**Тесты:**:
`.\gradlew :src:HW2:test`

## DDD

- Entity: `Student`, `Evaluation`, `Criterion`
- VO: `StudentId`, `EvaluationId`, `CriterionId`, `Result`
- Агрегат: `Rubricator`
- Порты: `IStudentRepository`, `IRubricatorRepository`, `IEvaluationRepository`
- Domain Services: `EvaluationFactory`, `ResultCalculator`

## Архитектура и слои

- domain: модель, инварианты, порты, доменные сервисы
- application: фасад с основными сценариями приложения
- infrastructure: реализация консоли, репозиториев и json экспорта

## Обоснование GoF

- Порождающий: `EvaluationFactory` - создание и изменение оценок, и связь с рубрикатором для сохранения инвариантов
- Структурный: `IPosFacade` - общее место со сценариями приложения для UI
- Поведенческий: `IResultStrategy`, `ResultCalculator` - возможность изменять правила подсчета результата из приложения

## Роль ИИ

- Реализация `ConsoleUI`, `JsonExporter`
- Добавление обработки ошибок
- Написание тестов
- Дополнительный поиск неточностей и проверка качества архитектуры

