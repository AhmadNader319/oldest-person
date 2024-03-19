import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main <filename>");
            return;
        }

        String fileName = args[0]; // Get the file name from the command-line argument

        try {
            ArrayList<String> oldestPeople = personFileProcessor.processFile(fileName);

            if (oldestPeople.isEmpty()) {
                System.out.println("No oldest person found.");
            } else {
                System.out.println("Oldest person(s):");
                for (String person : oldestPeople) {
                    System.out.println(person);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
