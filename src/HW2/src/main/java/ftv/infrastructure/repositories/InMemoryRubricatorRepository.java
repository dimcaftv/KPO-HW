package ftv.infrastructure.repositories;

import ftv.domain.models.Rubricator;
import ftv.domain.repositories.IRubricatorRepository;

public class InMemoryRubricatorRepository implements IRubricatorRepository {
    private Rubricator rubricator = new Rubricator();

    @Override
    public void save(Rubricator rubricator) {
        this.rubricator = rubricator;
    }

    @Override
    public Rubricator load() {
        return rubricator;
    }
}
