package es.codegym.task.pro;

import java.io.IOException;
import java.util.Map;

public class Cesar {

    public static final char [] ALFABETO = {
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
            'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            '«','\'',':','-','!','?',' ','á','é','í','ó','ú'
    };

    public static void main(String[] argvs) throws InterruptedException, IOException {

        Menu opcion= new Menu();
        Valida valida = new Valida();
        Cifrar cifrar = new Cifrar();
        FileManager files;

        Map< Integer, Character> abcCesar;
        Map< Character,Integer> abcDario;

        int myKey;
        String inFile;
        String outFile;

        Runtime.getRuntime().exec("cmd cls");
        int resp = 0;

        do {
            resp = opcion.menuMain();

            switch (resp) {
                case 1:

                    System.out.println("\n<<<  Encriptar  >>>");

                    //************************  Archivo a Encriptar  *****************************
                    inFile = valida.ioFile("Introduzca el Archivo de Entrada: ", "input");
                    if (inFile == null){
                        resp = 3;
                        break;
                    }
                    // ***********************  Archivo de Salida ********************************
                    outFile = valida.ioFile("Introduzca el Archivo de Salida: ", "output");
                    if (outFile == null){
                        resp = 3;
                        break;
                    }

                    if(outFile.equals(inFile)){
                        System.out.println("El archivo de entrada no puede ser el mismo de salida");
                        resp = 3;
                        break;
                    }

                    // ***********************  Llave  *******************************************
                    myKey = valida.Llave(ALFABETO.length);


                    abcCesar = cifrar.Cifrado(ALFABETO, myKey);
                    abcDario = cifrar.Abcdario(ALFABETO);

                    files = new FileManager(inFile, outFile, abcCesar, abcDario);

                    System.out.println("\nArchivo Encriptado!!!");
                    System.out.println("\n\n\n");

                    break;

                case 2:

                    System.out.println("\n<<<  Desencriptar  >>>");

                    //************************  Archivo a Desencriptar  *****************************
                    inFile = valida.ioFile("Introduzca el Archivo de Entrada: ", "input");
                    if (inFile == null){
                        resp = 3;
                        break;
                    }
                    // ***********************  Archivo de Salida ********************************
                    outFile = valida.ioFile("Introduzca el Archivo de Salida: ", "output");
                    if (outFile == null){
                        resp = 3;
                        break;
                    }

                    // ***********************  Llave  *******************************************
                    myKey = valida.Llave(ALFABETO.length);

                    abcCesar = cifrar.Cifrado(ALFABETO, myKey);
                    abcDario = cifrar.Abcdario(ALFABETO);

                    char [] tmpAlfabeto = new char[ALFABETO.length];
                    for (int i=0; i<abcCesar.size(); i++ ) {
                        tmpAlfabeto[i] = abcCesar.get(i);
                    }

                    abcCesar= Cifrar.Descifrar_abcCesar(ALFABETO,abcCesar);
                    abcDario= Cifrar.Descifrar_abcDario(tmpAlfabeto,abcDario);
                    files = new FileManager(inFile, outFile, abcCesar, abcDario);

                    System.out.println("\nArchivo Desencriptado!!!");
                    System.out.println("\n\n\n");

                    break;
                case 3:
                    break;
                default:{
                    System.out.println("Solo se aceptan números del 1 al 3");
                }
            }

            Runtime.getRuntime().exec("cmd cls");

        } while (resp!=3);
        System.out.println("\nPrograma Finalizado!!!\n");
    }
}
