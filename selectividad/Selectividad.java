package selectividad;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Selectividad {

    public static void main(String[] args) throws IOException {

        FileInputStream fichero;// Vamos a leer un fichero
        BufferedReader buffer; //utilizando un buffer
        InputStreamReader isr; //método de lectura

        /* fichero = new FileInputStream("c:/ficherosjava/FCARRERAS.txt");
        isr = new InputStreamReader(fichero, "UTF8"); //método que uso para leer
        buffer = new BufferedReader(isr); //relaciono el buffer que voy a usar...

        String linea;
        while ((linea = buffer.readLine()) != null) {

            if (linea.length() != 0) { // filtra líneas en blanco
                String fc[] = linea.split(" ");

            }
        }*/
        fichero = new FileInputStream("c:/ficherosjava/Festudiantes.txt");
        isr = new InputStreamReader(fichero, "UTF8");
        buffer = new BufferedReader(isr);
        String linea;
        //while ( NO(EOF)  Festudiantes    ){
        while ((linea = buffer.readLine()) != null) {
            if (linea.length() != 0) { // filtra líneas en blanco

                String fa[] = linea.split(" ");
                //System.out.print(linea);
                
                System.out.print (""); 
                //System.out.print("Nota: ");
                //System.out.print(fa[0]); 
                System.out.print(" DNI: ");
                System.out.println(fa[1]);
                System.out.print(" op1: ");
                System.out.print(fa[2]);
                System.out.print(" op2: ");
                System.out.println(fa[3]);
                System.out.print(" op3: ");
                System.out.print(fa[4]);
                
                
            }

        }    
        //}
        buffer.close();
    }
}