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

### HOISTING

It is the process of assigning a variable declaration a default value of undefined during the memory creation phase

Phenomena in JS through which we can access the variables and functions even before they have initialized, without any error.

Variable and class *declarations* are also hoisted, so they too can be referenced before they are declared. Note that doing so can lead to unexpected errors, and is not generally recommended.

```jsx
getName();
console.log(x);
var x = 7;
function getName(){
    console.log("Namaste JavaScript");
}

Output:
Namaste JavaScript
undefined
```

```jsx
getName();
console.log(x);

function getName(){
    console.log("Namaste JavaScript");
}

Output:
Namaste JavaScript
Error: x is not defined //not defined and "undefined" are totally different
```

- Not defined: We have not initialized the value for variable anywhere in the entire code and in memory space.
- Undefined: It is a placeholder that is assigned to a variable by the Javascript Engine until the variable is assigned with some other value.

**Hoisting** is a concept which enables us to extract values of variables and functions even before initializing/assigning value without getting *error*

```jsx
console.log(getName);

var getName = function () {
	console.log('Namaste JavaScript');
};

var getName = () => {
	console.log('Namaste JavaScript');
};

output: undefined; //because they behave as variable and not function.
```

Reason for hoisting:

- The answer lies in the Global Execution Context. In the memory phase, the variables will be initialized as *undefined* and functions will get the whole function code in their memory.
- This is the reason why we are getting these outputs.

### CLOSURES, LEXICAL SCOPING:

Closure is the most misunderstood of JavaScript concepts

- Enables powerful pro-level functions like ‘once’ and ‘memoize’
- Many JavaScript design patterns including the module pattern use closure
- Build iterators, handle partial application and maintain state in an
  asynchronous world

Behavior of a function - Functions get a new memory every run/invocation

```jsx
function multiplyBy2(inputNumber) {
	const result = inputNumber * 2;
	return result;
}
const output = multiplyBy2(7);
const newOutput = multiplyBy2(10);
```

multiplyBy2 is invoked twice, and both run in different execution contexts and separate from each other.

**Function with memories(closures):**

A **closure** is the combination of a function bundled together (enclosed) with references to its surrounding state (the **lexical environment**). In other words, a closure gives you access to an outer function's scope from an inner function. In JavaScript, closures are created every time a function is created, at function creation time.

Functions with memories

- When our functions get called, we create a live store of data (local memory/variable environment/state) for that function’s execution context.
- When the function finishes executing, its local memory is deleted (except the returned value)
- But what if our functions could hold on to live data between executions?
- This would let our function definitions have an associated cache/persistent memory
- But it all starts with us returning a function from another function

Functions can be returned from another functions in javascript, since function in js are first class citizens

```jsx
function createFunction() {
	function multiplyBy2(num) {
		return num * 2;
	}
	return multiplyBy2;
}
const generatedFunc = createFunction();
const result = generatedFunc(3); // 6
```

Calling a function outside of the function call in which it was defined

```jsx
function outer() {
	let counter = 0;
	function incrementCounter() {
		counter++;
	}
	return incrementCounter;
}

const myNewFunction = outer();
myNewFunction();
myNewFunction();
```

**Lexical Scope -** When a function is defined, it gets a bond to the surrounding Local Memory
(“Variable Environment”) in which it has been defined

The word *lexical* refers to the fact that lexical scoping uses the location where a variable is declared within the source code to determine where that variable is available. Nested functions have access to variables declared in their outer scope.

- Scope is directly dependent on the lexical environment
- **Lexical Environment** : local memory + lexical env of its parent
- Whenever an EC is created, a Lexical environment(LE) is also created and is referenced in the local EC(in memory space)

It comprises of local memory and ‘reference’ (and not ‘copy’) of lexical environment of its parent. For Global Exec. Context, lexical environment points to null.

```jsx
function a() {
	c();
	var b = 10;
	function c() {
		console.log(b);
	}
}
a();
```

Diagram for above code,

![image](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/49191fe6-c6e0-4b5e-a24a-0b35e39a4ff1/Untitled.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20220403%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20220403T163618Z&X-Amz-Expires=86400&X-Amz-Signature=ec48091fde1928c21769732b8be9beea9698accdef14dd5c4ff81cfdb4d5bddb&X-Amz-SignedHeaders=host&response-content-disposition=filename%20%3D%22Untitled.png%22&x-id=GetObject)

Whenever a variable is encountered while execution, it is first searched in the local memory space and if not found, it goes to the lexical environment of its parent and perform the same step, until found or reaches global scope.

As seen in above diagram, here first we have global execution context, and we have execution context for a( ) and we have execution context for b( ), for a( ) - lexical environment is it’s local memory + lexical environment of parent i.e, global execution context, and for b( ) → lexical environment is it’s local memory + lexical environment of parent i.e, a( ) + global execution context.

**Closure code explanation**

```jsx
function outer() {
	let counter = 0;
	function incrementCounter() {
		counter++;
	}
	return incrementCounter;
}

const myNewFunction = outer();
myNewFunction(); //1
myNewFunction(); //2
```

when we run this code, outer( ) is called, the local memory of outer has counter and incrementCounter function, and we return incrementCounter function from outer. now the result of calling outer is stored in myNewFunction which is function body of incrementCounter.

Now that, outer has finished execution and removed from callstack. Now we have myNewFunction which is function definition of incrementCounter, so we can invoke it. But when we invoke myNewFunction( ), the function body has counter++, but we don’t have access to counter inside incrementCounter. But javascript stores the function body along with variables in lexical scope of that function, what this means is js stores whole function body of incrementCounter in to myNewFunction, and along with it there is an hidden property [[scope]] which contains variables in lexical environment, in this example - counter. we can’t access the value of counter because it is a hidden property, we can get result of counter only by running the myNewFunction( ).

step 1: when we invoke myNewFunction( ), a brand new execution context is created and when code runs, there is no counter in local memory, so we check it’s parent which is global scope, there we have newFunction variable is in global scope, which has function body along with variables in lexical environment. counter is 0 and now increased to 1.

So newFunction variable is in global scope, which has function body along with variables in lexical environment, so when myNewFunction( ) is invoked again there is no local memory inside execution context of myNewFunction( ) so it looks in global memory where counter is 1, which is increased by 1 and now value of counter is 2

![image](https://user-images.githubusercontent.com/71348279/161438243-01632fb0-e272-4a18-b0f7-92cee66c3a2b.png)

The hidden property [[scope]] we can refer them as ‘backpack’ since they carry extra variables in it’s lexical scope along with function definition

The ‘backpack’ (or ‘closure’) of live data is attached incrementCounter (then to
myNewFunction) through a hidden property known as [[scope]] which persists
when the inner function is returned out

The ‘backpack’ -

We return incrementCounter’s code (function definition) out of outer into global and give it a new name - myNewFunction

- We maintain the bond to outer’s live local memory - it gets ‘returned out’ attached on the back of incrementCounter’s function definition.
- So outer’s local memory is now stored attached to myNewFunction - even though outer’s execution context is long gone
- When we run myNewFunction in global, it will first look in its own local memory first (as we’d expect), but then in myNewFunction’s ‘backpack’

Technical terms for ‘backpack’

- Closed over ‘Variable Environment’ (C.O.V.E.)
- Persistent Lexical Scope Referenced Data (P.L.S.R.D.)
- ‘Backpack’
- ‘Closure’

Example 2

```jsx
function outer() {
	let counter = 0;
	function incrementCounter() {
		counter++;
	}
	return incrementCounter;
}

const myNewFunction = outer();
myNewFunction(); //1
myNewFunction(); //2

//Let’s run outer again
const anotherFunction = outer();
anotherFunction(); //1
anotherFunction(); //2
```

Both maintain different execution context as outer creates new execution context, which is completely different from myNewFunction and anotherFunction. so we get individual backpack to each function call for outer( )

If we run 'outer' again and store the returned 'incrementCounter' function
definition in 'anotherFunction', this new incrementCounter function was created in
a new execution context and therefore has a brand new independent backpack

**Closure Advantages and uses**

Closure gives our functions persistent memories and entirely new toolkit for writing professional code

**Helper functions**: Everyday professional helper functions like ‘once’ and ‘memoize’
**Iterators and generators**: Which use lexical scoping and closure to achieve the most contemporary patterns for handling data in JavaScript
**Module pattern**: Preserve state for the life of an application without polluting the global namespace
**Asynchronous JavaScript**: Callbacks and Promises rely on closure to persist state in an asynchronous environment
