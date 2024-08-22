package es.codegym.task.pro;

import java.util.Scanner;

public class Menu {
    int opc;
    public int menuMain(){
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("<<<  Menu Principal  >>>");
            System.out.println("1.- Encriptar");
            System.out.println("2.- Desencriptar");
            System.out.println("3.- Salir");
            System.out.print("Elige una opción: ");
            try {
                opc= teclado.nextInt();
                if(opc < 1 || opc > 3){
                    System.out.println("Teclee un número entre 1 y 3");
                }
            } catch (Exception e) {
                //ejecutar = true;
                System.out.println("Teclee un número entre 1 y 3");
                teclado.next();
            }
        } while(opc < 1 || opc > 3);

        return opc;
    }

}
