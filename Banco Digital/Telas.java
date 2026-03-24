import java.util.Scanner;

public class Telas {

    static Scanner sc = new Scanner(System.in);

    private static void limpaTela() {
        for (int i = 0; i < 50; i++)
            System.out.println();
    }

    public static void menuPrincipal() {
        limpaTela();
        System.out.println("===============");
        System.out.println("  -BANCO POO-  ");
        System.out.println("===============");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Acessar conta");
        System.out.println("3 - Encerrar");
        System.out.print("Escolha: ");

    }

    public static void menuConta(String nomeCliente, double saldo) {
        limpaTela();
        System.out.println("\n ====================");
        System.out.println("Bem vindo, " + nomeCliente);
        System.out.printf("saldo: R$ %.2f%n", saldo);
        System.out.println("====================");
        System.out.println("1. Depositar");
        System.out.println("2. Sacar");
        System.out.println("3. Ver extrato");
        System.out.println("5. Sair");
        System.out.println("Opção selecionada");
    }

    public static void cabecalhoCadastro() {
        limpaTela();
        System.out.println("\n======== Cadastro ========");
    }
    public static void cabecalhoLogin() {
        limpaTela();
        System.out.println("\n======== Login ========");
    }

    public static int lerOpcao() {
        return Integer.parseInt(sc.nextLine().trim());
    }
    public static String lerTexto() {
        
    }

    public static void mensagem(String texto) {
        limpaTela();
        System.out.println(texto);
        System.out.println("Pressione a teclar ENTER");
        sc.nextLine();
    }
}