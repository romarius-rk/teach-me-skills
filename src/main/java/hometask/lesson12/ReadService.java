package hometask.lesson12;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class ReadService {

    public Map<String, List<String>> readReplicas(BufferedReader reader, List<User> actorsList) throws IOException {
        String line;
        int count = 0;
        String lastKey = "";
        Map<String, List<String>> userMap = new HashMap<>();
        actorsList.forEach(actor -> userMap.put(actor.getName(), new ArrayList<>()));
        while ((line = reader.readLine()) != null) {
            String finalLine = line;
            Optional<Map.Entry<String, List<String>>> userOptional = userMap.entrySet().stream()
                    .filter(actor -> finalLine.startsWith(actor.getKey())).findFirst();
            if (userOptional.isPresent()) {
                count += 1;
                lastKey = userOptional.get().getKey();
                userOptional.get().getValue().add(line);
            } if (userOptional.isEmpty() && count > 0){
                userMap.get(lastKey).add(line);
            }
        }
        return userMap;
    }
}
