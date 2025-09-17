# 1.2 — name

## 1.2.1 — Variable Logic

### Question
- Suppose that a and b are int variables. What does the following sequence of statements do?
java
- ```int t = a; b = t; a = b;```

### Answer
- This script would set all of the variables (```a,b,t```) to the value of the variable ```a```.

## 1.2.2 — Method `cosAndSin`
- Method name: `cosAndSin`
- Inputs: `double x`
- Returns: `double`
- Description: This method returns the value of cos(x)^2 + sin(x)^2. This value should always be equivalent to `1`, but due to inacuracys in floating-point numbers it will be slightly off.

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
- If a value isn't greater or less than another than they have to be the same
- `a = b`

## 1.2.5 — Provide the truth table for the exclusive or operator
### Exclusive or operator definition
- For boolean operands is defined to be `true` if they are different, `false` if they are the same.
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
- Since both 10 and 3 are integer literals, Java sees no need for type conversion and uses integer division. You should write `10.0/3.0` if you mean the numbers

- To be double literals. If you write `10/3.0` or `10.0/3`, Java does implicit conversion
to get the same result.

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
- Java sees the two integers before the string so it simplifys the mathmatical expression before converting it to a string
### C
```
System.out.println((2+3) + "bc");
5bc
```
- Same reason as previous
### D
```
System.out.println("bc" + (2+3));
bc5
```
- Java sees the parenthesis before the string so it compleats the math before converting to a string
### E
```
System.out.println("bc" + 2 + 3);
bc23
```
- Java sees the string first so it converts the rest into strings

## 1.2.8 — Square Root of a Number
### Program 1.2.3
java
```
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
- In Java char is a 16 bit unsigned integer type (it stores Unicode)
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
- After the mathmatical operations are compleated it converts its integer back into its unicode form (`e`)

## 1.2.11 — Mathmatical operations on a `double`
### Question
- Suppose that a variable a is declared as double `a = 3.14159`. What does
each of the following print?
### A 
```
System.out.println(a);
3.14159
```
- Simply prints the variable `a` to the console
### B
```
System.out.println(a+1);
4.14159
```
- Simply prints the value of `a + 1` to the console
### C
```
System.out.println(8/(int) a);
2
```
- Since both numbers are integers java does integer division
### D
```
System.out.println(8/a);
2.5464812403910124
```
- Java does regualar double division
### E
```
System.out.println((int) (8/a));
2
```
- Does regular double division then converts to an integer removoing all decimals without rounding

## 1.2.12 — Omiting `Math.`
### Program
java
```
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
- What happens if you omit `Math.` from the beggening of `Math.sqrt` in Program 1.2.3?
### Result
- You will recieve a compilation such as
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
- The answer is false because when calculating square roots in java it is only a double aproxomation not an exact value
- When it does the math the answer is `2.0000000000000004` which is NOT equal to 2

## 1.2.14 — Method `isDiv`
- Method name: `isDiv`
- Inputs: `String[] args`
- Returns: `None`
- Description: This method prints true or false if either of the first two integer values provided in `args` are divisible evenly by eachother

## 1.2.15 — Method `isPossibleTriangle`
- Method name: `isPossibleTriangle`
- Inputs: `String[] args`
- Returns: `None`
- Description: Prints `false` if any one of the other two variables are greater than or equal to the sum of the other two and true otherwise

## 1.2.16 — Order of operations
### Question
- To compute values according to the formula F = Gm1m2 / r^2. Explain the problem
and correct the code.
- `double force = G * mass1 * mass2 / r * r;`
### Answer
- `double force = G * mass1 * mass2 / (r * r);`
- The problem was order of operations
- With the original setup it did `mass2 / r` then that value `/ r`

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

## 1.2.28 — Method `inOrder`
- Method name: `inOrder`
- Inputs: `String[] args`
- Returns: `None`
- Description: Prints if the given points (`x,y,z`) are in acending or decending order

## 1.2.29 — Method `dayOfTheWeek`
- Method name: `dayOfTheWeek`
- Inputs: `String[] args`
- Returns: `None`
- Description: Prints the day of the week (in int form) given a month, day, and year

