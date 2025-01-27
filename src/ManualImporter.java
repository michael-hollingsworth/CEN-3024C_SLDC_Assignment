import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;

public class ManualImporter {
    public static List<Patron> main(List<Patron> patrons) {
        // Scanner for user input
        Scanner manualInputScanner = new Scanner(System.in);

        try {
            while (true) {
                int id = 0;
                String name = "";
                String address = "";
                double fine = 0.0;


                // ID
                while (true) {
                    System.out.println("Enter patron ID or 'exit' to exit:");

                    String input = manualInputScanner.nextLine().trim();
                    if (input == null || input.isEmpty()) {

                    } else if (input.equals("exit")) {
                        return patrons;
                    } else {
                        id = Integer.parseInt(input);
                        break;
                    }
                }

                // Name
                while (true) {
                    System.out.println("Enter patron name or 'exit' to exit:");

                    String input = manualInputScanner.nextLine().trim();
                    if (input == null || input.isEmpty()) {

                    } else if (input.equals("exit")) {
                        return patrons;
                    } else {
                        name = input;
                        break;
                    }
                }

                // Address
                while (true) {
                    System.out.println("Enter patron address or 'exit' to exit:");

                    String input = manualInputScanner.nextLine().trim();
                    if (input == null || input.isEmpty()) {

                    } else if (input.equals("exit")) {
                        return patrons;
                    } else {
                        address = input;
                        break;
                    }
                }

                // Fine
                while (true) {
                    System.out.println("Enter patron fine or 'exit' to exit:");

                    String input = manualInputScanner.nextLine().trim();
                    if (input == null || input.isEmpty()) {

                    } else if (input.equals("exit")) {
                        return patrons;
                    } else {
                        fine = Double.parseDouble(input);
                        break;
                    }
                }

                patrons.add(new Patron(id, name, address, fine));
            }
        } finally {
            manualInputScanner.close();
        }
    }
}
