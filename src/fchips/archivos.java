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
                String p_linea;
                p_linea = scanner.nextLine();                
                this.proceso(Integer.parseInt(p_linea.split(" ")[0]), Integer.parseInt(p_linea.split(" ")[1]), scanner.nextLine().toCharArray());               
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void proceso(int cantidad_ships, int iteraciones, char[] ships) {
        
        if (cantidad_ships < 3 || cantidad_ships > 200000) {
            System.out.println("Cantidad de embarcaciones fuera de rango");
            return;
        }
        
        if (iteraciones < 1 || iteraciones > 1000000000) {
            System.out.println("Cantidad de iteraciones fuera de rango");
            return;
        }
        
        for(int i = 1; i <= iteraciones; i++) {
            System.out.println("ships " + ships.toString());
            ships = this.iteracion(ships);
            System.out.println("iteracion " + i);
            System.out.println(ships.toString());
        }
    }
    
    public char[] iteracion(char[] ships) {
        
    }
}
