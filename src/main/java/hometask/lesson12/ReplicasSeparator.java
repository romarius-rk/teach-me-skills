package hometask.lesson12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReplicasSeparator {

    public void separator(Map<String, List<String>> actorMap, User actor, File file) throws IOException, RuntimeException {
        List<String> replicasList = actorMap.get(actor.getName());
        FileWriter writer = new FileWriter(file.getPath());
        replicasList.forEach(replica -> {
            try {
                writer.write(replica + "\n");
            } catch (IOException e) {
                System.out.println("kekes");
                throw new RuntimeException(e);

            }
        });
        writer.flush();
    }
}
