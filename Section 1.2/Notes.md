# 1.2 — Data Types

## 1.2.1 — Variable Logic

### Question
- Suppose that a and b are int variables. What does the following sequence of statements do?
- `int t = a; b = t; a = b;`

### Answer
- This script would set all of the variables (```a,b,t```) to the value of the variable ```a```.

## 1.2.2 — Method `cosAndSin`
- Method name: `cosAndSin`
- Inputs: `double x`
- Returns: `double`
- Description: This method returns the value of cos(x)^2 + sin(x)^2. This value should always be equivalent to `1`, but due to inaccuracies in floating-point numbers, it will be slightly off.

## 1.2.3 — Evaluate this logical expression
### Question
- Evaluate if this function will return `true` in all cases.
- `(!(a && b) && (a || b)) || ((a && b) || !(a || b))`
### Truth Table
| A | B | Expression |
|---|---|----------|
| 0 | 0 |    1     |
| 0 | 1 |    1     |
| 1 | 0 |    1     |
| 1 | 1 |    1     |

## 1.2.4 — Evaluate this integer logical expression
### Question
- Suppose that a and b are int variables. Simplify the following expression
- `(!(a < b) && !(a > b))`
### Answer
- This equation would translate to
- "If `a` isn't less than `b` and `a` isn't greater than `b`"
- If a value isn't greater than nor less than another, then they have to be the same
- `a = b`

## 1.2.5 — Provide the truth table for the exclusive or operator
### Exclusive or operator definition
- Boolean operands are defined to be `true` if they are different, `false` if they are the same.
## Truth Table
| A | B | EXOR |
|---|---|----------|
| 0 | 0 |    0     |
| 0 | 1 |    1     |
| 1 | 0 |    1     |
| 1 | 1 |    0     |

## 1.2.6 — Integer Division
### Question
- Why does `10/3` give 3 and not 3.333333333?
### Answer
- Since both 10 and 3 are integer literals, Java sees no need for type conversion and uses integer division. You should write `10.0/3.0` if you want a `double` return value

- To be double literals. If you write `10/3.0` or `10.0/3`, Java does implicit conversion to get the same result.

## 1.2.7 — Addition with Strings and Numbers
### A
```
System.out.println(2 + "bc");
2bc
```
- Java sees the string and implicitly converts the integer 2 to a string
### B
```
System.out.println(2 + 3 + "bc");
5bc
```
- Java sees the two integers before the string, so it simplifies the mathematical expression before converting it to a string
### C
```
System.out.println((2+3) + "bc");
5bc
```
- Same reason as the previous
### D
```
System.out.println("bc" + (2+3));
bc5
```
- Java sees the parentheses before the string, so it completes the math before converting to a string
### E
```
System.out.println("bc" + 2 + 3);
bc23
```
- Java sees the string first, so it converts the rest into strings

## 1.2.8 — Square Root of a Number
### Program 1.2.3
```java
public class Quadratic {
    public static void main(String[] args) {
        double b = Double.parseDouble(args[0]);
        double c = Double.parseDouble(args[1]);
        double discriminant = b*b - 4.0*c;
        double d = Math.sqrt(discriminant);
        System.out.println((-b + d) / 2.0);
        System.out.println((-b - d) / 2.0);
    }
}
```
### Question
- Explain how to use Program 1.2.3 to find the square root of a number
### Answer
- To find the square root of `x` from Program 1.2.3 you need to input the values `(0, -x)` into the function and it will return `(sqrt(x), -sqrt(x))`

## 1.2.9 — Addition with characters
### A
```
System.out.println('b');
b
```
- Implicitly converts it into a string

### B
```
System.out.println('b' + 'c');
197
```
- `b` and `c` are char literals
- In Java, `char` is a 16-bit unsigned integer type (it stores Unicode)
- `b` is the integer value 98
- `c` is the integer value 99
- `b` + `c` → 98 + 99 = 197.

### C
```
System.out.println((char) ('a' + 4));
e
```
- This works the same as the last problem
- `a` is converted to an integer and added 4
- After the mathematical operations are completed, it converts its integer back into its Unicode form (`e`)

## 1.2.11 — Mathematical operations on a `double`
### Question
- Suppose that a variable a is declared as double `a = 3.14159`. What does
each of the following print?
### A 
```
System.out.println(a);
3.14159
```
- Prints the variable `a` to the console
### B
```
System.out.println(a+1);
4.14159
```
- Prints the value of `a + 1` to the console
### C
```
System.out.println(8/(int) a);
2
```
- Since both numbers are integers, Java does integer division
### D
```
System.out.println(8/a);
2.5464812403910124
```
- Java does regular double division
### E
```
System.out.println((int) (8/a));
2
```
- Does regular double division, then converts to an integer, removing all decimals without rounding

## 1.2.12 — Omitting `Math.`
### Program
```java
public class Quadratic {
    public static void main(String[] args) {
        double b = Double.parseDouble(args[0]);
        double c = Double.parseDouble(args[1]);
        double discriminant = b*b - 4.0*c;
        double d = Math.sqrt(discriminant);
        System.out.println((-b + d) / 2.0);
        System.out.println((-b - d) / 2.0);
    }
}
```
### Question
- What happens if you omit `Math.` from the beginning of `Math.sqrt` in Program 1.2.3?
### Result
- You will receive a compilation such as
```
section.java:19: error: cannot find symbol
        double d = sqrt(discriminant);
                   ^
  symbol:   method sqrt(double)
  location: class section
1 error
error: compilation failed
```

## 1.2.13 — Equality with aproxamations
### Question
- Evaluate the expression
- `(Math.sqrt(2) * Math.sqrt(2) == 2)`
### Result
- `false`
- The answer is false because when calculating square roots in Java, it is only a double approximation, not an exact value
- When it does the math, the answer is `2.0000000000000004` which is NOT equal to 2

## 1.2.14 — Method `isDiv`
- Method name: `isDiv`
- Inputs: `String[] args`
- Returns: `None`
- Description: This method prints true or false if either of the first two integer values provided in `args` is evenly divisible by the other.

## 1.2.15 — Method `isPossibleTriangle`
- Method name: `isPossibleTriangle`
- Inputs: `String[] args`
- Returns: `None`
- Description: Prints `false` if any one of the other two variables is greater than or equal to the sum of the other two, and true otherwise

## 1.2.16 — Order of operations
### Question
- To compute values according to the formula F = Gm1m2 / r^2. Explain the problem
and correct the code.
- `double force = G * mass1 * mass2 / r * r;`
### Answer
- `double force = G * mass1 * mass2 / (r * r);`
- The problem was the order of operations
- With the original setup, it did `mass2 / r` then that value `/ r`

## 1.2.17 — Changing Variables
### Integer (addition)
```
int a = 1;
1
a = a + a;
2
a = a + a;
4
a = a + a;
8
```
### Boolean
```
boolean a = true;
true
a = !a;
false
a = !a;
true
a = !a;
false
```
### Integer (multiplication)
```
int a = 2;
2
a = a * a;
4
a = a * a;
16
a = a * a;
256
```

## 1.2.18 — Method `euclideanDistance`
- Method name: `euclideanDistance`
- Inputs: `String[] args`
- Returns: `None`
- Description: Prints the Euclidean Distance between two integer points

## 1.2.19 — Method `randomBetween`
- Method name: `randomBetween`
- Inputs: `String[] args`
- Returns: `None`
- Description: Prints a random integer between `args[0]` and `args[1]`

## 1.2.20 — Method `rollDice`
- Method name: `rollDice`
- Inputs: `None`
- Returns: `None`
- Description: Prints the sum of two random numbers between 1 and 6 (rolling a set of virtual dice)

## 1.2.23 — Method `betweenDate`
- Method name: `betweenDate`
- Inputs: `String[] args`
- Returns: `None`
- Description: Prints if the given date is within the range 3/20 to 6/20

## 1.2.26 — Method `polarCoordinates`
- Method name: `polarCoordinates`
- Inputs: `String[] args`
- Returns: `None`
- Description: Prints the coverted Cartesian to polar coordinates

## 1.2.28 — Method `inOrder`
- Method name: `inOrder`
- Inputs: `String[] args`
- Returns: `None`
- Description: Prints if the given points (`x,y,z`) are in ascending or descending order

## 1.2.29 — Method `dayOfTheWeek`
- Method name: `dayOfTheWeek`
- Inputs: `String[] args`
- Returns: `None`
- Description: Prints the day of the week (in int form) given a month, day, and year

## 1.2.33 — Method `greatCircle`
- Method name: `greatCircle`
- Inputs: `String[] args`
- Returns: `None`
- Description: Prints the distance between the lat and long

## 1.2.34 — Method `threeSort`
- Method name: `threeSort`
- Inputs: `String[] args`
- Returns: `None`
- Description: Prints three integer inputed in the order from greatest to least

## S1 — Printing a `\`
### Example
```
jshell> System.out.println("Slash: \");
|  Error:
|  unclosed string literal
|  System.out.println("Slash: \");
|
```
### Reasoning
- The `\` is normaly followed by a specific character to form an escape sequence
- Since this is apart of the `String` it is confusing Java
- To do this proporly add another `\`
```
jshell> System.out.println("Slash: \\");
Slash: \
```

## S2 — Using ``` ` ``` as a `char`
### Example
- What happens if we have the line of code below in a program?
```
jshell> System.out.println("Single quote: " + ''');
|  Error:
|  empty character literal
|  System.out.println("Single quote: " + ''');
|
```
### Reasoning
- Because of the second ``` ` ``` Java thinks you have ended the `char`
- If you want to do this add a `\` in front of the ``` ` ```

## S3 — Java Math
```
jshell> 3 / 2
$1 ==> 1

jshell> 3.0 / 2.0
$2 ==> 1.5

jshell> 3.0 / 2
$3 ==> 1.5

jshell> 2 + 3 + "abc"
$4 ==> "5abc"

jshell> (2 + 3) + "abc"
$5 ==> "5abc"

jshell> 2 + "abc" + 3
$6 ==> "2abc3"

jshell> "abc" + 2 + 3
$7 ==> "abc23"

jshell> "abc" + (2 + 3)
$8 ==> "abc5"

jshell> 1 / 0
|  Exception java.lang.ArithmeticException: / by zero
|        at (#9:1)

jshell> 1.0 / 0
$10 ==> Infinity

jshell> 0 / 0
|  Exception java.lang.ArithmeticException: / by zero
|        at (#11:1)

jshell> 0.0 / 0
$12 ==> NaN
```

## S4 — What is wrong with the code fragment below?
### Fragment
```
double C = (F - 32) * (5 / 9);
```
### Answer
- This function will not work because `5 / 9` is integer division, not double division

## S5 — Mysterious Casting
### Example
```
jshell> double x = (double) (3/5);
   ...> System.out.println(x);
x ==> 0.0
0.0
```
### Reasoning
- Even though the division is being casted to a double, this is after the integer division had already accoured

## S6 — Integer Memory Sizes
- long (64 bits): −2^63 to 2^63 - 1
- int (32 bits): -2^31 to 2^31 - 1
- short (16 bits): -2^15 to 2^15 - 1
- byte (8 bits): -2^7 to 2^7 - 1

## S7 — The `final` Keyword
### Example
```
jshell> final int myFinalNumber = 10;
myFinalNumber ==> 10

jshell> myFinalNumber = 20;
|  Error:
|  cannot assign a value to final variable myFinalNumber
|  myFinalNumber = 20;
|  ^----------------^
```
### Reasoning
- A `final` variable has a final value, it can't be changed no matter what

## S8 — Compiles but doesn't run?
### Code
```java
public class Hello {
   public static void main() {
      System.out.println("Doesn't execute");   
   }
}
```
### Question
- Why does this code compile but not execute?
### Reasoning
- This code is syntaticly correct but lacks the correct `main` method declaration
- Without the right delaration the JVM doesn't know where to start execution

## S9 — Method `greaterValue`
- Method name: `greaterValue`
- Inputs: `String[] args`
- Returns: `None`
- Description: Prints the greatest integer of two given via Algebra

## S10 — Method `lesserValue`
- Method name: `lesserValue`
- Inputs: `String[] args`
- Returns: `None`
- Description: Prints the lesser integer of two given via Algebra

## S11 — Method `tripleGreaterValue`
- Method name: `tripleGreaterValue`
- Inputs: `String[] args`
- Returns: `None`
- Description: Prints the greater integer of the three given via Algebra

## S12 — Max Integer Values
### JSHELL
```
jshell> -2147483648
$1 ==> -2147483648

jshell> -(2147483648)
|  Error:
|  integer number too large
|  -(2147483648)
|
```
### Answer
- The max value for an integer is 2^31 - 1 (Its one less because of 0)
- When you try setting the number to 2^31, that is over the max allocated memory for that data type