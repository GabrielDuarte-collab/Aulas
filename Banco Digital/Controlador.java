import java.util.Scanner;

public class Controlador {
    private static final Scanner sc = new Scanner(System.in);

    static void criarConta() {
        Cliente c = new Cliente();
        Telas.menuPrincipal();
        Telas.mensagem("Digite seu nome: ");
        String nome = sc.nextLine();
        c.setNome(nome);
        Telas.mensagem("Conta criada para: " + c.getNome());

    }
}
