import java.util.Scanner;

public class Controlador {

    private static final Scanner sc = new Scanner(System.in);

    public static void criarConta() {
        Telas.cabecalhoCadastro();
        Cliente cliente = new Cliente();

        String nomeInformado;
        do {
            Telas.limpaTela();
            nomeInformado = Telas.lerTexto("Digite seu nome1");
            if (!cliente.setNome(nomeInformado)) {
                Telas.mensagem("Inválido.");
            }
        } while (!cliente.setNome(nomeInformado));

        String cpfInformado;
        do {
            Telas.limpaTela();
            cpfInformado = Telas.lerTexto("Digite seu CPF");
            if (!cliente.setCpf(cpfInformado)) {
                Telas.mensagem("CPF inválido");
            }
        } while (!cliente.setCpf(cpfInformado));

        String dataNacimento;
        do {
            Telas.limpaTela();
            dataNacimento = Telas.lerTexto("Digite sua data de nacimento");
            if (!cliente.setDataNascimento(dataNacimento)) {
                Telas.mensagem("Iválido.");
            }
        } while (!cliente.setDataNascimento(dataNacimento));
    } 
}