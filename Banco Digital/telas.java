import java.util.Scanner;

public class telas {

    static Scanner sc = new Scanner(System.in);

    // Exibe o menu principal
    public static void menuPrincipal() {
        System.out.println("===== MENU =====");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Acessar conta");
        System.out.println("3 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    // Captura a opção do usuário
    public static int lerOpcao() {
        return Integer.parseInt(sc.nextLine().trim());
    }

    // Exibe mensagens padrão
    public static void mensagem(String texto) {
        System.out.println(texto);
        System.out.println();
    }
}