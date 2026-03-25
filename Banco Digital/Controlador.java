import java.util.Scanner;

public class Controlador {
    private static final Scanner sc = new Scanner(System.in);

    static void criarConta() {
        Telas.cabecalhoCadastro();
        Cliente c = new Cliente();
        Telas.mensagem("Digite seu nome: ");
        String nome = sc.nextLine();
        c.setNome(nome);
        Telas.mensagem("Conta criada para: " + c.getNome());

    }
}
