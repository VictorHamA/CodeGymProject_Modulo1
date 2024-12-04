package es.codegym.task.pro;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Valida {

    public boolean fileExist(String myFile, String input_output) {
        boolean retVal = false;

        if (myFile.isEmpty()){
            System.out.println("Introduzca una ruta y archivo valido");
            retVal = false;
        }

        switch (input_output.toLowerCase()) {
            case "input":
                if( Files.notExists(Path.of(myFile))) {
                    System.out.println("El archivo no existe, favor de verificarlo");
                    retVal = false;
                } else {
                    retVal = true;
                }
                break;
            case "output":
                if( Files.exists(Path.of(myFile))) {
                    System.out.println("El archivo ya existe!!!");
                    retVal = false;
                } else {
                    retVal = true;
                }
                break;

        }

        return retVal;

    }

    public String ioFile(String mensaje, String in_out) {

        Scanner teclado = new Scanner(System.in);

        boolean ejecutar = true;
        String retFile ="";
        String resp="S";

        do {

            try {
                //System.out.println();
                System.out.print(mensaje);
                retFile= teclado.nextLine();
                ejecutar = fileExist(retFile, in_out);

                if(!ejecutar) {
                   retFile = null;
                   break;
                }

            } catch (Exception e) {
                ejecutar = false;
                System.out.println("Ruta o Archivo Invalido");
                teclado.next();
            }
        } while(!ejecutar);


        return retFile;
    }

    public static int Llave(int universo) {
        Scanner teclado = new Scanner(System.in);
        int key=0;
        boolean ejecutar;
        do {
            ejecutar = false;
            try {
                System.out.print("Teclee un número para la llave: ");
                key = teclado.nextInt();
                if (key <1 || key > universo) {
                    System.out.format("Teclee un numero entre 1 y %s\n\n",universo);
                    ejecutar = true;
                }
            } catch (Exception e) {
                ejecutar = true;
                System.out.format("Teclee un numero entre 1 y %s\n\n",universo);
                teclado.next();
            }

        } while (ejecutar);
        return key;
    }

}



