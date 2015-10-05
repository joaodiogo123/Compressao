package com.joaopires.compressao;

/**
 * Created by joaod on 02-Oct-15.
 */
public class Compressao {

    protected int i = 0;
    protected int j = 0;
    protected int atualComprimida = 0;
    protected int repetidos = 1;
    protected String caractes;
    protected char sequencia[];
    protected char sequenciaComprimida[] = new char[10000];
    protected char token[] = new char[100];
    protected char caracter;
    protected int k;

    public Compressao(String aComprmir){
        caractes = aComprmir;
        sequencia = caractes.toCharArray();
        k = sequencia.length;
    }



    public String comprimir(){

        for (i = 0; i < k; i++) {

            for (j = i + 1; j < k; j++) {
                System.out.println("i="+i);
                System.out.println("j="+j);

                if (sequencia[i] == sequencia[j]) {
                    //j++;
                    repetidos++;
                } else {
                    break;
                }
            }

            if (repetidos >= 3) {

                caracter = sequencia[i];
                token[0] = '!';
                token[1] = (char)(repetidos + '0');
                token[2] = caracter;


                sequenciaComprimida[atualComprimida] = token[0];
                atualComprimida++;
                //tam_sequenciaComprimida++;
                sequenciaComprimida[atualComprimida] = token[1];
                atualComprimida++;
                //tam_sequenciaComprimida++;
                sequenciaComprimida[atualComprimida] = token[2];
                atualComprimida++;
                //tam_sequenciaComprimida++;

                i = j - 1;

            }

            if (repetidos == 2) { //Eficiência. Para que quando temos dois repetidos o programa não passe o primeiro para o comprimido e depois vá verificar outra vez a original e passa a proxima.
                sequenciaComprimida[atualComprimida] = sequencia[i];
                atualComprimida++;
                //tam_sequenciaComprimida++;

                sequenciaComprimida[atualComprimida] = sequencia[j - 1];
                atualComprimida++;
                //tam_sequenciaComprimida++;

                i = j - 1;
            }

            if (repetidos == 1) {
                sequenciaComprimida[atualComprimida] = sequencia[i];
                atualComprimida++;
                //tam_sequenciaComprimida++;
            }
            repetidos = 1;
        }


        String q = new String(sequenciaComprimida);

        return q;
    }

}