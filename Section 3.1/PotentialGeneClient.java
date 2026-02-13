public class PotentialGeneClient {
    public static void main(String[] args) {
        System.out.print("Enter a DNA string: ");
        String input = StdIn.readLine();
        String output = PotentialGene.isPotentialGene(input) ? input : "";
        if (output.equals("")) {
            System.out.println("There is no potential gene in the string.");
        } else {
            System.out.println("The potential gene is: " + output);
        }
    }
}