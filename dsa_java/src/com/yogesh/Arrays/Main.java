package com.yogesh.Arrays;

public class Main {
    public static void main(String[] args) {
        Array nums = new Array(3);
        nums.insert(10);
        nums.insert(22);
        nums.insert(33);
        nums.insert(44);
        nums.insert(55);
        nums.removeAt(3);
        nums.print();
        System.out.println("index " + nums.indexOf(55));
    }
}
