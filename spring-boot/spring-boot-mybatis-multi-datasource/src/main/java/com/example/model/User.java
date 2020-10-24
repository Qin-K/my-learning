package com.example.model;

/**
 * @author qin kai
 * @date 2020/8/27
 */
public class User {
    private Integer id;

    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
