### DATA TYPES

**Variable -** a variable is a container (storage area) to hold data, Eg: let num = 5;

Variables can be declared using let, const and var(mostly avoid var)

(let, const, var) - more about that later

**Number Type -** In javascript, There is no int type or float type, if we declare, let a = 10 or let b = 10.3, both will  be of type **Number** - we can check the type by,

```jsx
let a = 10;
let b = 10.3;
console.log(typeof a); //Number
console.log(typeof b); //Number
```

**String type** - string is nothing but a sequence of characters,enquoted in single or double quotes

```jsx
const firstName = 'John';
const lastName = 'Doe';
console.log(typeof firstName); //string
```

**Boolean** - Boolean represents a true or false value.

```jsx
const happy = true;
const fun = false;

//we can invert a boolean value using ! operator
const isEating = true;
console.log(!isEating); //false
console.log(!!isEating); //true - !! means it is inverted twice.

console.log(happy && fun); //false && - both is true - return true
console.log(happy || fun); //true  || - any one of value is true return true
```

**Null vs Undefined(Respresents a lack of value)**

**Undefined** - undefined means the variable is only declared and not set to any value or the value is not assigned to that variable.It’s not advisable to set an variable to undefined explicitly

```jsx
let a;
console.log(a); //undefined
//we can also set a variable to undefined(but never do this)
let b = undefined;
console.log(b); //undefined
```

**Null** - Null means the value of variable is empty. we explicitly set the value to null to tell that it does not contains any value or the value is empty. Usually, null is used to assign an 'unknown' or 'empty' value to a variable.

```jsx
let a = null;
console.log(a); //null
```

Interesting note:

```jsx
let a = null;
let b = undefined;
console.log(a == b); //true (because they both result in lack of value,
//so true is defined)
console.log(a === b); //false
```

### **Garbage Collection in JavaScript:**

garbage collection is used to clean up the unused memory in the program. For example, if we declare millions of variable, it will take up a lot of memory and that is very bad, and cause the computer to crash,

so the job of the garbage collector is to check the program once in a while and check for unused memory, for example, if a variable is declared and used, and it is not used or not needed in any other part of the program, garbage collector cleans it up and free’s up the unused memory💥 (all the work is done by JS behind the scenes)

### **Functions:**

functions are used to encapsulate code into one single block, which can be reused later at any part of the code.

Code we save (‘define’) functions & can use (call/invoke/execute/run) later with the function’s name & ()

Functions are one of the fundamental building blocks in JavaScript. A function in JavaScript is similar to a procedure—a set of statements that performs a task

```jsx
function print() {
  //function expression
  return 'hello';
}
console.log(print()); //hello
```

### **Passing functions as arguments**

Functions can be passed as arguments into another function. When we print the function without calling it, let's see what happens.

```jsx
function print() {
  return 'hello';
}
console.log(print);
/* ƒ print(){
	return "hello";
}
*/
```

as seen above output, we can see the whole function printed inside the console. Let’s see how this works, first the function is assigned to the variable as print, because that’s the name of our function, and then when we console.log that variable, it prints the whole function because we have stored the function inside the print variable.

we can use this as an advantage and pass this variable as an argument into other functions. let’s see a example of it

```jsx
function one() {
  console.log('hello');
}

function two(x) {
  x();
}
two(one); //hello
```

This is called as callback function, passing a function as an argument

### **Callback functions**

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

### **Arrow Functions**

Arrow functions do not have their this and arguments keyword, like the regular function.

If we use this in arrow function it will point to the global window object.

Arrow functions are not hoisted.

```jsx
const func = (a, b) => {
  return a + b;
};
func(1, 2); //3
```

If there is only one line inside function we can omit curly braces and return keyword.

```jsx
const func = (a, b) => a + b;
func(1, 2); //3
```
