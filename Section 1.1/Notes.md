# 1.1 — You First Program!

## 1.1.2 — What happens when you omit modifiers/keywords from the `main` method or class

### `public`
- Omitting `public` from the **class** definition has no effect on the code execution.
- Omitting `public` from the **`main` method** will result in a runtime exception such as:
```
Error: Main method not found in class main, please define the main method as:
    public static void main(String[] args)
or a JavaFX application class must extend javafx.application.Application
```

### `static`
- If the `main` method is not declared `static` you will recieve a runtime error such as: 
```
Error: Main method is not static in class <classname>, please define the main method as:
    public static void main(String\[] args)
```

### `void`
- If `main` does not have a `void` return type, the compiler will throw and exception such as:
```
Error: Main method not found in class <classname>, please define the main method as:
    public static void main(String\[] args)
or a JavaFX application class must extend javafx.application.Application
````
