import java.util.Scanner;

public class main {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int  opcao;    
    
        do {
        telas.menuPrincipal();
        opcao = telas.verOpcao();

         switch (opcao) {
            case 1:
                telas.mensagem("\n Criar conta ");
                break;
            case 2:
                telas.mensagem("\n Acessando....");
                break;
            case 3:
                telas.mensagem("\n Encerrando o sistema. Até logo!");
                break;
            default:
                telas.mensagem("\n Opção inválida. Tente novamente.");
            }
        } while (opcao != 3); 
        sc.close();
    }
}