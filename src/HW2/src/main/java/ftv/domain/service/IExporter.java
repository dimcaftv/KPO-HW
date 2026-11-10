package ftv.domain.service;

import ftv.domain.models.Result;

import java.util.List;

public interface IExporter {
    void export(List<Result> results);
}
