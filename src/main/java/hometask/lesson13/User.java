package hometask.lesson13;

import common.UserCommon;

public class User extends UserCommon implements Comparable<User> {

    public User(String name, String lastName, String sex, Integer userAge) {
        super(name, lastName, sex, userAge);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", userAge=" + userAge +
                '}' + "\n";
    }

    @Override
    public int compareTo(User o) {
        int result = this.userAge.compareTo(o.userAge);
        if (result == 0) {
            result = this.lastName.compareTo(o.lastName);
            if (result == 0) {
                result = this.name.compareTo(o.name);
            }
        }
        return result;


    }


}
