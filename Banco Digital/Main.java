import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            Telas.menuPrincipal();
            opcao = Telas.lerOpcao();

            switch (opcao) {
                case 1:
                    Controlador.criarConta();
                    break;
                case 2:
                    Telas.mensagem("\n Acessando....");
                    break;
                case 3:
                    Telas.mensagem("\n Encerrando o sistema. Até logo!");
                    break;
                default:
                    Telas.mensagem("\n Opção inválida. Tente novamente.");
            }
        } while (opcao != 3);
        sc.close();
    }
}