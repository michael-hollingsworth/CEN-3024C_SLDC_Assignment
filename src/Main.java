import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        String choice;
        int choiceInt;

        List<Patron> patrons = new ArrayList<Patron>();

        try {
            while (true) {
                // Options
                System.out.println("Enter the number of one of the options below and press enter:");
                System.out.println("0: Exit");
                System.out.println("1: Import patron(s) from text file.");
                System.out.println("2: Manually enter new patron.");
                System.out.println("3: Remove patron.");
                System.out.println("4: View list of patrons");
                //System.out.println("5: Export list of patrons");

                choice = scanner.nextLine();
                try {
                    choiceInt = Integer.parseInt(choice);
                } catch (NumberFormatException e)  {
                    System.out.println("Invalid input! Please enter an integer.\n");
                    continue;
                }
                switch (choiceInt) {
                    case 0:
                        System.exit(0);
                        return;
                    case 1:
                        patrons = TxtImporter.run(scanner, patrons);
                        break;
                    case 2:
                        patrons = ManualImporter.run(scanner, patrons);
                        break;
                    case 3:
                        patrons = RemovePatrons.run(scanner, patrons);
                        break;
                    case 4:
                        System.out.println();
                        System.out.println("Patrons:");
                        for (Patron patron : patrons) {
                            System.out.println(patron.toString());
                        }
                        System.out.println();

                        System.out.println("Press [enter] to continue.");
                        choice = scanner.nextLine();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid input\n");
                        break;
                }
            }
        } finally {
            scanner.close();
        }
    }

    public static boolean isPatronIdUsed(List<Patron> patrons, int id) {
        for (Patron patron : patrons) {
            if (patron.getId() == id) {
                return true;
            }
        }

        return false;
    }
}