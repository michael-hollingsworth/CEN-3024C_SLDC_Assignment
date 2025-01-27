import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class TxtImporter {
    public static List<Patron> run(Scanner scanner, List<Patron> patrons) {
        while (true) {
            System.out.println("Enter full path to CSV file or [exit] to exit:");

            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {

            } else if (input.equals("exit")) {
                return patrons;
            }

            input = input.replaceAll("^\"|\"$", "");

            File txtFile = new File(input);
            if (txtFile.exists()) {
                try {
                    List<Patron> importedPatrons = Import(txtFile);
                    for (Patron patron : importedPatrons) {
                        patrons.add(patron);
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("File path [" + input + "] could not be found.\n");
                }
            } else {
                System.out.println("File path [" + input + "] could not be found.\n");
            }
        }
    }

    public static List<Patron> Import(File txtFile) throws FileNotFoundException {
        Scanner txtScanner = new Scanner(txtFile);

        List<Patron> patrons = new ArrayList<Patron>();
        Patron patron;

        while (txtScanner.hasNextLine()) {
            String line = txtScanner.nextLine();
            String[] values = line.split("-");

            if (values.length != 4) {
                System.out.println("Line [" + line + "] is incorrectly formatted.");
                continue;
            }

            int id = Integer.parseInt(values[0]);
            String name = values[1];
            String address = values[2];
            double fine = Double.parseDouble(values[3]);

            if (Main.isPatronIdUsed(patrons, id)) {
                System.out.println("A patron with the ID [" + id + "] already exists!");
                continue;
            }

            try {
                patron = new Patron(id, name, address, fine);
            } catch (Exception e) {
                System.out.println("Patron [" + id + "] could not be created.\n" + e.getMessage());
                continue;
            }

            System.out.println("Importing patron [" + patron.toString() + "].");
            patrons.add(new Patron(id, name, address, fine));
        }

        txtScanner.close();

        return patrons;
    }
}
