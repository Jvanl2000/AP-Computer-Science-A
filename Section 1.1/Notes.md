# 1.1 — Your First Program!

## 1.1.1 — Method `HelloWorld`
- Method name: `HelloWorld`
- Inputs: `None`
- Returns: `None`
- Description: Print the string `"Hello, World!"` to the console 10 times.

## 1.1.2 — What happens when you omit modifiers/keywords from the **`main` method** or class

### `public`
- Omitting `public` from the **class** definition does not affect the code execution.
- Omitting `public` from the **`main` method** will result in a runtime exception such as:
```
Error: Main method not found in class main, please define the main method as:
    public static void main(String[] args)
or a JavaFX application class must extend javafx.application.Application
```

### `static`
- If the **`main` method** is not declared `static`, you will receive a runtime error such as: 
```
Error: Main method is not static in class <classname>, please define the main method as:
    public static void main(String\[] args)
```

### `void`
- If `main` does not have a `void` return type, the compiler will throw an exception such as:
```
Error: Main method not found in class <classname>, please define the main method as:
    public static void main(String\[] args)
or a JavaFX application class must extend javafx.application.Application
````

### `args`
- If the variable name `args` is omitted from the `main` function header, you will receive a compiler exception such as:
```
Error: Main method not found in class section, please define the main method as:
    public static void main(String[] args)
or a JavaFX application class must extend javafx.application.Application
```

## 1.1.3 — What happens when you omit the 2nd letter of modifiers/keywords from the **`main` method** or **class**

### `public`
- Omitting the 2nd letter from the keyword `public` in the **class** definition will result in a compiler error such as:
```
section.java:1: error: class, interface, enum, or record expected
pblic class section {
^
1 error
```
- Omitting the 2nd letter from the keyword `public` in the **`main` method** will result in a compiler error such as:
```
section.java:2: error: <identifier> expected
    pblic static void main(String[] args) {
         ^
1 error
```

### `static`
- Omitting the 2nd letter from the keyword `static` in the **`main` method** will result in a compiler error such as:
```
section.java:2: error: <identifier> expected
    public satic void main(String[] args) {
                ^
1 error
```

### `void`
- Omitting the 2nd letter from the keyword `static` in the **`main` method** will result in a compiler error such as:
```
section.java:2: error: cannot find symbol
    public static vid main(String[] args) {
                  ^
  symbol:   class vid
  location: class section
1 error
```

### `args`
- Omitting the 2nd letter from the argument `args` in the **`main` method** does not affect this code because this code does not reference that variable. If this code were to reference that variable, all other copies of the variable name would have to be refactored.

## 1.1.4 — What happens if you put double quotes on separate lines
- When running this example code, you will receive the following exception
- Code
```java
System.out.println("Hello,
                        World");
```
- Exception
```
section.java:3: error: unclosed string literal
        System.out.println("Hello,
                           ^
section.java:4: error: unclosed string literal
                                World");
                                     ^
section.java:4: error: not a statement
                                World");
                                ^
3 errors
```
