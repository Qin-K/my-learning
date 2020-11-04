package com.qin_kai.java;

import java.util.Scanner;

/**
 * @author qinkai
 * @date 2020/11/4
 */
public class ScannerDemo {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = in.nextLine();

        System.out.println("How old are you?");
        int age = in.nextInt();

        System.out.println("Hello, " + name + ". Next year, you'll be " + (age + 1));
    }

}
