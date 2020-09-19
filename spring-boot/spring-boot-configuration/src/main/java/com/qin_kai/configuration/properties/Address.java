package com.qin_kai.configuration.properties;

public class Address {
    private String city;
    private String province;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", province='" + province + '\'' +
                '}';
    }
}
