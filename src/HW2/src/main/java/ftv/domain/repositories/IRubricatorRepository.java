package ftv.domain.repositories;

import ftv.domain.models.Rubricator;

public interface IRubricatorRepository {
    void save(Rubricator rubricator);

    Rubricator load();
}
