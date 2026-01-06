public class section {
    public static void main(String[] args) {
        intToBinary(11);
    }

    public static void intToBinary(int n) {
        String temp = "";

        while (n > 0) {
            temp += String.valueOf(n%2);
            n = n/2;
        }

        System.out.println(reverse(temp));
    }

    public static String reverse(String string) {
        if (string.length() <= 1) return string;
         else return string.charAt(string.length() - 1) + reverse(string.substring(0, string.length() - 1));
    }
}