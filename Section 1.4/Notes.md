# 1.4 — Arrays

## 1.4.1 — Accessing Array Elements
### Code
```java
int[] a = new int[1000];
System.out.println(a[1000]);
```
### Result
- This code will throw a runtime `ArrayIndexOutOfBoundsException` because the indices of an array start at `0`, not 1
- So the starting index is `0` and the final index is `999`
- Index `1000` does not exist

## 1.4.2 — Super Long Array
### Question
- Describe and explain what happens when you try to compile a program with the following statement
```java
int n = 1000;
int[] a = new int[n*n*n*n];
```
### Result
- There are two main problems with this code, the first being the `NegativeArraySizeException`
- This exception is caused because of the integer overflow
- The value `n^4` is too large for an integer; this causes it to wrap around to negative numbers
- The second issue with this code, ignoring the negative value, is that all array lengths are stored as integers, which means the longest array you can have is `Integer.MAX_VALUE`
- PS. Sometimes JVM can have other restrictions on length depending on the version and use case, as well as memory allocation limits

## 1.4.3 — Method `vectorEuclideanDistance`
- Method name: `vectorEuclideanDistance`
- Inputs: `int[] vectorOne, int[] vectorTwo`
- Returns: `None`
- Description: Prints the Euclidean distance between the two given vectors represented as 1-D arrays

## 1.4.4 — Method `reverseArray`
- Method name: `reverseArray`
- Inputs: `String[] arr`
- Returns: `None`
- Description: Prints the original array, then prints the array in reverse order

## 1.4.5 — Making an Array
### Question 
- What is wrong with the following code fragment?
```java
int[] a;
for (int i = 0; i < 10; i++)
    a[i] = i * i;
```
### Result
- You will receive a compiler error stating `variable a might not have been initialized`
- If it has not been initialized, then it is still `null`, and has no memory address

## 1.4.7 — Loopty Loop Array
### Question 
- What does the following code fragment print?
```java
int[] a = new int[10];
for (int i = 0; i < 10; i++)
    a[i] = 9 - i;
for (int i = 0; i < 10; i++)
    a[i] = a[a[i]];
for (int i = 0; i < 10; i++)
    System.out.println(a[i]);
```
### Result
```
0
1
2
3
4
4
3
2
1
0
```

## 1.4.8 — Array Sequence
### Question
- Which values does the following code put in the array a[]?
```java
int n = 10;
int[] a = new int[n];
a[0] = 1;
a[1] = 1;
for (int i = 2; i < n; i++)
    a[i] = a[i-1] + a[i-2];
```
### Result
- This returns the first `10` digits of the Fibonacci Sequence
```
[1, 1, 2, 3, 5, 8, 13, 21, 34, 55]
```

## 1.4.9 — Equal Arrays
### Question
- What does the following code fragment print?
```java
int[] a = { 1, 2, 3 };
int[] b = { 1, 2, 3 };
System.out.println(a == b);
```
### Result
- This code returns `false` because arrays are `reference` types, which means that the `==` operator checks the memory address, not the contents of the addresses
