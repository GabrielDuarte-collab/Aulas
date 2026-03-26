import java.util.Scanner;

public class Controlador {

    private static final Scanner sc = new Scanner(System.in);

    public static void criarConta() {
        Telas.cabecalhoCadastro();
        Cliente cliente = new Cliente();

        String nome = Telas.lerTexto("Digite seu nome");
        if (!cliente.setNome(nome)) {
            Telas.mensagem("Digite seu nome completo");
            return;
        }
        String cpf = Telas.lerTexto("Digite seu CPF");
        if (!cliente.setCpf(cpf)) {
            Telas.mensagem("CPF inválido");
            return;
        }
        String dataNacimento = Telas.lerTexto("Digite sua data de nacimento dd/MM/yyyy");
        if (!cliente.setDataNascimento(dataNacimento)) {
            System.out.println("Digite sua data de nacimento correta!");
            return;
         }
    
    }

}
