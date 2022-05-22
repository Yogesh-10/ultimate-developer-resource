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
    public static int[] reverseArray(int[] arr) {
        for (int i = arr.length - 1, j = 0; i > j; j++, i--) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    //5. remove duplicates from sorted array
    public static int removeDuplicates(int[] arr) {
        int size = arr.length;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] == arr[i]) {
                arr[i] = arr[i + 1];
                size--;
            }
        }
        System.out.println(Arrays.toString(arr));
        return size;
    }

    //6. Move zeros to end.
    public static int[] moveZerosToEnd(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                //swap zero and non-zero number
                int temp = arr[count];
                arr[count] = arr[i];
                arr[i] = temp;

                count++;
            }
        }
        return arr;
    }

    //7. Left Rotate Array.
    public static int[] leftRotate(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = arr[i + 1];
            arr[i + 1] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    public static int[] leftRotateByDTimes(int[] arr, int d) {
        //solution 1 - O(nd) time, Aux space - O(1)
//        for (int i = 0; i < d; i++) {
//            leftRotate(arr);
//        }
//        System.out.println(Arrays.toString(arr));

        //solution 2 - O(n) time, Aux space - O(d)
//        int[] temp = new int[d];
//        for (int i = 0; i < d; i++)
//            temp[i] = arr[i];
//        for (int i = d; i < arr.length; i++)
//            arr[i - d] = arr[i];
//        for (int i = 0; i < d; i++)
//            arr[arr.length - d + i] = temp[i];
//        return arr;

        //solution-3 O(n) time and O(1) space

        //reverse the d elements
        reverse(arr, 0, d - 1);
        //reverse the remaining elements
        reverse(arr, d, arr.length - 1);
        //reverse entire array
        reverse(arr, 0, arr.length - 1);

        return arr;
    }

    private static void reverse(int[] arr, int low, int high){
        while (low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public static void leaderInArray(int[] arr) {
        //7,10,4,3,6,5,2
        //O(n^2)
//        for (int i = 0; i < arr.length; i++){
//            boolean flag = false;
//            for (int j = i + 1; j < arr.length; j++){
//                if (arr[i] <= arr[j]) {
//                    flag = true;
//                    break;
//                }
//            }
//            if (!flag){
//                System.out.print(arr[i] + " ");
//            }
//        }

        //O(n) - solution
        int currLeader = arr[arr.length - 1];
        System.out.print(currLeader + " ");

        for (int i = arr.length - 2; i >= 0; i--){
            if (currLeader < arr[i]) {
                currLeader = arr[i];
                System.out.print(currLeader + " ");
            }
        }
    }

    public static int maximumDifference(int[] arr){
//        O(n ^ 2) solution,  Aux Space - O(1)
//        int max = arr[1] - arr[0];
//        for (int i = 0; i < arr.length; i++){
//            for (int j = i + 1; j < arr.length; j++){
//                max = Math.max(max, arr[j] - arr[i]);
//            }
//        }
//        System.out.println(max);

        //O(n ^ 2) solution, Aux Space - O(1)
        int minValue = arr[0];
        int res = arr[1] - arr[0];

        for (int i = 1; i < arr.length; i++){
            res = Math.max(res, arr[i] - minValue);
            minValue = Math.min(minValue, arr[i]);
        }
        return res;
    }
}
