package com.qin_kai.java8.ch10_optional;

/**
 * 如何为缺失的值建模
 *
 * @author qinkai
 * @date 2021/8/23
 */
public class Ch10_1NullDemo {

    private static class Person {
        private Address address;

        private static class Address {
            private City city;

            private static class City {
                private String name;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }

            public City getCity() {
                return city;
            }

            public void setCity(City city) {
                this.city = city;
            }
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }
    }

    public static void main(String[] args) {
//        ch10_1_0();
        ch10_1_1();
    }

    /**
     * 防御性检查
     */
    private static void ch10_1_1() {

//        深层质疑
        Person person = new Person();
        String cityName = null;
        if (person != null) {
            Person.Address address = person.getAddress();
            if (address != null) {
                Person.Address.City city = address.getCity();
                if (city != null) {
                    cityName = city.getName();
                }
            }
        }
        System.out.println(cityName);

        if (person != null &&
                person.getAddress() != null &&
                person.getAddress().getCity() != null) {
            System.out.println(person.getAddress().getCity().getName());
        } else {
            System.out.println(cityName);
        }
//        过多的退出语句
        if (person == null) {
            System.out.println(cityName);
            return;
        }

        if (person.getAddress() == null) {
            System.out.println(cityName);
            return;
        }

        if (person.getAddress().getCity() == null) {
            System.out.println(cityName);
            return;
        }
        System.out.println(person.getAddress().getCity().getName());
    }

    /**
     * 产生NullPointer异常
     */
    private static void ch10_1_0() {
        String city = new Person().getAddress().getCity().getName();
        System.out.println(city);
    }

}
