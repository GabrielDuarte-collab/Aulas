import java.util.Scanner;

public class telas {

    static Scanner sc = new Scanner(System.in);
    
    private static void limpaTela(){
      for (int i = 0 ; i < 50 ; i++) 
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

    public static int verOpcao() {
        return Integer.parseInt(sc.nextLine().trim());
    }

    public static void mensagem(String texto) {
        System.out.println(texto);
        System.out.println();
    }
}