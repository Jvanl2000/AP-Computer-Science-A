1.1.1 - Method named 'HelloWorld' prints "Hello, World!" 10 times to the console

1.1.2 - What happens if you omit
public
When you omit 'public' from the class definition nothing happens.
When you omit 'public' from the 'main' function definition you get a runtime error.
```
Error: Main method not found in class main, please define the main method as:
  public static void main(String[] args)
or a JavaFX application class must extend javafx.application.Application
```

static
When I omit 'static' from the 'main' method header I get a runtime exception.
```
Error: Main method is not static in class section, please define the main method as:
  public static void main(String[] args)
```

void
When I omit ```void``` from the 'main' method header I get a compiler error.
```
Error: Main method not found in class section, please define the main method as:
  public static void main(String[] args)
or a JavaFX application class must extend javafx.application.Application
```
