import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Scanner for user input
        Scanner menuScanner = new Scanner(System.in);
        int choice;

        List<Patron> patrons = new ArrayList<Patron>();

        try {
            while (true) {
                // Options
                System.out.println("Enter the number of one of the options below and press enter:");
                System.out.println("0: Exit");
                System.out.println("1: Import patron from CSV file.");
                System.out.println("2: Manually enter new patron.");
                System.out.println("3: Remove patron.");
                System.out.println("4: View list of patrons");
                //System.out.println("5: Export list of patrons");

                choice = menuScanner.nextInt();
                switch (choice) {
                    case 0:
                        System.exit(0);
                        return;
                    case 1:
                        patrons = CsvImporter.main(patrons);
                        break;
                    case 2:
                        patrons = ManualImporter.main(patrons);
                        break;
                    case 3:
                        patrons = RemovePatrons.main(patrons);
                        break;
                    case 4:
                        for (Patron patron : patrons) {
                            System.out.println(patron.toString());
                        }
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid input\n");
                        break;
                }
            }
        } finally {
            menuScanner.close();
        }
    }
}