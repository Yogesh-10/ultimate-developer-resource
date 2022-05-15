package com.yogesh.Linkedlist;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addFirst(10);
        System.out.println(list.indexOf(30));
//        System.out.println(list.contains(50));
//        list.removeFirst();
//        list.removeLast();
//        System.out.println(list.size());
//        int[] arr = list.toArray();
//        System.out.println(Arrays.toString(arr));
//        list.reverse();
//        list.removeByValue(20);
        list.print();
//        System.out.println(list.getKthNodeFromEnd(1));
    }
}
