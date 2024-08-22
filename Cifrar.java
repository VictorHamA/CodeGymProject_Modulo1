package es.codegym.task.pro;

import java.util.HashMap;
import java.util.Map;

public class Cifrar {

    public Map < Integer, Character>Cifrado(char[] ALFABETO, int llave) {

        Map< Integer, Character> abcCesar = new HashMap<>();

        int tamanioAlfabeto = ALFABETO.length;

//	  Formula Derecha = (PA + K + tamArreglo) % tamArreglo
        int newPos;
        for (int i=0; i < tamanioAlfabeto; i++) {
            newPos = ( i + llave + tamanioAlfabeto ) % tamanioAlfabeto;
            abcCesar.put(i, ALFABETO[newPos]);
        }


        return abcCesar;
    }

    public Map < Character, Integer>Abcdario(char[] ALFABETO) {

        Map<Character,Integer> abcDario = new HashMap<>();

        for (int i=0; i < ALFABETO.length; i++) {
            abcDario.put(ALFABETO[i],i);
        }

        return abcDario;
    }

    public static Map < Character, Integer> Descifrar_abcDario(char[] tmpAlfabeto, Map < Character, Integer>abcDario) {

        for(int i=0; i<tmpAlfabeto.length; i++){
            abcDario.replace(tmpAlfabeto[i],i);
        }
        return abcDario;

    }

    public static Map < Integer, Character> Descifrar_abcCesar(char[] tmpAlfabeto, Map < Integer,Character> abcCesar) {

        for (int i=0; i<tmpAlfabeto.length; i++ ) {
            abcCesar.replace(i, tmpAlfabeto[i]);
        }
        return abcCesar;

    }

}

