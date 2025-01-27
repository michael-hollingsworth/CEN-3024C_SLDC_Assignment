import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class RemovePatrons {
    public static List<Patron> main(List<Patron> patrons) {

        // Scanner for user input
        Scanner removeScanner = new Scanner(System.in);

        try {
            while (true) {
                // Options
                System.out.println("Enter the ID of the patron you want to remove or 'exit' to exit:");

                String input = removeScanner.nextLine().trim();
                if (input == null || input.isEmpty()) {

                } else if (input.equals("exit")) {
                    return patrons;
                }

                int id = Integer.parseInt(input);
                for (Patron patron : patrons) {
                    if (patron.id == id) {
                        patrons.remove(patron);
                    }
                }
            }
        } finally {
            removeScanner.close();
        }
    }
}
