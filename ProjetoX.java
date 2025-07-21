import java.util.Scanner;

public class ProjetoX {
    public static void main(String[] args) {
        char[][] tabuleiro = new char[3][3];
        char jogadorAtual = 'X';
        boolean jogoRodando = true;
        Scanner scanner = new Scanner(System.in);

        // Inicializa o tabuleiro
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
        while (jogoRodando) {
            // Imprimir o tabuleiro
            System.out.println("-------------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(tabuleiro[i][j] + " | ");
                }
                System.out.println("\n-------------");
            }

            // Jogada do jogador
            System.out.println("Jogador " + jogadorAtual + ", digite linha (0-2) e coluna (0-2): ");
            int linha = scanner.nextInt();
            int coluna = scanner.nextInt();

            if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
                System.out.println("Posição inválida.");

            }

            if (tabuleiro[linha][coluna] != ' ') {
                System.out.println("Posição já ocupada.");
                continue;
            }

            tabuleiro[linha][coluna] = jogadorAtual;

            // Verificar vitória
            boolean venceu = false;
            for (int i = 0; i < 3; i++) {
                if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual)
                    venceu = true;
                if (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual)
                    venceu = true;
            }
            if (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual)
                venceu = true;
            if (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual)
                venceu = true;

            if (venceu) {
                System.out.println("Jogador " + jogadorAtual + " venceu!");
                break;
            }

            // Verificar empate
            boolean empate = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tabuleiro[i][j] == ' ') {
                        empate = false;
                        break;
                    }
                }
            }
            if (empate) {
                System.out.println("Empate!");
                break;
            }

            // Trocar jogador
            jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
        }

        // Mostrar tabuleiro final
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
        scanner.close();
    }
}
