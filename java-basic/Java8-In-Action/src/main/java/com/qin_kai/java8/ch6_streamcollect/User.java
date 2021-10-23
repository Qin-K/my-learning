package com.qin_kai.java8.ch6_streamcollect;

/**
 * @author qinkai
 * @date 2021/8/19
 */
public class User {
    private boolean male;
    private UserType userType;
    private String name;
    private int age;

    public User(boolean male, String name) {
        this.male = male;
        this.name = name;
    }

    public User(UserType userType, String name, int age) {
        this.userType = userType;
        this.name = name;
        this.age = age;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
