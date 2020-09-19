package com.qin_kai.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("appUser1")
// 指定 application.properties/yml 配置的前缀，则配置会自动注入为这个类的属性
@ConfigurationProperties(prefix = "app.user")
public class AppUserProperties {
    private String name;

    private Integer age;

    private List<String> hobbies;

    private Address address;

    private Map<String, String> map;

    private List<Address> addresses;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AppUserProperties{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hobbies=" + hobbies +
                ", address=" + address +
                ", map=" + map +
                ", addresses=" + addresses +
                '}';
    }
}
