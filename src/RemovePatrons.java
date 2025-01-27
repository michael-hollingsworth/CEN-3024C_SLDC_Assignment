import java.util.Scanner;
import java.util.List;

public class RemovePatrons {
    public static List<Patron> run(Scanner scanner, List<Patron> patrons) {
        while (true) {
            // Options
            System.out.println("Enter the ID of the patron you want to remove or [exit] to exit:");

            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {

            } else if (input.equals("exit")) {
                return patrons;
            }

            int id = Integer.parseInt(input);
            for (Patron patron : patrons) {
                if (patron.id == id) {
                    System.out.println("Removing patron [" + patron.toString() + "].");
                    patrons.remove(patron);
                }
            }
        }
    }
}
