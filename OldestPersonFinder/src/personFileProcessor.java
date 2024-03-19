import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class personFileProcessor {
    public static ArrayList<String> processFile(String fileName) throws FileNotFoundException {
        ArrayList<String> oldestPeople = new ArrayList<>();

        Scanner fileIn = null;
        try {
            fileIn = new Scanner(new FileReader(fileName));
            int minAge = 0;
            while (fileIn.hasNextLine()) {
                String line = fileIn.nextLine();
                String[] parts = line.split(" ");
                int age = Integer.MAX_VALUE;
                StringBuilder name = new StringBuilder();

                for (int i = 0; i < parts.length; i++) {
                    if (parts[i].matches("\\d+")) {
                        age = Integer.parseInt(parts[i]);
                    } else {
                        name.append(parts[i]).append(" ");
                    }
                }

                // Trim any trailing whitespace from the name
                String personName = name.toString().trim();

                // If the age is less than the minimum age found so far, clear the list and add the new name
                if (age > minAge) {
                    oldestPeople.clear();
                    oldestPeople.add(personName);
                    minAge = age; // Update the minimum age
                } else if (age == minAge) {
                    // If the age is equal to the minimum age found so far, add the new name only
                    oldestPeople.add(personName);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (fileIn != null)
                fileIn.close();
        }
        return oldestPeople;
    }
}
