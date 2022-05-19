package com.yogesh.Algorithms.SearchingAlgorithms;

//Binary search only on sorted lists
public class BinarySearch {
    public int binarySearchRecursive(int[] array, int target) {
        return binarySearchRecursive(array, target, 0, array.length - 1);
    }

    protected int binarySearchRecursive(int[] array, int target, int left, int right) {
        //Base condition
        if (right < left)
            return -1;

        int middle = (left + right) / 2;

        if (array[middle] == target)
            return middle;

        //check if target item is left or right partition
        //if target less than middle then it is in left partition
        if (target < array[middle])
            return binarySearchRecursive(array, target, left, middle - 1);

        //else, if target greater than middle then it is in right partition
        return binarySearchRecursive(array, target, middle + 1, right);
    }

    public int binarySearchIterative(int[] array, int target) {
        var left = 0;
        var right = array.length - 1;

        //as long as, left <= right, that means our partition has at least one element
        while (left <= right) {
            var middle = (left + right) / 2;

            if (array[middle] == target)
                return middle;

            //check if target item is left or right partition
            if (target < array[middle])
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }
}