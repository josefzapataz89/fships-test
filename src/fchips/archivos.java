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
            Scanner scanner = new Scanner(new File("input.txt"));
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
            ships = this.iteracion(ships);
            System.out.println("iteracion " + i);
            System.out.println(ships);
        }
        
    }
    
    public char[] iteracion(char[] ships) {
        char[] aux_ships = new char[ships.length];
        
        for (int k = 0; k < ships.length; k++) {
            String auxiliar = "";
            if (k == 0) {
                auxiliar = ships[ships.length-1] + "" + ships[k] + "" + ships[k+1];
            } else if (k == (ships.length - 1)) {
                auxiliar = ships[k-1] + "" + ships[k] + "" + ships[0];
            } else {
                auxiliar = ships[k-1] + "" + ships[k] + "" + ships[k+1];
            }
            
            aux_ships[k] = this.color_ship(auxiliar);
        }
        
        return aux_ships;
    }
    
    public char color_ship(String cadena) {
        int count_w = 0;
        int count_b = 0;
        
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == 'W') {
                count_w++;
            }
            else {
                count_b++;
            }
        }
        
        return (count_w > count_b) ? "W".charAt(0) : "B".charAt(0);
    }
}
