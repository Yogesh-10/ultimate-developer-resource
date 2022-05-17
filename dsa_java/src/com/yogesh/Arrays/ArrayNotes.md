### **Arrays**

An array is a collection of items stored at contiguous memory locations. The idea is to store multiple items of the same type together

We can access the elements in the array using index, which looks up the value in the array by its memory location.

Arrays are much faster because we can access its value by index

Eg: [1, 2, 3, 4, 5]. We can access first element by arr[0] //This is constant lookup O(1)

**Types of Array**

****One-dimensional array

Multi-dimensional array

Multi dimensional arrays are used to store data in the form of matrices or tables.

**Disadvantages of array**

Arrays cannot shrink or grow, Because the memory of arrays is allocated statically. If we had to add new elements in an array we have to create a new array and copy the elements. This is costly and runs in linear time O(N)

**Summary & Time Complexity**

****Arrays are great when we know the exact size of elements to store in them

Arrays are faster when look up by index

Time Complexity:

LookUp By Index - O(1)

LookUp By value - O(N) because we have loop over entire array

Insert - O(N) - because we have to iterate over array and increase size if it gets full and copy the elements to new array

Delete -O(N) - Because we have to shift the items to fill the gap by iterating over array