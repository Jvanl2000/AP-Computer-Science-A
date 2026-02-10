import java.awt.Color;

public class section {
    public static void main(String[] args) {
        // System.out.println(reverse("Test String!"));
        // colorSquare(255, 128, 255);
        // horizontal("image.jpg");
        // System.out.println(isValidDNA("ACTGGTCACT"));
        // System.out.println(complementWatsonCrick("ACTGGTCACT"));
        // System.out.println(isWatsonCrickPalindrome("ATCGAT"));
    }

    public static boolean isWatsonCrickPalindrome(String string) {
        return reverse(string).equals(complementWatsonCrick(string));
    }

    public static String complementWatsonCrick(String string) {
        String newString = "";

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'A') newString += "T";
            if (string.charAt(i) == 'T') newString += "A";
            if (string.charAt(i) == 'C') newString += "G";
            if (string.charAt(i) == 'G') newString += "C";                            
        }

        return newString;
    }

    public static boolean isValidDNA(String string) {
        for (int i = 0; i < string.length(); i++) {
            char cha = string.charAt(i);
            if (cha != 'A' && cha != 'T' && cha != 'C' && cha != 'G') return false;
        }

        return true;
    }

    public static void horizontal(String imgPath) {
        Picture pic = new Picture(imgPath);

        for (int x = 0; x < pic.width() / 2; x++) {
            for (int y = 0; y < pic.height(); y++) {
                Color temp = pic.get(x, y);
                pic.set(x, y, pic.get(pic.width() - x - 1, y));
                pic.set(pic.width() - x - 1, y, temp);
            }
        }

        pic.save("horizontal.png");
    }

    public static void colorSquare(int r, int g, int b) {
        Picture pic = new Picture(256, 256);
        Color color = new Color(r, g, b);

        for (int x = 0; x < 256; x++) {
            for (int y = 0; y < 256; y++) {
                pic.set(x, y, color);
            }
        }

        pic.save("colorSquare.png");
    }

    public static String reverse(String string) {
        String newString = "";

        for (int i = 0; i < string.length(); i++) {
            newString += string.charAt(string.length() - i - 1);
        }

        return newString;
    }
}