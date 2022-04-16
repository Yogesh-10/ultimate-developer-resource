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
