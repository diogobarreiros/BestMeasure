package com.bestmeasure.sharedkernel.helper;

/**
 * Classe responsável por métodos uteis para aplicação.
 * @author diogo.barreiros
 *
 */
public class Util {

    /**
     * Método responsável por retornar um valor de um index a partir de de um ultimo id.
     * @return Long
     */
    public static Long getIndex(String ultimoId) {

        Long finalId = null;
        String finalParaIncrementar = "";

        char[] caracteres = ultimoId.toCharArray();

        for (int i=0; i<caracteres.length; i++) {
            Character charac = caracteres[i];
            String charactere = charac.toString();
            if(charactere.matches("[0-9]*")){
                finalParaIncrementar = finalParaIncrementar + caracteres[i];
            }else{
                break;
            }
        }

        finalId = Long.parseLong(finalParaIncrementar);
        return finalId;
    }
}
