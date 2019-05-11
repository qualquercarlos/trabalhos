package algoritmoprioridade;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author crb28
 */
public class AlgoritmoPrioridade {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int tamanho = 10;
        System.out.println("---------------BEM-VINDO AO SIMULADOR DE ESCALONAMENTO POR PRIORIDADE---------------");
        System.out.print("DETERMINE QUANTOS PROCESSOS: ");
        tamanho = teclado.nextInt();
        int processos[][] = new int[3][tamanho];
        processos = gerarProcessos(processos, tamanho);
        System.out.println("FILA DE PRONTOS: ");
        System.out.println(" ID   PR   UT  ");
        mostrarProcessos(processos, tamanho);
        organizarProcessos(processos, tamanho);
        executarProcessos(processos, tamanho);
        System.out.println("HISTÓRICO DE EXECUÇÃO: ");
        System.out.println(" ID   PR   UT  ");
        mostrarProcessos(processos, tamanho);
        System.out.print("---------------FIM DE EXECUÇÃO---------------");

    }

    public static int[][] gerarProcessos(int processos[][], int tamanho) {
        Scanner teclado = new Scanner(System.in);
        Random Rand = new Random();
        int proc[][] = new int[3][tamanho];

        for (int j = 0; j < tamanho; j++) {
            proc[0][j] = j + 1;
        }

        for (int j = 0; j < tamanho; j++) {
            proc[1][j] = Rand.nextInt(4);
            proc[1][j] += 1;
        }

        for (int j = 0; j < tamanho; j++) {
            proc[2][j] = Rand.nextInt(11);
            proc[2][j] += 1;
        }
        return proc;
    }

    public static int[][] organizarProcessos(int processos[][], int tamanho) {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < i; j++) {
                if (processos[1][i] > processos[1][j]) {
                    int temp = processos[0][i];
                    processos[0][i] = processos[0][j];
                    processos[0][j] = temp;

                    temp = processos[1][i];
                    processos[1][i] = processos[1][j];
                    processos[1][j] = temp;

                    temp = processos[2][i];
                    processos[2][i] = processos[2][j];
                    processos[2][j] = temp;
                }
            }
        }

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < i; j++) {
                if (processos[1][i] == processos[1][j]) {
                    if (processos[2][i] < processos[2][j]) {
                        int aux = processos[0][i];
                        processos[0][i] = processos[0][j];
                        processos[0][j] = aux;

                        aux = processos[1][i];
                        processos[1][i] = processos[1][j];
                        processos[1][j] = aux;

                        aux = processos[2][i];
                        processos[2][i] = processos[2][j];
                        processos[2][j] = aux;
                    }
                }

            }
        }
        return processos;
    }

    public static int[][] mostrarProcessos(int processos[][], int tamanho) {
        for (int j = 0; j < tamanho; j++) {
            for (int i = 0; i < 3; i++) {
                System.out.print("  " + processos[i][j] + "  ");
            }
            System.out.print("\n");
        }
        return processos;
    }

    public static int[][] executarProcessos(int processos[][], int tamanho) {
        Scanner teclado = new Scanner(System.in);
        String resposta = "s";
        int soma = 0;
        for (int j = 0; resposta.equalsIgnoreCase("s") && j < tamanho; j++) {
            System.out.println("EXECUTANDO...");
            System.out.println(" ID   PR   UT  ");
            soma += processos[2][j];
            if (j == 0 && j % 2 == 0) {
                if (processos[1][tamanho - 2] != 5) {
                    processos[1][tamanho - 2] += 1;
                }
                if (processos[1][tamanho - 1] != 5) {
                    processos[1][tamanho - 1] += 1;
                }
                organizarProcessos(processos, tamanho);
            }
            System.out.print("  " + processos[0][j] + "  " + "  " + processos[1][j] + "  " + "  " + soma);
            System.out.print("\n");
            if (j == (tamanho - 1)) {
                break;
            }
            System.out.println("EXECUTAR PROXIMO PROCESSO? [S]IM OU [N]AO");
            resposta = teclado.next();
        }
        return processos;
    }
}
