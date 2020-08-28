package com.qin_kai.mongo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author qin kai
 * @Date 2020/8/28
 */
public class User implements Serializable {

    private String userId;

    private String name;

    private int age;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(userId, user.userId) &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, age);
    }
}
