import java.util.Scanner;

public class main {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int  opcao;    
    
        do {
        telas.menuPrincipal();
        opcao = Integer.parseInt(sc.nextLine().trim());

         switch (opcao) {
            case 1:
                telas.mensagem("Opção 1 selecionada : Criar conta (em breve)");
                break;
            case 2:
                telas.mensagem("Opção 2 selecionada : Acessar conta (em breve)");
                break;
            case 3:
                telas.mensagem("Encerrando o sistema. Até logo!");
                break;
            default:
                telas.mensagem("Opção inválida. Tente novamente.");
            }
        } while (opcao != 3); 
        sc.close();
    }
}