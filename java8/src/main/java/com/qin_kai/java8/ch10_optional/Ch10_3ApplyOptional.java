package com.qin_kai.java8.ch10_optional;

import java.util.Optional;

/**
 * 应用Optional的几种模式
 *
 * @author qinkai
 * @date 2021/8/23
 */
public class Ch10_3ApplyOptional {
    private static class Person {
        private Optional<Person.Address> address;

        static class Address {
            private Optional<Person.Address.City> city;

            static class City {
                private String name;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }

            public Optional<Person.Address.City> getCity() {
                return city;
            }

            public void setCity(Optional<Person.Address.City> city) {
                this.city = city;
            }
        }

        public Optional<Address> getAddress() {
            return address;
        }

        public void setAddress(Optional<Address> address) {
            this.address = address;
        }
    }

    public static void main(String[] args) {
//        ch10_3_1();
//        ch10_3_2();
//        ch10_3_3();
//        ch10_3_4();

        ch10_3_6();
    }

    /**
     * filter过滤值
     */
    private static void ch10_3_6() {
        int n = 3;
        Optional<Integer> optional = Optional.ofNullable(n);

        // 过滤不存在时返回empty
        Optional<Integer> filteredOpt = optional.filter(i -> i > 3);
        System.out.println(filteredOpt);
    }

    /**
     * 读取Optional中的值
     */
    private static void ch10_3_4() {
        Optional<String> optional = Optional.ofNullable("test");
        //值不存在抛出异常
        String s = optional.get();

        //指定值不存在时的返回值
        optional.orElse("NULL");

        // 通过传入的是Supplier，可以延迟初始化需要的默认值
        optional.orElseGet(() -> "1234");

        // 不存在时抛出指定异常
        optional.orElseThrow(() -> new RuntimeException());

        // 值存在的时候消费值
        optional.ifPresent(System.out::println);
    }

    /**
     * flatMap
     */
    private static void ch10_3_3() {
        Person person = new Person();
        Person.Address address = new Person.Address();
        Person.Address.City city = new Person.Address.City();
        city.setName("test");
        address.setCity(Optional.ofNullable(city));
        person.setAddress(Optional.ofNullable(address));

        Optional<Person> optPerson = Optional.of(person);

//        compile error 因为 optPerson.map(Person::getAddress)返回Optional<Address>
//        Optional<String> optCityName = optPerson.map(Person::getAddress)
//                .map(Person.Address::getCity)
//                .map(Person.Address.City::getName);

//        flatMap相当与去掉外层的Optional
        String cityName = optPerson.flatMap(Person::getAddress)
                .flatMap(Person.Address::getCity)
                .map(Person.Address.City::getName)
                .orElse(null);
        System.out.println(cityName);
    }

    /**
     * 使用map方法
     */
    private static void ch10_3_2() {
        // 没有Optional之前提取值
        String s = "hello";
        if (s != null) {
            System.out.println(s.length());
        }

        Optional<String> optional = Optional.ofNullable(s);
        System.out.println(optional.map(String::length));
    }

    /**
     * 创建Optional
     */
    private static void ch10_3_1() {
        // 空optional
        Optional<Object> empty = Optional.empty();

        String s = "123";
        // of 非空
        Optional<String> optional1 = Optional.of(s);

        s = null;
        // 可为null
        Optional<String> optional2 = Optional.ofNullable(s);
    }

}
