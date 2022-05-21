package com.yogesh.Arrays;

import java.util.Arrays;

public class ArrayProblems {
    //1. Largest element in an array
    //I/p: [10, 50, 20, 8], O/P - 1(index of largest element in array)
    //I/p: [10, 20, 30, 80], O/P - 3(index of largest element in array)
    //O(n) solution - Efficient solution
    public static int largestElement(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[max])
                max = i;
        }
        return max;
    }

    //1. Second Largest element in an array
    //I/p: [10, 50, 20, 8], O/P - 2(index of largest element in array)
    //I/p: [10, 20, 30, 80], O/P - 2(index of largest element in array)
    //O(n) solution - Efficient solution
    public static int secondLargestElement(int[] arr) {
        int largest = 0;
        int secondLargest = -1; //we initialize second largest -1 because, we may have same values in array, eg: {10,10,10}. so here only we can have largest value. we cannot have second largest value. so we simply return -1
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[largest]) {
                secondLargest = largest;
                largest = i;
            } else if (arr[i] != arr[largest]) {
                if (secondLargest == -1 || arr[i] > arr[secondLargest])
                    secondLargest = i;
            }
        }
        return secondLargest;
    }

    //3. Check if array is sorted
    public static boolean isSortedArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1])
                return false;
        }
        return true;
    }

    //4. Reverse an array
    public static int[] reverseArray(int[] arr){
        for (int i = arr.length - 1, j = 0; i > j ; j++, i--) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    //5. remove duplicates from sorted array
    public static int removeDuplicates(int[] arr){
        int size = arr.length;

        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i + 1] == arr[i]) {
                arr[i] = arr[i + 1];
                size--;
            }
        }
        System.out.println(Arrays.toString(arr));
        return size;
    }

    //6. Move zeros to end.
    public static int[] moveZerosToEnd(int[] arr){
        int count = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] != 0){
                //swap zero and non-zero number
                int temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;

                count++;
            }
        }
        return arr;
    }
}
