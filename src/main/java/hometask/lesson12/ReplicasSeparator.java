package hometask.lesson12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReplicasSeparator {

    public void separateDialog(Map<String, List<String>> actorMap) {
        actorMap.forEach((key, value) -> {
            File file = new File("D:\\teach-me-skills\\src\\main\\java\\hometask\\lesson12\\texts",
                    key + ".txt");
            try (FileWriter writer = new FileWriter(file.getPath())) {
                value.forEach(line -> {
                    try {
                        writer.write(line + "\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
                writer.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
