public class Controlador {

    public static final CentralBancaria central = new CentralBancaria();

    public static void criarConta() {
        Telas.cabecalhoCadastro();
        Cliente cliente = new Cliente();

        String nomeInformado;
        do {
            Telas.limparTela();
            nomeInformado = Telas.lerTexto("Digite o nome completo");
            if (!cliente.setNome(nomeInformado)) {
                Telas.mensagem("Nome inválido!", true);
            }
        } while (!cliente.setNome(nomeInformado));

        String cpfInformado;
        do {
            Telas.limparTela();
            cpfInformado = Telas.lerTexto("Digite o CPF: ");
            if (!cliente.setCpf(cpfInformado)) {
                Telas.mensagem("CPF inválido.", true);
            }
        } while (!cliente.setCpf(cpfInformado));

        String data;
        do {
            Telas.limparTela();
            data = Telas.lerTexto("Data de nascimento (dd/mm/aaaa)");
            if (!cliente.setDataNascimento(data)) {
                Telas.mensagem("Data de nascimento inválida.", true);
            }
        } while (!cliente.setDataNascimento(data));

        System.out.println("Enviando dados para central...");
        String resultado = central.cadastrar(cliente.getNome(),
                cliente.getCpf(), cliente.getDataNascimento());

        if (resultado.startsWith("ERRO")) {
            Telas.mensagem(resultado, true);
            return;
        }

        String numeroConta = resultado;

        Telas.limparTela();
        System.out.println("Conta criada com sucesso!");
        System.out.println("numero da conta: " + numeroConta);
        Telas.separador();

        String senha;
        String confirma;

        do {
            senha = Telas.lerTexto("Crie sua senha (4 dígitos)");
            confirma = Telas.lerTexto("Confirme sua senha");

            if (!senha.equals(confirma)) {
                Telas.mensagem("Senhas não conferem", true);

            } else if (!senha.matches("\\d{4}")) {
                Telas.mensagem("Senha inválida.Use exatamente 4 digitos numericos!", true);
            }
        } while (!senha.equals(confirma) || !senha.matches("\\d(4))"));

        central.cadastrarSenha(numeroConta, senha);
        Telas.mensagem("Cadastro concluido: Numero conta: " + numeroConta, false);
    }

    public static void acessarConta() {
        Telas.cabecalhoLogin();

        String numeroConta = Telas.lerTexto("Numero da conta");
        int tentativas = 0;
        while (tentativas < 3) {
            String senha = Telas.lerTexto("Senha");
            Cliente cliente = new Cliente();
            String status = central.login(numeroConta, senha, cliente);

            switch (status) {

                case "OK":
                    menuConta(cliente);
                case "CONTA_INEXISTENTE":
                    Telas.mensagem("Conta inexistente. Verifique o numero e tentativas novamente.", true);
                    return;
                case "BLOQUEADA":
                    Telas.mensagem("Conta bloqueada devido a multiplas tentativas de login falhadas.", true);
                    return;
                case "SENHA_INCORRETA":
                    tentativas++;
                    if (tentativas < 3) {
                        Telas.mensagem("Senha incorreta. Tentativa" + tentativas + "", false);
                    }
                    break;
                default:
                    Telas.mensagem("Erro de comunicação. tente novamente mais tarde!", false);
            }
        }

    }

    private static void menuConta(Cliente cliente) {
        int opcao;
        do {
            Telas.menuConta(cliente.getNome(), cliente.getSaldo());
            opcao = Telas.lerOpcao();
            switch (opcao) {
                case 1:
                    Telas.mensagem("O deposito ", false);
                    break;
                case 2:
                    Telas.mensagem("Sacar", false);
                    break;
                case 3:
                    Telas.mensagem("Tranferencia", false);
                    break;
                case 4:
                    Telas.mensagem("Extrato", false);
                    break;
                case 5:
                    Telas.mensagem("Áte logo, " + cliente.getNome() + "!", false);
                    break;
                default:
                    Telas.mensagem("Opção inválida.", true);
            }
        } while (opcao != 5);

    }
}
