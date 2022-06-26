package hometask.lesson13;

import java.util.*;
import java.util.stream.Collectors;

public class UserService {

    private final Collection<User> userRepository;

    public UserService(Collection<User> userRepository) {
        this.userRepository = userRepository;
    }

    public Collection<User> findAllByName(String name) {
        return userRepository.stream().filter(user -> user.getName().equals(name)).collect(Collectors.toList());
    }

    public Collection<User> findAllBySex(String sex) {
        return userRepository.stream().filter(user -> user.getSex().equals(sex)).collect(Collectors.toList());
    }

    public Collection<User> findAllSortByAge(){
        List<User> result = new ArrayList<>(userRepository);
        Collections.sort(result);
        return result;
    }
}
