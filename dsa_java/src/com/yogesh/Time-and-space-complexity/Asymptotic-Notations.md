### **Time and Space complexity**

**Big O - Notation**

We use  Big O to determine performance of an algorithm (which helps us determine given algo is scalable or not and how it perform when the dataset grows)

**1. O(1) - constant Time**

```java
int[] arr = {1,2,3,45};
System.out.println(arr[1]);
```

This is a constant lookup using index. Which takes only constant time

**2. O(N) - Linear Time complexity**

It represents the complexity of a function that increases linearly and in direct proportion to the number of inputs.

**Eg: 1**

```java
for(int i=0; i<arr.length; i++) //O(N)
System.out.println(i);
```

This is O(N) because as array length grows time also grows, This is called a linear time complexity.

**Eg: 2**

```java
System.out.println(“Hi”); //O(1)
for(int i=0; i<arr.length; i++) //O(N)
		System.out.println(i);
System.out.println(“Java”); //O(1)
```

Time complexity for the above soln is - O(1) + O(1) + O(N) = O(2 + N) //we usually drop constants bcoz it doesn’t have a huge impact in complexity. So it is O(N)

**Eg: 3**

```java
for(int i=0; i<nums.length; i++) //O(N)
		System.out.println(i);

for(int i=0; i<names.length; i++) //O(M)
		System.out.println(i);
```

Here we have two diff arrays, names and nums so we can write as O(N + M). however we drop M and write as O(N) because it increases linearly

**Eg: 4**

```java
for(int i=0; i<nums.length; i++) //O(N)
		System.out.println(i);

for(int i=0; i<names.length; i++)
		System.out.println(i); //O(M). So this is O(N*M)
```

**3. Big O(N^2)-Quadratic Time Complexity**

Big O(N^2) is quadratic time complexity and it is slower than O(N).

**Eg1:**

```java
for(int i=0; i<nums.length; i++) //O(N)
	for(int j=1; i<nums.length; j++) //O(N)
			System.out.println(i + j);
```

O(N * N) = O(N^2). This is a quadratic time complexity with nested loops. If there are three nested loops then it is **O(N^3).**

**Eg2:**

```java
for(int i=0; i<nums.length; i++) //O(N)
	System.out.println(i);

for(int i=0; i<nums.length; i++) //O(N)
	for(int j=1; i<nums.length; j++) //O(N)
		System.out.println(i + j);
```

For this example, it is O(N + N^2). O(N^2) is more costlier than O(N) so we drop it and the time complexity is still quadratic O(N^2)

**4. O(Log n) - Logarithmic N**

A loop statement that **multiplies/divides the loop** variable by a constant takes O(log n) time because the loop runs that many times

Eg1:

```java
i = //constant
n = //constant
k = //constant
while (i < n){
    i*=k;
    // Statement(s) that take(s) constant time
}
```

Big O(Log n) is logarithmic time complexity which is more faster and efficient than linear and quad time complexity.

O(Log n) - **Narrows down the problems by half** and the time taken is much more efficient

**Eg:** Binary search, divide and conquer algorithms.

**5. O(2^N) - Exponential**

This is the opposite of logarithmic time complexity which is much slower.

In logarithmic the curve reduces as input grows, but here the curve grows as fast as input grows which makes it very slow.

**Space Complexity**

Space complexity is a measure of how efficient your code is in terms of memory used.

Space complexity analysis happens almost in the same way time complexity analysis happens. Additional space / memory is measured in terms of the largest memory used by the program when it runs. That is to say, if you allocated O(N) memory, and later freed it, that does not make the space complexity of your program O(1).**For space complexity we should look only at additional space relative to size of input**

Space complexity is a parallel concept to time complexity. If we need to create an array of size n, this will require O(n) space. If we create a two-dimensional array of size n*n, this will require O(n2) space.