package com.qin_kai.spring.core.advancedassemblies.profile;

/**
 * @author qin kai
 * @date 2020/8/25
 */
public class MyDataSource{
    private String name;

    public MyDataSource() {
    }

    public MyDataSource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
