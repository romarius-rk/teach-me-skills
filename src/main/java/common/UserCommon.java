package common;

public class UserCommon {
    protected String name;
    protected String lastName;
    protected String sex;
    protected Integer userAge;

    public UserCommon(String name, String lastName, String sex, Integer userAge) {
        this.name = name;
        this.lastName = lastName;
        this.sex = sex;
        this.userAge = userAge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCommon)) return false;

        UserCommon that = (UserCommon) o;

        if (!name.equals(that.name)) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (!sex.equals(that.sex)) return false;
        return userAge.equals(that.userAge);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + sex.hashCode();
        result = 31 * result + userAge.hashCode();
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }
}
