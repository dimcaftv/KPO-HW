package ftv.infrastructure.repositories;

import ftv.domain.models.Rubricator;
import ftv.domain.repositories.IRubricatorRepository;

public class InMemoryRubricatorRepository implements IRubricatorRepository {
    @Override
    public void save(Rubricator rubricator) {

    }

    @Override
    public Rubricator load() {
        return null;
    }
}
