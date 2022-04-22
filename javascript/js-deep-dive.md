### Execution Context

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
