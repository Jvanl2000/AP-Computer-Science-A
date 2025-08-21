# 1.1 — Your First Program!

## 1.1.1 — Method `HelloWorld`
- Method name: `HelloWorld`
- Inputs: `None`
- Returns: `None`
- Description: This method prints the string `"Hello, World!"` to the console 10 times.

## 1.1.2 — What happens when you omit modifiers/keywords from the **`main` method** or class

### Example Code
```java
public class MyProgram {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

### `public`
- Omitting `public` from the **class** definition does not affect the code execution.
- Omitting `public` from the **`main` method** will result in a runtime exception such as:
```
Error: Main method not found in class MyProgram, please define the main method as:
    public static void main(String[] args)
or a JavaFX application class must extend javafx.application.Application
```

### `MyProgram`
- Omitting `MyProgram` from the **class** definition will result in a compiler exception such as:
```
MyProgram.java:1: error: <identifier> expected
public class {
            ^
1 error  
```

### `static`
- If the **`main` method** is not declared `static`, you will receive a runtime error such as: 
```
Error: Main method is not static in class MyProgram, please define the main method as:
    public static void main(String[] args)
```

### `void`
- If `main` does not have a `void` return type, the compiler will throw an exception such as:
```
MyProgram.java:2: error: invalid method declaration; return type required
    public static main(String[] args) {
                  ^
1 error
```

### `main`
- Omitting the name of the `main` method will cause a compiler error such as:
```
MyProgram.java:2: error: <identifier> expected
    public static void (String[] args) {
                      ^
1 error
```

### `String`
- Omitting the varable input type will cause an compiler exception such as:
```
MyProgram.java:2: error: illegal start of type
    public static void main([] args) {
                            ^
MyProgram.java:2: error: ',', ')', or '[' expected
    public static void main([] args) {
                              ^
2 errors
```

### `args`
- If the variable name `args` is omitted from the `main` function header, you will receive a compiler exception such as:
```
MyProgram.java:2: error: <identifier> expected
    public static void main(String[]) {
                                    ^
1 error
```

### `System.out`
- Omitting the `System.out` will result in a compiler exception such as:
```
MyProgram.java:3: error: cannot find symbol
        println("Hello, World!");
        ^
  symbol:   method println(String)
  location: class MyProgram
1 error
```

### `println`
- Omitting the `println` from the method will result in a compiler error such as:
```
MyProgram.java:3: error: cannot find symbol
        System.out("Hello, World!");
              ^
  symbol:   method out(String)
  location: class System
1 error
```

### The `;`
- Omitting the `;` from the end of ANY line will result in a compiler error such as:
```
MyProgram.java:3: error: ';' expected
        System.out.println("Hello, World!")
                                           ^
1 error
```

### The First or Second `"`
- Omitting either double quote will result in a compiler error

#### First `"`
```
MyProgram.java:3: error: ')' or ',' expected
        System.out.println(Hello, World!");
                                       ^
MyProgram.java:3: error: unclosed string literal
        System.out.println(Hello, World!");
                                        ^
2 errors
```

#### Second `"`
```
MyProgram.java:3: error: unclosed string literal
        System.out.println("Hello, World!);
                           ^
1 error
```

### The First or Second `{`
- Omitting either forward curly bracket will result in a compiler error

#### First `{` (**Class**)
```
MyProgram.java:1: error: '{' expected
public class MyProgram 
                      ^
MyProgram.java:2: error: unnamed classes are a preview feature and are disabled by default.
    public static void main(String[] args) {
                  ^
  (use --enable-preview to enable unnamed classes)
MyProgram.java:5: error: class, interface, enum, or record expected
}
^
3 errors
```

#### Second `{` (**`main` method**)
```
MyProgram.java:2: error: ';' expected
    public static void main(String[] args) 
                                          ^
MyProgram.java:5: error: class, interface, enum, or record expected
}
^
2 errors
```

### The First or Second `}`
- Omitting either backward curly bracket will result in a compiler error

#### First `}` (**Class**)
```
MyProgram.java:4: error: reached end of file while parsing
    }
     ^
1 error
```

#### Second `]` (**`main` method**)
```
MyProgram.java:5: error: reached end of file while parsing
}
 ^
1 error
```

## 1.1.3 — What happens when you omit the 2nd letter of modifiers/keywords from the **`main` method** or **class**

### Example Code
```java
public class MyProgram {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

### `public`
- Omitting the 2nd letter from the keyword `public` in the **class** definition will result in a compiler error such as:
```
MyProgram.java:1: error: class, interface, enum, or record expected
pblic class MyProgram {
^
1 error
```

- Omitting the 2nd letter from the keyword `public` in the **`main` method** will result in a compiler error such as:
```
MyProgram.java:2: error: <identifier> expected
    pblic static void main(String[] args) {
         ^
1 error
```

### `static`
- Omitting the 2nd letter from the keyword `static` in the **`main` method** will result in a compiler error such as:
```
MyProgram.java:2: error: <identifier> expected
    public satic void main(String[] args) {
                ^
1 error
```

### `void`
- Omitting the 2nd letter from the keyword `static` in the **`main` method** will result in a compiler error such as:
```
MyProgram.java:2: error: cannot find symbol
    public static vid main(String[] args) {
                  ^
  symbol:   class vid
  location: class MyProgram
1 error
```

### `args`
- Omitting the 2nd letter from the argument `args` in the **`main` method** does not affect this code because this code does not reference that variable. If this code were to reference that variable, all other copies of the variable name would have to be refactored.

## 1.1.4 — What happens if you put double quotes on separate lines

### Example Code

```java
public class MyProgram {
    public static void main(String[] args) {
        System.out.println("Hello,
                                World");
    }
}
```
### Compiler Exception
```
MyProgram.java:3: error: unclosed string literal
        System.out.println("Hello,
                           ^
MyProgram.java:4: error: unclosed string literal
                                World");
                                     ^
MyProgram.java:4: error: not a statement
                                World");
                                ^
3 errors
```

## 1.1.5 — Method `UseArgument`
- Method name: `UseArgument`
- Inputs: `String[] args`
- Returns: `None`
- Description: This method prints the string `"Hi, {args[0]}, how are you?"` to the console.
### Test Cases
```
java UseArgument java
Hi, java, how are you?
```
```
java UseArgument @!&^%
bash: !: event not found
```
- This exception still presists even if the command line argument is given within double quotation marks.
```
java UseArgument 1234
Hi, 1234, how are you?
```
```
java UseArgument.java Bob
Hi, Bob, how are you?
```
- Even if the java file is not compiled it still runs, I suspect that it is compiled into memory and never saved.
```
java UseArgument Alice Bob
Hi, Alice, how are you?
```
- When this method is provided two command line arguments it ignores the second one because the only argument it uses is `args[0]`.
```
java UseArgument
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        at UseArgument.main(UseArgument.java:3)
```
- This exception is thrown because if `args` is empty (no command line arguments are used), Java is unable to print a `null` value.

## 1.1.6 — Method `UseThree`
- Method name: `UseThree`
- Inputs: `String[] args`
- Returns: `None`
- Description: This method prints the string `"{args[2]}, {args[1]}, and {args[0]} are learning Java!"` to the console. This method prints the names in reverse order.

## 1.1.7 — Method `Permutations`
- Method name: `Permutations`
- Inputs: `String[] args`
- Returns: `None`
- Description: This method will print the first 3 value of `args` in all possible permutations.

### Example
```
java Permutations Alice Bob Carol
Alice, Bob, Carol
Alice, Carol, Bob
Bob, Alice, Carol
Bob, Carol, Alice
Carol, Alice, Bob
Carol, Bob, Alice
```

## 1.1.8 — Method `AddArgs`
- Method name: `AddArgs`
- Inputs: `String[] args`
- Returns: `None`
- Description: This method will concatinate the first two strings within `args`

### Example
```
java AddArgs Alice Bob
AliceBob
java AddArgs 123 456
123456
```
- This method takes in an array of strings, it does not care if they are numbers.

## 1.1.9 — What happens when you name the **`main` class** something different than the file name
- If you name the file something that is not the **class** name then you will recieve a compiler error such as:
```
MyProgram.java:1: error: class NotMyProgram is public, should be declared in a file named NotMyProgram.java
public class NotMyProgram {
       ^
1 error
```
