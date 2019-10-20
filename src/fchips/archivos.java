package fchips;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author jofer
 */
public class archivos {
    public archivos() {
        try {
            Scanner scanner = new Scanner(new File("test.txt"));
            while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
