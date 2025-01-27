import java.util.Scanner;
import java.util.List;

public class ManualImporter {
    public static List<Patron> run(Scanner scanner, List<Patron> patrons) {
        while (true) {
            int id = 0;
            String name = "";
            String address = "";
            double fine = 0.0;
            Patron patron;


            // ID
            while (true) {
                System.out.println("Enter patron ID or [exit] to exit:");

                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    continue;
                } else if (input.equals("exit")) {
                    return patrons;
                }

                if (Main.isPatronIdUsed(patrons, id)) {
                    System.out.println("A patron with the ID [" + id + "] already exists!");
                    continue;
                }

                id = Integer.parseInt(input);
                break;
            }

            // Name
            while (true) {
                System.out.println("Enter patron name or 'exit' to exit:");

                String input = scanner.nextLine().trim();
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

                String input = scanner.nextLine().trim();
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

                String input = scanner.nextLine().trim();
                if (input == null || input.isEmpty()) {

                } else if (input.equals("exit")) {
                    return patrons;
                } else {
                    fine = Double.parseDouble(input);
                    break;
                }
            }

            try {
                patron = new Patron(id, name, address, fine);
            } catch (Exception e) {
                System.out.println("Patron [" + id + "] could not be created.\n" + e.getMessage());
                continue;
            }

            patrons.add(patron);
        }
    }
}
