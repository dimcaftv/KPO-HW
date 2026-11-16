package ftv.infrastructure.export;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ftv.application.IExporter;
import ftv.domain.models.Result;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class JsonExporter implements IExporter {
    private final Path file;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public JsonExporter(Path file) {
        this.file = file;
    }

    @Override
    public void export(List<Result> results) {
        List<ResultJson> payload = results.stream()
                .map(result -> new ResultJson(result.studentId().id().toString(), result.result()))
                .toList();
        try {
            Files.writeString(file, gson.toJson(payload));
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to export results to " + file, e);
        }
    }

    private record ResultJson(String studentId, double result) {
    }
}
