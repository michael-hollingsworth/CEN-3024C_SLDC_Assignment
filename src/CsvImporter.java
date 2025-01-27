import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class CsvImporter {
    public static List<Patron> main(List<Patron> patrons) {
        // Scanner for user input
        Scanner pathScanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("Enter full path to CSV file or 'exit' to exit:");

                String input = pathScanner.nextLine().trim();
                if (input == null || input.isEmpty()) {

                } else if (input.equals("exit")) {
                    return patrons;
                }

                File csvFile = new File(input);
                if (csvFile.exists()) {
                    try {
                        List<Patron> importedPatrons = Import(csvFile);
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
        } finally {
            pathScanner.close();
        }
    }

    public static List<Patron> Import(File csvFile) throws FileNotFoundException {
        Scanner csvScanner = new Scanner(csvFile);

        List<Patron> patrons = new ArrayList<Patron>();

        while (csvScanner.hasNextLine()) {
            String line = csvScanner.nextLine();
            String[] values = line.split("-");

            int id = Integer.parseInt(values[0]);
            String name = values[1];
            String address = values[2];
            double fine = Double.parseDouble(values[3]);

            patrons.add(new Patron(id, name, address, fine));
        }

        csvScanner.close();

        return patrons;
    }
}
