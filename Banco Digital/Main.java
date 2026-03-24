import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        Cliente c = new Cliente();

        do {
                  // telas.menuPrincipal();
            opcao = Telas.lerOpcao();

            switch (opcao) {
                case 1:
                  Controlador.criarConta();
                  // telas.mensagem("\n Criar conta ");
                  //  System.out.println("Digite seu nome: ");
                  //  String nome = sc.nextLine();
                  //  c.setNome(nome);
                  //  telas.mensagem("Conta criada para: " + c.getNome());
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