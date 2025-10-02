# 1.3 — Conditionals and Loops

## 1.3.1 — Method `threeEqual`
- Method name: `threeEqual`
- Inputs: `int a, int b, int c`
- Returns: `None`
- Description: Prints `Equal` to the console if `a == b == c` is true, otherwize it returns `Not Equal`.

## 1.3.3 — Wrong Conditionals
- What is wrong (if anything) with the provided conditional statements

### A
- `if (a > b) then c = 0;`
- `then` is not a valid keyword in Java

### B
- `if a > b { c = 0; }`
- There is no parenthensis around the boolean statment

### C
- `if (a > b) c = 0;`
- This is a valid if statment

### D
- `if (a > b) c = 0 else b = 0;`
- There is a missing semicollon after `c = 0`

## 1.3.4 — Between 0 and 1
### Question
- Write a code fragment that prints true if the double variables x and y are
both strictly between 0 and 1, and false otherwise.
### Answer
```java
if (((0 < x) && (x > 1)) && ((0 < y) && (y > 1))) 
    System.out.println(true);
else
    System.out.println(false);
```

## 1.3.5 — Method `rollLoadedDie`
- Method name: `rollLoadedDie`
- Inputs: `None`
- Returns: `None`
- Description: Prints the result of rolling a loaded die such that the probability of getting a 1, 2, 3, 4, or 5 is 1/8 and the probability of getting a 6 is 3/8.

## 1.3.7 — Loop Logic
### Question
- Suppose that i and j are both of type int. What is the value of j after each
of the following statements is executed?
### Result
```
for (i = 0, j = 0; i < 10; i++) j += i;
45

for (i = 0, j = 1; i < 10; i++) j += j;
1024

for (j = 0; j < 10; j++) j += j;
14 

for (i = 0, j = 0; i < 10; i++) j += j++;
0
```

## 1.3.8 — Method `hellos`
- Method name: `hellos`
- Inputs: `int x`
- Returns: `None`
- Description: Prints `1st Hello!` until `x-inth Hello!`

## 1.3.9 — Method `oneTwoByFive`
- Method name: `oneTwoByFive`
- Inputs: `None`
- Returns: `None`
- Description: Prints integers from 1,000 to 2,000 with 5 numbers per line

## 1.3.10 — Method `averageRandom`
- Method name: `averageRandom`
- Inputs: `int n`
- Returns: `None`
- Description: Prints the average of n random doubles between 0 and 1.

<!-- ## 1.3.12 — Method `functionGrowth`
- Method name: `functionGrowth`
- Inputs: `None`
- Returns: `None`
- Description:  -->

## 1.3.13 — While Loop Logic
### Question
- What would this code fragment return?
```java
int n = 123456789;
int m = 0;
while (n != 0) {
    m = (10 * m) + (n % 10);
    n = n / 10;
}
```
### Result
- `m = 987654321`
- `n = 0`

## 1.3.14 — Fibonacci Sequence
### Question
- What would this code fragment return?
```java
int f = 0, g = 1;
for (int i = 0; i <= 15; i++) {
    System.out.println(f);
    f = f + g;
    g = f - g;
}
```
### Result
- These numbers are the first sixteen of the famous Fibonacci sequence, which are defined by the following formulas: F0 = 0, F1 = 1, and Fn = Fn-1 + Fn-2 for n > 1.
```
0
1
1
2
3
5
8
13
21
34
55
89
144
233
377
610
987
610
```

## 1.3.15 — No For Loop?
### Question
- How many lines of output does the following code fragment produce?
```java
for (int i = 0; i < 999; i++);
{ System.out.println("Hello"); }
```
### Result
- This code will print one line because the semicollon will terminate the for loop without there being a body for it to loop through.

## 1.3.18 — Estimating PI
### Question
- Unlike the harmonic numbers, the sum 1/1^2 + 1/2^2 + ... + 1/n^2 does converge to a constant as n grows to infinity. (Indeed, the constant is pi^2/6, so this formula can be used to estimate the value of .) Which of the following for loops computes this sum? Assume that n is an int variable initialized to 1000000 and sum is a double variable initialized to 0.0.

- a. for (int i = 1; i <= n; i++) sum += 1 / (i*i);
- b. for (int i = 1; i <= n; i++) sum += 1.0 / i*i;
- c. for (int i = 1; i <= n; i++) sum += 1.0 / (i*i);
- d. for (int i = 1; i <= n; i++) sum += 1 / (1.0*i*i);

### Correct Answer
- The correct answer is `c` because it does double divsion and order of operations correctly

## 1.3.21 — Method `baseToBase`
- Method name: `baseToBase`
- Inputs: `long i, int k`
- Returns: `None`
- Description: Converts from i (base 10) to base k

<!-- ## 1.3.27 — -->

## 1.3.30 — Method `greatestCommonDivisor`
- Method name: `greatestCommonDivisor`
- Inputs: `int x, int y`
- Returns: `None`
- Description: Prints the greatest common divisor of `x` and `y`

## 1.3.31 — Method `relativelyPrime`
- Method name: `relativelyPrime`
- Inputs: `int n`
- Returns: `None`
- Description: Prints an n-by-n table such that there is an * in row i and column j if the gcd of i and j is 1 (i and j are relatively prime) and a space in that position otherwise.

## 1.3.34 — Method `sumOfCubes`
- Method name: `sumOfCubes`
- Inputs: `int n`
- Returns: `None`
- Description: prints all integers less than or equal to n that can be expressed as the sum of two cubes in two different ways. In other words, find distinct positive integers a, b, c, and d such that a^3 + b^3 = c^3 + d^3.

<!-- ## 1.3.35 — Method `checksumISBM`
- Method name: `checksumISBM`
- Inputs: `int number`
- Returns: `None`
- Description: Computes the checksum, and prints the ISBN number. -->

## 1.3.41 — Method `pepysSimulation`
- Method name: `pepysSimulation`
- Inputs: `int n`
- Returns: `None`
- Description: Simulates how many times (out of `n`) you could roll a dice 6 times and get 1 at least once, and roll a dice 12 times and get 1 at least twice.

## 1.3.42 — Method `letsMakeADeal`
- Method name: `letsMakeADeal`
- Inputs: `int n`
- Returns: `None`
- Description: Simulates which stratagy would be better in the game "Let's Make a Deal", changing doors, or staying with your original choice.

## S1 — Incorrect While Loop
### Question
- What's wrong with the loop below?
```java
boolean done = false;
while (done = false) {
    ...
}
```
### Answer
- This loop is incorrect because whithin the `while` prenhensis, it has a single `=`, which is the assignment operator, not `==` which is the comparison operator.

## S2 — Incorrect For Loop
### Question
- What's wrong with the loop below? It's intended to compute the sum of the integers 1 through 100.
```java
for (int i = 1; i <= N; i++) {
   int sum = 0;
   sum = sum + i;
}
System.out.println(sum);
```
### Answer
- The assignment of `sum` happens within the loop, which means it gets reset to zero every iteration

## S3 — Is Possitive
### Question
- What does the code fragment below do?
```java
if (x > 0);
    System.out.println("positive");
```
### Answer
- This code prints "positive" every time because the semicolon after the if statment end the statement there

## S4 — Method `childSimulation`
- Method name: `childSimulation`
- Inputs: `int n`
- Returns: `None`
- Description: Prints out the average amount of kids you need to have to have both a boy and girl

## S5 — Method `threeDice`
- Method name: `threeDice`
- Inputs: `int n`
- Returns: `None`
- Description: Prints out the average of the 3 pre-difined dice sets

## S6 — Method `estimateRoot`
- Method name: `estimateRoot`
- Inputs: `int base`
- Returns: `None`
- Description: Prints out the priciple square root of `base`using Newtens algorythem

## S7 — Method `negEstimateRoot`
- Method name: `negEstimateRoot`
- Inputs: `int base`
- Returns: `None`
- Description: Prints out the negitive square root of `base` using Newtens algorythem

## S8 — Getting Negitive Root from Root Function
### Question
- Try to use the program you wrote for S6 to find the square root of a negative number. What does it do? Can you explain why?
### Answer
#### What does it do?
- The program either oscillates, diverges, or crashes when trying to approximate the square root of a negative number.
#### Why?
- Because there is no real square root of a negative number

## S9 — Method `estimateCubeRoot`
- Method name: `estimateCubeRoot`
- Inputs: `int base`
- Returns: `None`
- Description: Prints out the cube root of `base` using Newtens algorythem

## S10 — Method `estimateNthRoot`
- Method name: `estimateNthRoot`
- Inputs: `int base, int root`
- Returns: `None`
- Description: Prints out the nth root of `base` using Newtens algorythem

## S11 — Method `sumRandomOne`
- Method name: `sumRandomOne`
- Inputs: `int n`
- Returns: `None`
- Description: Prints out the average amount of random numbers (`[0)`) that it takes to sum up to at least 1