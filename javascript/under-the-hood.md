### JAVASCRIPT UNDER THE HOOD

### JavaScript principles

```jsx
const num = 3;
function multiplyBy2(inputNumber) {
	const result = inputNumber * 2;
	return result;
}

const output = multiplyBy2(num);
const newOutput = multiplyBy2(10);
```

When JavaScript code runs, it: Goes through the code line-by-line and runs/ ’executes’ each line - known as the `thread of execution` Saves ‘data’ like strings and arrays so we can use that data later - in its `memory` We can even save code (‘functions’)

## **Functions**

Code we save (‘define’) functions & can use (call/invoke/execute/run) later with the function’s name & ( )

## **Execution context**

Created to run the code of a function - has 2 parts

- Thread of execution
- Memory(saves data)

\***\*Everything in JS happens inside the execution context.\*\***
Assume execution context to be a big box where everything takes place. It has 2 components in it:

**Memory creation phase :** The place where all the variables and functions are stored as (key: value) pairs. For variable(s), key is the variable name itself and value is undefined (even if the variable is initialized). And, for function(s), key is the function name and value is body of the
code. Memory component is also known as **_`variable environment_.`**

**Code execution phase:** The place where code is executed line by line at a time. Code component is also known as **_`Thread of Execution`._** A new ‘local’ execution context is created, when function ‘invocation’ is encountered. Again, two phase perform their role.

**JS is a synchronous single-threaded language.** By single threaded, we mean JS can only run 1 command at a time. By synchronous single threaded, we mean it can run 1 command at a time, *in a specific order*

Example:

```jsx
const x = 10; //will be undefined in memory creation phase and 10 will be assigned during code is executed

function calculateVal(a, b) {
	const res = a * b;
	return res;
}
```

![image](https://user-images.githubusercontent.com/71348279/161437933-16592655-765a-45c4-ba78-fc90a0861b3b.png)

## Call Stack

JavaScript keeps track of what function is currently running (where’s the thread of execution)

- Run a function - add to call stack
- Finish running the function - JS removes it from call stack
- Whatever is top of the call stack that’s the function we’re
  currently running

> **Call Stack maintains the order of execution of execution contexts**

Call stack, with Global execution context at the bottom and all the subsequent function invocation or new execution context is pushed to this call stack. Once the execution context is done with the task, it is popped. Well, call stack is also called by names like, Execution context, Program, Machine, Control, Runtime stack

Everytime you run a program, an execution context is created. When a variable or function is encountered, it is stored in the memory area.

```jsx
const num = 3;
function multiplyBy2(inputNumber) {
	const result = inputNumber * 2;
	return result;
}
const output = multiplyBy2(num);
const newOutput = multiplyBy2(10);
```

Now first, for this entire code a **Global** execution context is created.

**In the first phase (memory creation)**

- Memory is allocated to variables and functions.
- For variable name(which is key) it assigns a value of **undefined**
- For the function name(which is key) it assigns the entire function code as value.

```jsx
num:undefined
multiplyBy2: {...function...}
output:undefined
newOutput:undefined
```

**In the second phase (code execution)**

- The variable name is replaced with its actual assigned value from code. So now num: 3
- Skips over function code as there is nothing to assign there.
- We encounter a function call in output. So a brand new local EC is created inside the code part of global EC and this will have the same 2 components: Memory and Code.
- In the local EC, inputNumber and result are both undefined (in first phase). Then, the num value in global EC is passed to inputNumber, replacing undefined. inputNumber is the parameter and num is the argument.
- result = inputNumber\*2 (calculated in code part of local EC and returned) replaces undefined in local EC (memory part) and the final value is returned from local and is assigned to output in global. After returning, local EC is removed form global EC(popped off from call stack) and control goes back to global.
- same thing happens with newOutput

To manage all these EC, a call **stack** is created. Every time code is run, the EC is pushed in. So first global EC is pushed. Then multiplyBy2 EC(for output ) is pushed, and then after value returned, is popped. Similarly multiplyBy2 EC(for newOutput) is pushed, and then popped and finally Global is also popped and stack is empty.

![image](https://user-images.githubusercontent.com/71348279/161437786-42dc345e-a2fb-4f25-9ecf-e61866adfb82.png)

## Callbacks and Higher Order Functions

One of the most misunderstood concepts in JavaScript

- Enables powerful pro-level functions like map, filter, reduce (a core aspect of
  functional programming)
- Makes our code more declarative and readable

### **Higher Order Functions**

A programming language is said to have **First-class functions** when functions in that language are treated like any other variable. For example, in such a language, a function can be passed as an argument to other functions, can be returned by another function and can be assigned as a value to a variable.

**Functions in javascript = first class objects**(means function have everything that object have) - in javascript functions are basically objects.

They can co-exist with and can be treated like any other javascript object

1. Assigned to variables and properties of other objects
2. Passed as arguments into functions
3. Returned as values from functions

‘Parameters’ (placeholders) mean we don’t need to decide what data to run our
functionality on until we run the function

- Then provide an actual value (‘argument’) when we run the function
  Higher order functions follow this same principle.
- We may not want to decide exactly what some of our functionality is until we
  run our function

```jsx
function copyArrayAndManipulate(array, instructions) {
	const output = [];
	for (let i = 0; i < array.length; i++) {
		output.push(instructions(array[i]));
	}
	return output;
}

function multiplyBy2(input) {
	return input * 2;
}
const result = copyArrayAndManipulate([1, 2, 3], multiplyBy2);
```

**Which is our Higher Order Function?**
The outer function(copyArrayAndManipulate) that takes in a function is our higher-order function

**Which is our Callback Function?**
The function we insert(pass as an argument) is our callback function

### Callback Function

A callback function is a function passed into another function as an argument, which is then invoked inside the outer function to complete some kind of routine or action.

```jsx
function sumCallback(a, b, callback) {
	callback(a + b);
}

function handleSum(sum) {
	console.log(sum);
}

sumCallback(1, 2, handleSum); // output - 3
```

Callback function is nothing but, a function is called only when a particular event is happening. In our example, a callback function(handleSum) is passed into sumCallback function, so its the responsibility of sumCallback function to call the handleSum method at any point inside that function(it is not necessary to be called immediately). It can be called even after 10 lines inside sumCallback function. So, it is basically calling back the function when required, thus the name callback function.

we can also pass a anonymous callback function(a function without a name)

```jsx
function sumCallback(a, b, callback) {
	callback(a + b);
}

sumCallback(1, 2, function (sum) {
	console.log(sum);
}); //3
```

**Callback and higher order functions uses:**

Callbacks and Higher Order Functions simplify our code and keep it DRY(Don’t repeat yourself)

**Declarative readable code**: Map, filter, reduce - the most readable way to write
code to work with data
**Asynchronous JavaScript**: Callbacks are a core aspect of async JavaScript, and are
under-the-hood of promises, async/await
