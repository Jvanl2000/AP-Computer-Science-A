import java.awt.Color;

public class section {
    public static void main(String[] args) {
        // System.out.println(reverse("Test String!"));
        // colorSquare(255, 128, 255);
        // horizontal("image.jpg");
        // System.out.println(isValidDNA("ACTGGTCACT"));
        // System.out.println(complementWatsonCrick("ACTGGTCACT"));
        // System.out.println(isWatsonCrickPalindrome("ATCGAT"));
        // System.out.println(ISBN("020-131-452"));
        // System.out.println(isCircularShift("ACTGACG", "TGACGAC"));
        // System.out.println(isSafePassword("P@ssw0rd"));
        // albersSquares();
        // glassFilter("image.jpg");
        // boundingBox("image.jpg");
        // digitalZoom("image.jpg", 0.5, 0.5, 0.5);
        // diagonalFlip("image.jpg");
        // System.out.println(firstUniqueCharacter("ABCDBADDAB"));
        millionDigits();
    }

    public static void millionDigits() {
        In page = new In("https://oeis.org/A002205/b002205.txt");
        String digitsPI = "314159265358";
        int i = 0;
        int longestMatch = 0;
        int positionLongestMatch = 0;

        while (!page.isEmpty()) {
            String line = page.readLine();
            String[] numsOnLine = line.split("\\s+");
            int digitNumber = Integer.parseInt(numsOnLine[0]);
            String randomDigit = numsOnLine[1];

            if (randomDigit.equals(String.valueOf(digitsPI.charAt(i)))) {
                i++;
                if (i > longestMatch) {
                    longestMatch = i;
                    positionLongestMatch = digitNumber - longestMatch + 1;
                }
            } else {
                i = 0;
            }
        }

        System.out.println("Longest match is " + longestMatch + " digits at position " + positionLongestMatch);
    }

    public static char firstUniqueCharacter(String string) {
        for (int i = 0; i < string.length(); i++) {
            char cha = string.charAt(i);
            if (string.indexOf(cha) == string.lastIndexOf(cha)) {
                return cha;
            }
        }

        return '\0';
    }

    public static void diagonalFlip(String imgPath) {
        Picture pic = new Picture(imgPath);
        Picture newPic = new Picture(pic.height(), pic.width());

        for (int x = 0; x < pic.width(); x++) {
            for (int y = 0; y < pic.height(); y++) {
                newPic.set(y, x, pic.get(x, y));
            }
        }

        newPic.save("diagonalFlip.png");
    }

   public static void digitalZoom(String imgPath, double s, double x, double y) {
        Picture pic = new Picture(imgPath);
        int newWidth = (int) (pic.width() * s);
        int newHeight = (int) (pic.height() * s);
        Picture newPic = new Picture(newWidth, newHeight);

        int centerX = (int) (x * pic.width());
        int centerY = (int) (y * pic.height());

        for (int i = 0; i < newWidth; i++) {
            for (int j = 0; j < newHeight; j++) {
                int oldX = centerX - newWidth / 2 + i;
                int oldY = centerY - newHeight / 2 + j;

                if (oldX < 0) oldX = 0;
                if (oldX >= pic.width()) oldX = pic.width() - 1;
                if (oldY < 0) oldY = 0;
                if (oldY >= pic.height()) oldY = pic.height() - 1;

                newPic.set(i, j, pic.get(oldX, oldY));
            }
        }

        newPic.save("digitalZoom.png");
    }

    public static void glassFilter(String imgPath) {
        Picture pic = new Picture(imgPath);
        Picture newPic = new Picture(pic.width(), pic.height());

        for (int x = 0; x < pic.width(); x++) {
            for (int y = 0; y < pic.height(); y++) {
                int xOffset = (int) (Math.random() * 5);
                int yOffset = (int) (Math.random() * 5);

                int oldX = x + xOffset;
                int oldY = y + yOffset;

                if (oldX < 0) oldX = 0;
                if (oldX >= pic.width()) oldX = pic.width() - 1;
                if (oldY < 0) oldY = 0;
                if (oldY >= pic.height()) oldY = pic.height() - 1;

                newPic.set(x, y, pic.get(oldX, oldY));
            }
        }

        newPic.save("glassFilter.png");
    }

    public static void albersSquares() {
        int n = 16;           
        int cellSize = 16;
        int width = 256;
        int height = 256;

        Picture pic = new Picture(width, height);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int col = x / cellSize;
                int row = y / cellSize;

                int blue = row * n + col; 
                int gray = col * n + row;

                Color blueBG = new Color(blue, blue, 255);
                Color grayFG = new Color(gray, gray, gray);

                int cellX = x % cellSize;
                int cellY = y % cellSize;

                if (cellX >= 5 && cellX < 11 && cellY >= 5 && cellY < 11) {
                    pic.set(x, y, grayFG);
                } else {
                    pic.set(x, y, blueBG);
                }
            }
        }

        pic.save("albersSquares.png");
    }
    
    public static boolean isSafePassword(String password) {
        boolean hasDigit = false;
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasSpecialChar = false;

        if (password.length() < 8) return false;

        for (int i = 0; i < password.length(); i++) {
            char cha = password.charAt(i);
            if (Character.isDigit(cha)) hasDigit = true;
            else if (Character.isUpperCase(cha)) hasUppercase = true;
            else if (Character.isLowerCase(cha)) hasLowercase = true;
            else hasSpecialChar = true;
        }

        return hasDigit && hasUppercase && hasLowercase && hasSpecialChar;
    }


    public static boolean isCircularShift(String s, String t) {
        return s.length() == t.length() && (s + s).contains(t);
    }

    public static String ISBN(String string) {
        int[] digits = new int[9];
        int currentDigit = 0;
        
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != '-') {
                digits[currentDigit] = Integer.parseInt(String.valueOf(string.charAt(i)));
                currentDigit++;
            }
        }

        for (int i = 0; i <= 10; i++) {
            if ((i + 2 * digits[8] + 3 * digits[7] + 4 * digits[6] + 5 * digits[5] + 6 * digits[4] + 7 * digits[3] + 8 * digits[2] + 9 * digits[1] + 10 * digits[0]) % 11 == 0) {
                return string + "-" + (i == 10 ? "X" : i);
            }
        }

        return "There is no valid ISBN for this number.";
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

    public static void boundingBox(String imgPath) {
        Picture pic = new Picture(imgPath);
        int[] pos1 = new int[2];
        int[] pos2 = new int[2];
        
        boolean running = true;
        for (int y = 0; y < pic.height(); y++) {
            for (int x = pic.width() - 1; x >= 0; x--) {
                if (pic.get(x, y).getRed() != 255 || pic.get(x, y).getGreen() != 255 || pic.get(x, y).getBlue() != 255) {
                    pos1[0] = y;
                    pos1[1] = x;
                    running = false;
                    break;
                }
            }
            if (!running) break;
        }

        running = true;
        for (int y = pic.height() - 1; y >= 0; y--) {
            for (int x = 0; x < pic.width() - 1; x++) {
                if (pic.get(x, y).getRed() != 255 || pic.get(x, y).getGreen() != 255 || pic.get(x, y).getBlue() != 255) {
                    pos2[0] = y;
                    pos2[1] = x;
                    running = false;
                    break;
                }
            }
            if (!running) break;
        }

        System.out.println("Bottom-Left corner: (" + pos1[0] + ", " + pos1[1] + ")");
        System.out.println("Top-Right corner: (" + pos2[0] + ", " + pos2[1] + ")");
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