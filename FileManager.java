package es.codegym.task.pro;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class FileManager {

    public FileManager(String File_in, String File_out, Map< Integer, Character> abcCesar, Map < Character,Integer> abcDario) {
        try {
            Path path = Paths.get(File_in);
            Path pathFileOut = Paths.get(File_out);

            byte[] bytes = Files.readAllBytes(path);

            String datos = new String(bytes, StandardCharsets.UTF_8);
            char[] chars = datos.toCharArray();

            int posLetraIni;
            char newLetra;

            String datosCifrados="";
            for (char letra: chars) {

                if (abcDario.get(letra)!= null) {
                    posLetraIni = abcDario.get(letra);
                    newLetra = abcCesar.get(posLetraIni);
                } else {
                    newLetra = letra;
                }
                datosCifrados = datosCifrados + newLetra;

            }
            Files.write(pathFileOut, datosCifrados.getBytes(), StandardOpenOption.CREATE );

        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("Ocurrió un errror al grabar el archivo");
            e.printStackTrace();
        }

    }

}
