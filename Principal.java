package ExercicioTDD;

import java.util.Scanner;

/**
 * Created by Eugenio on 22/05/2017.
 */

public class Principal {
    public static void main(String[] args) throws Exception {
        FormatarEmPortugues f;
        Principal p = new Principal();
        Scanner ler = new Scanner(System.in);
        do {
            System.out.println("===== Digite uma das opções! =====");
            System.out.println("0 - Sair;");
            System.out.println("1 - Digitar um numero;");
            int opcao = ler.nextInt();

            switch (opcao) {
                case 0:
                    p.setSair(true);
                    break;

                case 1:
                    f = new FormatarEmPortugues();
                    System.out.println("Digite um numero: ");
                    int num = ler.nextInt();
                    System.out.println("Numero por extenso: "+f.setFormatarNumero(num));
                    break;
            }
        }while (p.getSair() == false);
    }

    private boolean sair = false;
    public boolean getSair() {
        return sair;
    }

    public void setSair(boolean value) {
        this.sair = value;
    }
}
