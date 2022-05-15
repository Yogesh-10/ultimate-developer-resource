## 1. Execution Context

Created to run the code of a function - has 2 parts

- Thread of execution
- Memory(saves data)

Everything in JS happens inside the execution context. Imagine a closed container inside which JS runs. It is an abstract concept that hold info about the env. within the context, current code is being executed.

- In the container the first component is **memory component** and the 2nd one is **code component**
- Memory component has all the variables and functions in key value pairs. It is also called **Variable environment**.
- Code component is the place where code is executed one line at a time. It is also called as **Thread of Execution**.
- JS is a **synchronous**, **single-threaded** language
    - Synchronous:- One command at a time.
    - Single-threaded:- In a specific synchronous order.

```jsx
const x = 10; //will be undefined in memory creation phase and 10 will be assigned during code is executed

function calculateVal(a, b){
	const res = a * b;
	return res;
}
```
![image](https://user-images.githubusercontent.com/71348279/164771514-dc6245ac-c49a-4bc1-a5de-917df22334cc.png)



## 2. How JS is executed & Call Stack

- **Memory creation phase :** The place where all the variables and functions are stored as (key: value) pairs. For variable(s), key is the variable name itself and value is undefined (even if the variable is initialized). And, for function(s), key is the function name and value is body of the
code. Memory component is also known as ***`variable environment*.`**
- **Code execution phase:** The place where code is executed line by line at a time. Code component is also known as ***`Thread of Execution`.*** A new ‘local’ execution context is created, when function ‘invocation’ is encountered. Again, two phase perform their role.
- Javascript manages code execution context creation and deletion with the the help of **Call Stack**.
- Call Stack is a mechanism to keep track of its place in script that calls multiple function.
- Call Stack maintains the order of execution of execution contexts. It is also known as Program Stack, Control Stack, Runtime stack, Machine Stack, Execution context stack.

JavaScript keeps track of what function is currently running (where’s the thread of execution)

- Run a function - add to call stack
- Finish running the function - JS removes it from call stack
- Whatever is top of the call stack that’s the function we’re
currently running

> **Call Stack maintains the order of execution of execution contexts**
>

Call stack, with Global execution context at the bottom and all the subsequent function invocation or new execution context is pushed to this call stack. Once the execution context is done with the task, it is popped. Well, call stack is also called by names like, Execution context, Program, Machine, Control, Runtime stack

Every time you run a program, an execution context is created. When a variable or function is encountered, it is stored in the memory area.

```jsx
const num = 3;
function multiplyBy2 (inputNumber){
const result = inputNumber*2;
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
- result = inputNumber*2 (calculated in code part of local EC and returned) replaces undefined in local EC (memory part) and the final value is returned from local and is assigned to output in global. After returning, local EC is removed form global EC(popped off from call stack) and control goes back to global.
- same thing happens with newOutput

To manage all these EC, a call **stack** is created. Every time code is run, the EC is pushed in. So first global EC is pushed. Then multiplyBy2 EC(for output ) is pushed, and then after value returned, is popped. Similarly multiplyBy2 EC(for newOutput) is pushed, and then popped and finally Global is also popped and stack is empty.

![image](https://user-images.githubusercontent.com/71348279/164771821-298fe1b8-1c74-4e2c-9add-f7112894cd97.png)



## 3. Hoisting in JavaScript (variables & functions)

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

- It should have been an outright error in many other languages, as it is not possible to even access something which is not even created (defined) yet But in JS, We know that in memory creation phase it assigns undefined and puts the content of function to function's memory. And in execution, it then executes whatever is asked. Here, as execution goes line by line and not after compiling, it could only print undefined and nothing else. This phenomenon, is not an error. However, if we remove var x = 7; then it gives error. Uncaught ReferenceError: x is not defined
- **Hoisting** is a concept which enables us to extract values of variables and functions even before initializing/assigning value without getting error and this is happening due to the 1st phase (memory creation phase) of the Execution Context.
- So in previous topic, we learnt that execution context gets created in two phase, so even before code execution, memory is created so in case of variable, it will be initialized as undefined while in case of function the whole function code is placed in the memory. Example:

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
console.log(getName)

var getName = function () {
    console.log("Namaste JavaScript");
}

var getName = () => {
    console.log("Namaste JavaScript");
}

output: undefined //because they behave as variable and not function.
```

Reason for hoisting:

- The answer lies in the Global Execution Context. In the memory phase, the variables will be initialized as *undefined* and functions will get the whole function code in their memory.
- This is the reason why we are getting these outputs.



## 4. Functions and Variable Environments

```jsx
var x = 1;
a();
b(); // we are calling the functions before defining them. This will work properly, as seen in Hoisting.
console.log(x);

function a() {
  var x = 10; // local scope because of separate execution context
  console.log(x);
}

function b() {
  var x = 100;
  console.log(x);
}
```

**Code Flow in terms of Execution Context**

- The Global Execution Context (GEC) is created (the big box with Memory and Code subparts). Also GEC is pushed into Call Stack

> Call Stack : GEC
>
- In first phase of GEC (memory phase), variable x:undefined and a and b have their entire function code as value initialized
- In second phase of GEC (execution phase), when the function is called, a new local Execution Context is created. After x = 1 assigned to GEC x, a() is called. So local EC for a is made inside code part of GEC.

> Call Stack: [GEC, a()]
>
- For local EC, a totally different x variable assigned undefined(x inside a()) in phase 1 , and in phase 2 it is assigned 10 and printed in console log. After printing, no more commands to run, so a() local EC is removed from both GEC and from Call stack

> Call Stack: GEC
>
- Cursor goes back to b() function call. Same steps repeat.

> Call Stack :[GEC, b()] -> GEC (after printing yet another totally different x value as 100 in console log)
>
- Finally GEC is deleted and also removed from call stack. Program ends.


## 5. Shortest JS Program, window & this keyword

- The shortest JS program is empty file. Because even then, JS engine does a lot of things. As always, even in this case, it creates the GEC which has memory space and the execution context.
- JS engine creates something known as '**window**'. It is an object, which is created in the global space. It contains lots of functions and variables. These functions and variables can be accessed from anywhere in the program. JS engine also creates a **this** keyword, which points to the **window object** at the global level. So, in summary, along with GEC, a global object (window) and a this variable are created.
- In different engines, the name of global object changes. Window in browsers, but in nodeJS it is called something else. At global level, this === window
- If we create any variable in the global scope, then the variables get attached to the global object.

```jsx
var x = 10;
console.log(x); // 10
console.log(this.x); // 10
console.log(window.x); // 10
```

## 6. undefined vs not defined in JS

- In first phase (memory allocation) JS assigns each variable a placeholder called **undefined**.
- **undefined** is when memory is allocated for the variable, but no value is assigned yet.
- If an object/variable is not even declared/found in memory allocation phase, and tried to access it then it is **Not defined**
- Not Defined !== Undefined

> When variable is declared but not assigned value, its current value is undefined. But when the variable itself is not declared but called in code, then it is not defined.
>

```jsx
console.log(x); // undefined
var x = 25;
console.log(x); // 25
console.log(a); // Uncaught ReferenceError: a is not defined
```

- JS is a **loosely typed / weakly typed** language. It doesn't attach variables to any datatype. We can say *var a = 5*, and then change the value to boolean *a = true* or string *a = 'hello'* later on.
- **Never** assign *undefined* to a variable manually. Let it happen on it's own accord.


## 7. The Scope Chain, Scope & Lexical Environment

**Lexical Scope -**  When a function is defined, it gets a bond to the surrounding Local Memory
(“Variable Environment”) in which it has been defined

The word *lexical* refers to the fact that lexical scoping uses the location where a variable is declared within the source code to determine where that variable is available. Nested functions have access to variables declared in their outer scope.

- **Scope is directly dependent on the lexical environment**
- **Lexical Environment** : local memory + lexical env of its parent
- Whenever an EC is created, a Lexical environment(LE) is also created and is referenced in the local EC(in memory space)

### **scope and scope chain examples**:

```jsx
// CASE 1
function a() {
    console.log(b); // 10
    // Instead of printing undefined it prints 10, So somehow this a function could access the variable b outside the function scope.
}
var b = 10;
a();
```

```jsx
// CASE 2
function a() {
    c();
    function c() {
        console.log(b); // 10
    }
}
var b = 10;
a();
```

```jsx
// CASE 3
function a() {
    c();
    function c() {
        var b = 100;
        console.log(b); // 100
    }
}
var b = 10;
a();
```

```jsx
// CASE 4
function a() {
    var b = 10;
    c();
    function c() {
        console.log(b); // 10
    }
}
a();
console.log(b); // Error, Not Defined
```

- Let's try to understand the output in each of the cases above.
    - In **case 1**: function a is able to access variable b from Global scope.
    - In **case 2**: 10 is printed. It means that within nested function too, the global scope variable can be accessed.
    - In **case 3**: 100 is printed meaning local variable of the same name took precedence over a global variable.
    - In **case 4**: A function can access a global variable, but the global execution context can't access any local variable.

        ```jsx
        To summarize the above points in terms of execution context:
        call_stack = [GEC, a(), c()]
        Now lets also assign the memory sections of each execution context in call_stack.
        c() = [[lexical environment pointer pointing to a()]]
        a() = [b:10, c:{}, [lexical environment pointer pointing to GEC]]
        GEC =  [a:{},[lexical_environment pointer pointing to null]]
        ```


Lexical env - comprises of local memory and ‘reference’ (and not ‘copy’) of lexical environment of its parent. For Global Exec. Context, lexical environment points to null.

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

![image](https://user-images.githubusercontent.com/71348279/164773041-9afe8916-b28b-4900-ab69-d1bbd24efdb8.png)

Whenever a variable is encountered while execution, it is first searched in the local memory space and if not found, it goes to the lexical environment of its parent and perform the same step, until found or reaches global scope.

As seen in above diagram, here first we have global execution context, and we have execution context for a( ) and we have execution context for b( ), for a( ) - lexical environment is it’s local memory + lexical environment of parent i.e, global execution context, and for b( ) → lexical environment is it’s local memory + lexical environment of parent i.e, a( ) + global execution context.

## 8. let & const in JS, Temporal Dead Zone, Type of Errors

- let & const are hoisted but stored in different memory space than other variables like var. (And hence they cannot be access via window object or this specifier). They cannot be accessed until they’re initialized.
- Hence, the time from hoisting these variable(s) and initialization is temporal dead zone, and during this we cannot access let & const, in turns throws Reference error.
let cannot be re-declared in the same scope unlike var, it will throw Syntax Error.
- In case of const we need to declare and initialize at the same line/time.
If we try changing the value later at some line to const variable, we’ll get Type Error.
- let and const declarations are hoisted. But its different from **var**

```jsx
console.log(a); // ReferenceError: Cannot access 'a' before initialization
console.log(b); // prints undefined as expected
let a = 10;
console.log(a); // 10
var b = 15;
console.log(window.a); // undefined
console.log(window.b); // 15
```

It looks like let isn't hoisted, **but it is**, let's understand

- Both a and b are actually initialized as *undefined* in hoisting stage. But var **b** is inside the storage space of GLOBAL, and **a** is in a separate memory object called **script**, where it can be accessed only after assigning some value to it first ie. one can access 'a' only if it is assigned. Thus, it throws error.
- **Temporal Dead Zone** : Time since when the let variable was hoisted until it is initialized some value.
    - So any line till before "let a = 10" is the TDZ for a
    - Since a is not accessible on global, its not accessible in *window/this* also. window.b or this.b -> 15; But window.a or this.a ->undefined, just like window.x->undefined (x isn't declared anywhere)
- **Reference Error** are thrown when variables are in temporal dead zone.
- **Syntax Error** doesn't even let us run single line of code.

```jsx
let a = 10;
let a = 100;  //this code is rejected upfront as SyntaxError. (duplicate declaration)
------------------
let a = 10;
var a = 100; // this code also rejected upfront as SyntaxError. (can't use same name in same scope)
```

- **Let** is a stricter version of **var**. Now, **const** is even more stricter than **let**.

```jsx
let a;
a = 10;
console.log(a) // 10. Note declaration and assigning of a is in different lines.
____________________
const b;
b = 10;
console.log(b); // SyntaxError: Missing initializer in const declaration. (This type of declaration won't work with const. const b = 10 only will work)
____________________
const b = 100;
b = 1000; //this gives us TypeError: Assignment to constant variable.
```

- Types of **Error**: Syntax, Reference, and Type.
    - Uncaught ReferenceError: x is not defined at ...
        - This Error signifies that x has never been in the scope of the program. This literally means that x was never defined/declared and is being tried to be accesed.
    - Uncaught ReferenceError: cannot access 'a' before initialization
        - This Error signifies that 'a' cannot be accessed because it is declared as 'let' and since it is not assigned a value, it is its Temporal Dead Zone. Thus, this error occurs.
    - Uncaught SyntaxError: Identifier 'a' has already been declared
        - This Error signifies that we are redeclaring a variable that is 'let' declared. No execution will take place.
    - Uncaught SyntaxError: Missing initializer in const declaration
        - This Error signifies that we haven't initialized or assigned value to a const declaration.
    - Uncaught TypeError: Assignment to constant variable
        - This Error signifies that we are reassigning to a const variable.

        **Note**: In case of const array or object, if we try to change the value, it is
        perfectly fine/valid. The property of a const object can be change but it
        cannot be change to reference to the new object.

        **BEST PRACTICES:**

    - Try using const wherever possible.
    - If not, use let, Avoid var.
    - Declare and initialize all variables with let to the top to avoid errors to shrink temporal dead zone window to zero.
