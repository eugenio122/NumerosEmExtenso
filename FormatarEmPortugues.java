package ExercicioTDD;

/**
 * Created by Eugenio on 05/06/2017.
 */
public class FormatarEmPortugues implements IExercicioTeste {

    @Override
    public String setFormatarNumero(int numero) {
        String valor = String.valueOf(numero);

        String[] unidade = {"", "um", "dois", "três", "quatro", "cinco", "seis", "sete", "oito", "nove", "dez",
                "onze", "doze", "treze", "quatorze", "quinze", "dezesseis", "dezessete", "dezoito", "dezenove"};

        String[] dezena = {"", "dez", "vinte", "trinta", "quarenta", "cinquenta", "sessenta", "setenta", "oitenta", "noventa"};

        String[] centena = {"", "cento", "duzentos", "trezentos", "quatrocentos", "quinhentos", "seiscentos", "setecentos", "oitocentos", "novecentos"};
        String aux = "";
        if(numero < 0) {
            return "Não é permitido numeros negativos!";
        } if(numero == 0){
            return "zero";
        } else {
            if (numero % 10 != 0) {
                if (numero < 20) {
                    for (int i = 0; i < 20; i++) {
                        if (valor.equals(String.valueOf(i))) {//De 1 até 19 sem multiplos de 10 = 1 palavra
                            aux = unidade[i];
                            i = 19;
                        }
                    }
                } else if (numero > 20 && numero < 99) { //De 21 até 99 sem multiplos de 10 = 3 palavras
                    for (int i = 1; i < 10; i++) {
                        for (int j = 1; j < 10; j++) {
                            int multiplicar = i * 10;
                            int somar = multiplicar + j;
                            if (somar == Integer.valueOf(valor)) {
                                aux = dezena[i] + " e " + unidade[j];
                                i = 9;
                                j = 9;
                            }
                        }
                    }
                } else if (numero > 100 && numero < 120) {//De 101 até 119 sem multiplos de 10 ou de 100 = 3 palavras
                    for (int i = 1; i < 20; i++) {
                        int somar = 100 + i;
                        if (valor.equals(String.valueOf(somar))) {
                            aux = centena[1] + " e " + unidade[i];
                        }
                    }
                } else if (numero > 120 && numero < 1000) { //De 121 até 999 sem multiplos de 10 ou de 100 = 5 palavras
                    for (int i = 1; i < 10; i++) {
                        for (int j = 1; j < 10; j++) {
                            for (int k = 1; k < 10; k++) {
                                int multiplicarI = i * 100;
                                int multiplicarJ = j * 10;
                                int somar = multiplicarI + multiplicarJ + k;
                                if (valor.equals(String.valueOf(somar))) {
                                    aux = centena[i] + " e " + dezena[j] + " e " + unidade[k];
                                    i = 9;
                                    j = 9;
                                    k = 9;
                                }
                            }
                        }
                    }
                }
            } else {
                if (numero < 100) {
                    for (int i = 10; i <= 99; i++) {
                        if (valor.equals(String.valueOf(i))) { //Multiplos de 10, de 10 até 99 = 1 palavra
                            int resto = i / 10;
                            aux = dezena[resto];
                            i = 98;
                        }
                    }
                } else { //Multiplos de 100, de 100 até 999 = 1 palavra
                    if (numero == 100) {
                        aux = "cem";
                    } else {
                        if (numero % 100 == 0) {
                            for (int i = 2; i < 10; i++) {
                                int multiplicar = i * 100;
                                if (valor.equals(String.valueOf(multiplicar))) {
                                    aux = centena[i];
                                    i = 9;
                                }
                            }
                        } else if (numero / 10 != 0) { //Multiplos de 10, de 110 até 999 = 3 palavras
                            for (int i = 1; i < 10; i++) {
                                for (int j = 1; j < 10; j++) {
                                    int multiplicarI = i * 100;
                                    int multiplicarJ = j * 10;
                                    int somar = multiplicarI + multiplicarJ;
                                    if (somar == Integer.valueOf(valor)) {
                                        aux = centena[i] + " e " + dezena[j];
                                        i = 9;
                                        j = 9;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return aux;
        }
    }

}
