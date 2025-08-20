public class section {
    public static void main(String[] args) {
        // HelloWorld();
        // UseArgument(args);
        // UseThree(args);
        permutations(args);
    }

    static void permutations(String[] args) {
        System.out.println(args[0] + ", " + args[1] + ", " + args[2]);
        System.out.println(args[0] + ", " + args[2] + ", " + args[1]);
        System.out.println(args[1] + ", " + args[0] + ", " + args[2]);
        System.out.println(args[1] + ", " + args[2] + ", " + args[0]);
        System.out.println(args[2] + ", " + args[0] + ", " + args[1]);
        System.out.println(args[2] + ", " + args[1] + ", " + args[0]);
    }

    static void UseThree(String[] args) {
        System.out.print(args[2] + ", ");
        System.out.print(args[1] + ", and ");
        System.out.println(args[0] + " are learning Java!");
    }

    static void UseArgument(String[] args) {
        System.out.println("HI, " + args[0] + ", how are you?");
    }

    static void HelloWorld() { 
        System.out.println("""
                           Hello, World!
                           Hello, World!
                           Hello, World!
                           Hello, World!
                           Hello, World!
                           Hello, World!
                           Hello, World!
                           Hello, World!
                           Hello, World!
                           Hello, World!
                           """);
    }
}
