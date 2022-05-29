package com.yogesh.Arrays;

import java.util.Arrays;

public class ArrayProblems {
    //1. Largest element in an array
    //I/p: [10, 50, 20, 8], O/P - 1(index of largest element in array)
    //I/p: [10, 20, 30, 80], O/P - 3(index of largest element in array)
    //O(n) solution - Efficient solution
    public static int largestElement(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
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
        int res = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[res - 1]) {
                arr[res] = arr[i];
                res++;
            }
        }
        for (int i = arr.length; i < res; i++)

        System.out.println(Arrays.toString(arr));
        return res;
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

    public static int[] rightRotate(int[] arr){
        for (int i = arr.length - 1; i > 0; i--){
            int temp = arr[i - 1];
            arr[i - 1] = arr[i];
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

    public static void frequencyInSortedArray(int[] arr){
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i] == arr[i + 1])
                count++;
            else  {
                System.out.println(arr[i] + " " + count);
                count = 1;
            }
        }
        System.out.println(arr[arr.length-1] + " " + count);
    }


    public static int maxProfit(int[] price, int start, int end){
       //O(n^2) solution, Aux Space - O(n)
       /* if (end <= start)
            return 0;

        int profit = 0;
        for (int i = start; i < end; i++){
            for (int j = i + 1; j <= end; j++){
                //we check if price at j is greater than price at i
                if (price[j] > price[i]){
                    //if yes we calculate current profit by, taking difference between j and i
                    //and we recursively call left of i and for right of j, so we check all pairs and get max profit
                    int currProfit = price[j] - price[i] +
                            maxProfit(price, start, i - 1) +
                            maxProfit(price, j + 1, end);

                    //finally we update the max profit
                    profit = Math.max(profit, currProfit);
                }
            }
        }
        return profit;
        */

        //O(n) solution, Aux Space - O(1)
        int profit = 0;
        //the idea is simple, we iterate through array, when i is greater than i-1,
        //we simply subtract (i and i-1) and add it to the profit. this means that
        //we buy when stock is low and sell when stock is high(we keep on adding as we iterate through the array).
        for (int i = 1; i < price.length; i++)
            if (price[i] > price[i - 1])
                profit += price[i] - price[i - 1];

        return profit;
    }

    public static int trapRainWater(int[] arr){
    /*    //O(n^2) solution
        int res = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            //find the left max bar
            //traverse through left of i and find max height bar on left
            int lMax = arr[i];
            for (int j = 0; j < i; j++)
                lMax = Math.max(lMax, arr[j]);

            //find the right max bar
            //traverse through right of i and find max height bar on right
            int rMax = arr[i];
            for (int j = i + 1; j < arr.length; j++)
                rMax = Math.max(rMax, arr[j]);

            //Find the min height of bar between, rmax and lmax, and subtract with current i
            //that gives the amount of water that can be trapped at that point
            res += (Math.min(lMax, rMax) - arr[i]);
        }
        return res;
*/
      //O(n) solution, Aux Space - O(n)
      int res = 0;
      int n = arr.length;
      int[] lMax = new int[n];
      int[] rMax = new int[n];

      //computing lmax and storing it in lmax array
      lMax[0] = arr[0];
      for (int i = 1; i < n; i++)
          lMax[i] = Math.max(lMax[i - 1], arr[i]);

      //computing rmax and storing it in rmax array
      rMax[n - 1] = arr[n - 1];
      for (int i = n - 2; i >= 0; i--)
          rMax[i] = Math.max(rMax[i + 1], arr[i]);

      //finding the amount of water trapped in between rmax and lmax bars
      for (int i = 1; i < n; i++)
          res += (Math.min(lMax[i], rMax[i]) - arr[i]);

      return res;
    }

    public static int maxConsecutiveOnes(int[] arr){
        //O(n^2) solution
        /*
        int res = 0;
        for (int i = 0; i < arr.length; i++){
            int curr = 0;
            for (int j = i; j < arr.length; j++){
                if (arr[j] == 1) curr++;
                else break;
            }
            res = Math.max(res, curr);
        }
        return res;
*/
        //O(n) solution
        int res = 0;
        int curr = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == 0)
                curr = 0;
            else{
                curr++;
                res = Math.max(res, curr);
            }
        }
        return res;
    }

    public static int maxSubarraySum(int[] arr){
        int res = arr[0];
        int maxEnding = arr[0];
        for (int i = 1; i < arr.length; i++){
            //we extend the previous subarray by (arr[i] + maxending), or we start new subarray from arr[i]
            maxEnding = Math.max(arr[i] + maxEnding, arr[i]);
            res = Math.max(res, maxEnding);
        }

        return res;
    }

    public static int longestEvenOddSubarray(int[]arr){
        //O(n^2) solution
//        int res = 1;
//        for (int i = 0; i < arr.length; i++){
//            int curr = 1;
//            for (int j = i + 1; j < arr.length; j++){
//                if (arr[j] % 2 == 0 && arr[j - 1] % 2 != 0 || arr[j] %2 != 0 && arr[j - 1] % 2 == 0)
//                    curr++;
//                else break;
//            }
//            res = Math.max(res, curr);
//        }
//        return res;

        //O(n) solution - kadane's algorithm
        int res = 1;
        int curr = 1;
        for (int i = 1; i < arr.length; i++){
            //if it's alternative we extend previous subarray and increase curr
            if (arr[i] % 2 == 0 && arr[i - 1] % 2 != 0 || arr[i] %2 != 0 && arr[i - 1] % 2 == 0){
                curr++;
                res = Math.max(res, curr);
            }
            //or else we start new subarray and reset curr to 1
            else curr = 1;
        }
        return res;
    }

    public static int maximumCircularSubarraySum(int[] arr){
//        O(n^2) solution
//        int res = arr[0];
//        for (int i = 0; i < arr.length; i++) {
//            int currMax = arr[i];
//            int currSum = arr[i];
//            for (int j = 1; j < arr.length; j++){
//                //when calculate index, so that index comes back to first position in array, after reaching the last
//                int index = (i + j) % arr.length;
//                currSum += arr[index];
//                currMax = Math.max(currMax, currSum);
//            }
//            res = Math.max(res, currMax);
//        }
//        return res;

        //O(n^2) solution
        //in this solution we can find maxsubarray sum in circular array by finding min sum value in subarray and subtracting it with total sum of array
        //we first find the max subarray sum in the array, without checking circular array.(using kadane's algorithm)
        int maxNormalSubarray = maxSubarraySum(arr);

        //if it's negative then all elements in array is negative, so we return max of normal subarray sum
        if (maxNormalSubarray < 0)
            return maxNormalSubarray;

        //we find the total sum of array, and subtract it with min subarray value
        //instead of writing other function for finding min subarray sum, we can reuse max subarray sum
        //the trick here is, we invert all the elements of the array and find max subarray sum value, which is a result of
        //min value of subarray sum
        int arrSum = 0;
        for (int i = 0; i < arr.length; i++){
            arrSum += arr[i];
            arr[i] = -arr[i];
        }

        //instead of subtracting we add, because we have inverted and found the max value(which is minvalue), for eg:-6 is value of minsum, but we have inverted and found result as 6, so we add
        int maxCircularSubarray = arrSum + maxSubarraySum(arr);
        return Math.max(maxNormalSubarray, maxCircularSubarray);
    }

    public static int majorityElement(int[] arr){
//        O(N^2) solution
//        for (int i = 0; i < arr.length;i++){
//            int count = 1;
//            for (int j = i + 1; j < arr.length;j++){
//                if (arr[i] == arr[j]){
//                    count++;
//                }
//            }
//            if (count > arr.length/2) return i;
//        }
//        return -1;

        //O(n) solution - Moore's voting algorithm
        int res = 0;
        int count = 1;
        //find the candidate, that appears maximum
        for (int i = 1; i < arr.length; i++){
            if (arr[res] == arr[i]) count++;
            else count--;

            if (count == 0) {
                count = 1;
                res = i;
            }
        }

        //check if the candidate is actually a majority
        count = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[res] == arr[i])
                count++;
        }
        if (count <= arr.length / 2) res = -1;

        return res;
    }

    public static boolean equilibriumPoint(int[] arr){
//        //Using Prefix sum technique - O(n^2) Solution
//        for (int i = 0; i < arr.length; i++){
//            int leftSum = 0; int rightSum = 0;
//            for (int j = 0; j < i; j++)
//                leftSum += arr[j];
//
//            for (int k = i + 1; k < arr.length; k++)
//                rightSum += arr[k];
//
//            if (leftSum == rightSum) return true;
//        }
//        return false;

        //Using Prefix sum technique - O(n) solution
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];

        int lSum = 0;
        for (int i = 0; i < arr.length; i++){
            //we calculate lSum as we traverse and we ger right sum by,
            //subtracting sum - arr[i] in each iteration, which will gives us rightSum
            int rightSum = sum - arr[i];
            if (lSum == rightSum)
                return true;

            lSum += arr[i];
            sum -= arr[i];
        }
        return false;
    }

    public static int mostFreqItem(int[] arr){
        int res = 1;
        int maxCount = 1;
        for (int i = 0; i < arr.length; i++){
            int count = 1;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] == arr[j]) count++;

            if (count > maxCount){
                maxCount = count;
                res = arr[i];
            }
        }
        return res;
    }

    public static void commonElementsIn2SortedArrays(int[] arr1, int[] arr2){
        int i = 0, j = 0;
        while (i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j])
                i++;
            else if (arr1[i] > arr2[j])
                j++;
            else {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }
    }

    public static boolean isRotation(int[] arr1, int[] arr2){
        int m = arr1.length; int n = arr2.length;
        if (n != m) return false;

        int target = arr1[0]; int key = -1;
        for (int k= 0; k < n; k++){
            if (arr2[k] == target){
                key = k;
                break;
            }
        }
        if (key == -1) return false;

        for (int i = 0; i < m; i++){
            int index = (key + i) % n; //or use (key % n) and increment key++ in every iteration
            if (arr1[i] != arr2[index]) return false;
        }

        return true;
    }

    public static void removeEvenItems(int[] arr){
        int index = 0;
        int size = arr.length;
        for (int i = 0; i < arr.length; i++){
           if (arr[i] % 2 == 1){
               arr[index] = arr[i];
               if (i > index) {
                   arr[i] = 0;
               }
               index++;
           }else{
               arr[i] = 0;
               size--;
           }
        }
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2){
        //Time Complexity : O(n1 + n2)
        //Auxiliary Space : O(n1 + n2)
        int i = 0; int j = 0; int index = 0;
        int[] temp = new int[arr1.length + arr2.length];

        while (i < arr1.length && j < arr2.length){
            if (arr1[i] > arr2[j]){
                temp[index++] = arr2[j];
                j++;
            }
            else {
                temp[index++] = arr1[i];
                i++;
            }
        }
        while (i < arr1.length) temp[index++] = arr1[i++];
        while (j < arr2.length) temp[index++] = arr2[j++];
        return temp;
    }

    public static int[] findSumAddUpToN(int[] arr, int sum){
//        O(n^2) solution
//        int[] res = new int[2];
//        for (int i = 0; i < arr.length; i++){
//            for (int j = i + 1; j < arr.length; j++){
//                if (arr[i] + arr[j] == sum) {
//                    res[0] = arr[i];
//                    res[1] = arr[j];
//                    return result;
//                }
//            }
//        }
//        return new int[]{};

        //O(n logn) solution - sorting takes O(nlogn) and the algorithm to find two numbers takes O(n) time, the overall time complexity of this code is O(nlogn).
        Arrays.sort(arr);
        int[] res = new int[2];
        int leftPointer = 0;
        int rightPointer = arr.length - 1;
        while (leftPointer != rightPointer){
            if (arr[leftPointer] + arr[rightPointer] == sum){
                res[0] = arr[leftPointer];
                res[1] = arr[rightPointer];
                return res;
            }
            else if(arr[leftPointer] + arr[rightPointer] < sum)
                leftPointer++;
            else // A[i] + A[j] > sum
                rightPointer--;
        }
        return new int[]{};
    }

    public static int[] findProduct(int[] arr){
//        O(n^2) solution
//        int[] res = new int[arr.length];
//        int index = 0;
//        for (int i = 0; i < arr.length; i++){
//            int prod = 1;
//            for (int j = 0; j < arr.length; j++){
//                if (i != j) prod *= arr[j];
//            }
//            res[index++] = prod;
//        }
//        return res;

        //O(n) solution
        int n = arr.length;
        int i, temp = 1;

        // Allocation of result array
        int[] result = new int[n];

        // Initializing the result array by 1
        for(int j=0; j < n; j++)
            result[j] = 1;

        // Product of elements on left side excluding arr[i]
        for (i = 0; i < n; i++)
        {
            result[i] = temp;
            temp *= arr[i];
        }

        // Initializing temp to 1 for product on right side
        temp = 1;

        // Product of elements on right side excluding arr[i]
        for (i = n - 1; i >= 0; i--)
        {
            result[i] *= temp;
            temp *= arr[i];
        }

        return result;
    }

    public static int smallestElement(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    public static int findFirstUnique(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) return arr[i];
        }

        return -1;
    }

    public static int[] reArrange(int[] arr){
//        //O(n^2) Solution
//        for (int i = 0; i < arr.length; i++){
//           for (int j = i + 1; j < arr.length; j++){
//               if (arr[i] > arr[j]){
//                   int temp = arr[j];
//                   arr[j] = arr[i];
//                   arr[i] = temp;
//               }
//           }
//        }
        //O(n) solution
        //In this solution, we keep two variables i and j. Both of them are 0 initially. i iterates over the array
        //while j keeps track of the position where next encountered negative number should be placed. When we come
        //across a negative number, the values at i and j indexes are swapped, and j is incremented. This continues until the end of the array is reached.
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {   // if negative number found
                if (i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j]; // swapping with leftmost positive
                    arr[j] = temp;
                }
                j++;
            }
        }
        return arr;
    }

    public static int[] maxMinOrder(int[] arr){
        int[] result = new int[arr.length];
        int last = arr[(arr.length - 1)/2];
        int i = 0; int j = arr.length - 1;
        int index = 0;
        while (i < j){
            result[index++] = arr[j--];
            result[index++] = arr[i++];
        }
        result[result.length-1] = last;
        return result;
    }
}
