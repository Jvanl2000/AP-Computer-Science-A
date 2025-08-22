public class section {
    public static void main(String[] args) {
        // HelloWorld();
        // UseArgument(args);
        // UseThree(args);
        // Permutations(args);
        // AddArgs(args);
        // PrintInitials();
        // PrintInitials();
        Print();
    }

    static void Print() {
        System.out.print("Hello ");
        System.out.print("World");
        System.out.print("!");
    }

    static void PrintInitials() {
        System.out.println("""
         *******    *      *     *
            *      * *     *     *
            *     *   *    *     *
            *     *   *    *     *
            *    *******    *   * 
            *     *   *     *   * 
        *   *     *   *      * *  
        *   *     *   *      * *  
        *****     *   *       *   
        """);
    }

                                      

    static void AddArgs(String[] args) {
        System.out.println(args[0] + args[1]);
    }

    static void Permutations(String[] args) {
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
