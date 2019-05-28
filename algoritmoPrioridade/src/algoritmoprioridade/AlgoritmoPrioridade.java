package algoritmoprioridade;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @autor Carlos Rafael
 */
public class AlgoritmoPrioridade {

   public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int tamanho, tempo, parametro = 0;
        System.out.println("---------------BEM-VINDO AO SIMULADOR DE ESCALONAMENTO POR PRIORIDADE---------------");
        //Lê do teclado o número de processos que serão efetuados
        System.out.print("DETERMINE QUANTOS PROCESSOS: ");
        tamanho = teclado.nextInt();
        //Lê do teclado o tempo de processador dedicado a cada processo
        System.out.print("DETERMINE O TEMPO DE PROCESSADOR DE CADA PROCESSO: ");
        tempo = teclado.nextInt();
        //Cria um vetor bi-dimensional
        int processos[][] = new int[5][tamanho];
        /**
         * Colunas:
         * 0 = identificação 
         * 1 = prioridade 
         * 2 = unidade fixa de tempo que o processo necessita
         * 3 = parametro que define se foi executado ou se está pronto para execução
         * 4 = unidade dinâmica de tempo que o processo necessita
         */
       
        
        /**
         * Preenche com números aleatórios o vetor bi-dimensional respeitando o
         * número de processos, número de prioridades e estabelecendo uma
         * identificação única
         */
        processos = gerarProcessos(processos, tamanho);
        /**
         * Exibe a lista de processos que serão executados juntamente com um
         * cabeçalho de identificação de valores
         */
        System.out.println("FILA DE PRONTOS: ");
        // ID = identificação
        //PR = prioridade
        // UT = unidade de tempo
        //ST = status
        //TD = tempo decorrido
        System.out.println(" ID   PR   UT   ST");
        mostrarProcessos(processos, tamanho, parametro);
        /**
         * Organiza os processos por prioridade. Em casos de processos de
         * prioridade igual o de menor tempo de execução passa a frente
         */
        organizarProcessos(processos, tamanho);
        /**
         * Simula a passagem dos processos pelo processamento, só que com o
         * controle do usuário
         */
        executarProcessos(processos, tamanho, tempo, parametro);
        System.out.println("*FILA ZERADA*");
        //Mostra a lista de processos que foram executados
        System.out.println("PROCESSOS EXECUTADOS:");
        mostrarHistorico(processos, tamanho, parametro);
        
        System.out.println("---------------FIM DE EXECUÇÃO---------------");

    }

    public static int[][] gerarProcessos(int processos[][], int tamanho) {
        Scanner teclado = new Scanner(System.in);
        Random Rand = new Random();
        int proc[][] = new int[5][tamanho];

        for (int j = 0; j < tamanho; j++) {
            proc[0][j] = j + 1;
        }

        for (int j = 0; j < tamanho; j++) {
            proc[1][j] = Rand.nextInt(5);
        }

        for (int j = 0; j < tamanho; j++) {
            proc[2][j] = Rand.nextInt(11);
            proc[2][j]++;
            proc[4][j] = proc[2][j];

        }
        for (int j = 0; j < tamanho; j++) {
            proc[3][j] = 0;
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

                    temp = processos[3][i];
                    processos[3][i] = processos[3][j];
                    processos[3][j] = temp;

                    temp = processos[4][i];
                    processos[4][i] = processos[4][j];
                    processos[4][j] = temp;
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

                        aux = processos[3][i];
                        processos[3][i] = processos[3][j];
                        processos[3][j] = aux;

                        aux = processos[4][i];
                        processos[4][i] = processos[4][j];
                        processos[4][j] = aux;
                    }
                }

            }
        }
        return processos;
    }

    public static void mostrarProcessos(int processos[][], int tamanho, int parametro) {

        for (int j = 0; j < tamanho; j++) {
            for (int i = 0; i < 3; i++) {
                if (processos[3][j] == parametro) {
                    System.out.print("  " + processos[i][j] + "  ");
                }

            }
            if (processos[3][j] == parametro) {
                System.out.print(" PRONTO");
                System.out.print("\n");

            }

        }
    }

    public static int[][] executarProcessos(int processos[][], int tamanho, int tempo, int parametro) {
        Scanner teclado = new Scanner(System.in);
        String resposta = "s";
        int soma = 0;
        int j = 1;
        while (resposta.equalsIgnoreCase("s")) {
            System.out.println("EXECUTANDO...");

            if (tempo >= processos[4][j - 1]) {
                System.out.println("---------------------------------------------------------------");
                System.out.println(" ID   PR   UT   TD   ST");
                System.out.println("  " + processos[0][j - 1] + "   " + processos[1][j - 1] + "    " + processos[2][j - 1] + "    " + soma + "    " + "PRONTO");
                System.out.println("EXECUTANDO...");
                soma = (soma + processos[4][j - 1]);
                System.out.println(" ID   PR   UT   TD   ST");
                System.out.println("  " + processos[0][j - 1] + "   " + processos[1][j - 1] + "    " + processos[2][j - 1] + "    " + soma + "    " + "EXECUTADO");
                processos[3][j - 1] = 1;
                soma++;
                System.out.println("---------------------------------------------------------------");
                j++;
                if (((j - 1) != 0 && (j - 1) % 2 == 0) && tamanho >= 5) {
                    if (processos[1][tamanho - 2] != 5) {
                        processos[1][tamanho - 2] += 1;
                    }
                    if (processos[1][tamanho - 1] != 5) {
                        processos[1][tamanho - 1] += 1;
                    }
                    organizarProcessos(processos, tamanho);
                }

            } else {
                processos[4][j - 1] = processos[4][j - 1] - tempo;
                System.out.println("---------------------------------------------------------------");
                System.out.println(" ID   PR   UT   TD   ST");
                System.out.println("  " + processos[0][j - 1] + "   " + processos[1][j - 1] + "    " + processos[2][j - 1] + "    " + soma + "    " + "PRONTO");
                soma = (soma + tempo);
                System.out.println("EXECUTANDO...");
                System.out.println(" ID   PR   UT   TD   ST");
                System.out.println("  " + processos[0][j - 1] + "   " + processos[1][j - 1] + "    " + processos[2][j - 1] + "    " + soma + "    " + "BLOQUEADO");
                soma++;
                System.out.println("---------------------------------------------------------------");

            }
            organizarProcessos(processos, tamanho);

            System.out.println("FILA DE PRONTOS: ");
            System.out.println(" ID   PR   UT   ST");
            mostrarProcessos(processos, tamanho, parametro);

            if (j == (tamanho + 1)) {
                resposta = "n";
            } else {
                System.out.println("EXECUTAR PROXIMO PROCESSO? [S]IM OU [N]AO");
                resposta = teclado.next();
            }
        }
        return processos;
    }

    public static void mostrarHistorico(int processos[][], int tamanho, int parametro) {
        System.out.println(" ID   PR   UT   ST");
        for (int j = 0; j < tamanho; j++) {
            for (int i = 0; i < 3; i++) {
                if (processos[3][j] != parametro) {
                    System.out.print("  " + processos[i][j] + "  ");
                }

            }
            if (processos[3][j] != parametro) {
                System.out.print(" EXECUTADO");
                System.out.print("\n");

            }

        }
    }

}
