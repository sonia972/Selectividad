package selectividad;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import static jdk.nashorn.internal.parser.TokenType.EOF;

public class Selectividad {

    public static void main(String[] args) throws IOException {

        LeerFichero accediendo = new LeerFichero();
        accediendo.lee();

        LeerFichero2 accediendo2 = new LeerFichero2();
        accediendo2.leer();

        //declarar arrays 
        Carreras tc[];
        tc = new Carreras[60];
        Carreras.cargar(tc);

        FileInputStream festudiantes = new FileInputStream("c:/ficherosjava/Festudiantes.txt");
        InputStreamReader isr = new InputStreamReader(festudiantes, "UTF8");
        BufferedReader buffer = new BufferedReader(isr);
        String linea;

        int cl = 0;
        while ((linea = buffer.readLine()) != null) {
            if (linea.length() != 0) {
                cl++;
                String fa[] = linea.split(" ");

                int nota = Integer.parseInt(fa[0]);
                int dni = Integer.parseInt(fa[1]);
                int op1 = Integer.parseInt(fa[2]);
                int op2 = Integer.parseInt(fa[3]);
                int op3 = Integer.parseInt(fa[4]);
                
                Carreras.localizar(tc, op1]);

            }
        }

    }
}

class LeerFichero {

    public void lee() throws IOException {

        // FileInputStream, lee bytes. Aquí leemos el fichero y lo guardamos en la variable
        FileInputStream fcarreras = new FileInputStream("c:/ficherosjava/Fcarreras.txt");
        //transforma 
        InputStreamReader isr1 = new InputStreamReader(fcarreras, "UTF8");
        /*los buffer son memorias intermedias, la clase input.... nos da caracteres sueltos, el buffer 
        nos lee todo y nos lo da junto, debemos instanciarlo pasándole el constructor reader, que es isr*/
        //relaciono el buffer que voy a usar...
        BufferedReader buffer1 = new BufferedReader(isr1);
        String linea;
        int cl = 0; // contador de lineas
        System.out.println("   FICHERO CARRERAS   ");
        //while (NO (EOF) fcarreras){
        while ((linea = buffer1.readLine()) != null) {
            if (linea.length() != 0) {
                cl++;
                System.out.println("--------");
                String fa[] = linea.split(" ");

                System.out.print(cl);
                System.out.print(" Codigo: ");
                System.out.print(fa[0]);
                System.out.print(" Nplazas: ");
                System.out.print(fa[1]);

            }

        }
        buffer1.close();
    }
}

class LeerFichero2 {

    public static void leer() throws IOException {

        FileInputStream festudiantes = new FileInputStream("c:/ficherosjava/Festudiantes.txt");
        InputStreamReader isr = new InputStreamReader(festudiantes, "UTF8");

        BufferedReader buffer = new BufferedReader(isr);
        String linea;
        int cl = 0; // contador de lineas
        System.out.println("");
        System.out.println("");
        System.out.println("   FICHERO ESTUDIANTES   ");
        while ((linea = buffer.readLine()) != null) {
            if (linea.length() != 0) {
                cl++;
                System.out.println("--------------------");
                String fa[] = linea.split(" ");

                System.out.print(cl);
                System.out.print(" Nota: ");
                System.out.print(fa[0] + " ");
                System.out.print("  DNI: ");
                System.out.print(fa[1]);
                System.out.print(" op1 ");
                System.out.print(fa[2]);
                System.out.print(" op2 ");
                System.out.print(fa[3]);
                System.out.print(" op3 ");
                System.out.print(fa[4]);

            }

        }
        buffer.close();
    }
}

class Carreras {

    int cod;
    int nplazas;

    public Carreras(int cod, int nplazas) {
        this.cod = cod;
        this.nplazas = nplazas;
    }

    public static void cargar(Carreras aaa[]) throws IOException {

        FileInputStream fcarreras = new FileInputStream("c:/ficherosjava/Fcarreras.txt");
        InputStreamReader isr1 = new InputStreamReader(fcarreras, "UTF8");
        BufferedReader buffer1 = new BufferedReader(isr1);
        System.out.println(" ");
        System.out.println("");
        String linea;
        int i = 0; // contador de lineas

        while ((linea = buffer1.readLine()) != null) {
            if (linea.length() != 0) {

                String fa[] = linea.split(" ");

                aaa[i] = new Carreras(Integer.parseInt(fa[0]), Integer.parseInt(fa[1]));
                System.out.println(+aaa[i].cod + " >> " + aaa[i].nplazas);

            }
        }
        buffer1.close();
    }

    public static void localizar(Carreras aaa[], int op1) throws IOException {

        for (int i = 0; i < aaa.length; i++) {
            if (op1 == aaa[i].cod) {
                // busca la carrera
                System.out.println("Carreras : " + aaa[i].cod + " >> " + aaa[i].nplazas);
            }
        }
    }
}
