import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class Cliente {

    private static final int IDADE_MINIMA = 16;
    private static final int ANO_MINIMO = 1900;
    private static final DateTimeFormatter formatador = DateTimeFormatter
    .ofPattern("dd/MM/uuuu")
    .withResolverStyle(ResolverStyle.STRICT);

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String numeroConta;
    private String senha;
    /*
     * Composição: Cliente TEM UMA Conta (introduzida na Aula 04).
     * O objeto é ContaCorrente, mas a variável é do tipo Conta.
     */
    private Conta conta = new ContaCorrente();
    /*
     * Composição: Cliente TEM UM Historico (Aula 05).
     * O histórico vive dentro do cliente e registra cada operação.
     */
    private Historico historico = new Historico();
    private boolean bloqueada;
    private int tentativasFalhas;

    // GETTERS

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento.format(formatador);
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    /* Delega para Conta: o saldo mora em Conta, não mais diretamente em Cliente. */
    public double getSaldo() {
        return conta.getSaldo();
    }

    public Conta getConta() {
        return conta;
    }

    public Historico getHistorico() {
        return historico;
    }

    public boolean isBloqueada() {
        return bloqueada;
    }

    public int getTentativasFalhas() {
        return tentativasFalhas;
    }

    // SETTERS

    public boolean setNome(String nome) {
        if (nome == null || nome.trim().split("\\s+").length < 2) {
            return false;
        }
        this.nome = nome.trim();
        return true;
    }

    public boolean setCpf(String cpf) {
        if (cpf == null) {
            return false;
        }
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");
        if (!ValidaCPF.isCPF(cpfLimpo)) {
            return false;
        }
        this.cpf = cpfLimpo;
        return true;
    }

    public boolean setDataNascimento(String data) {
        if (data == null)
            return false;
        try {
            LocalDate dataNascimento = LocalDate.parse(data, formatador);
            LocalDate hoje = LocalDate.now();

            if (dataNascimento.getYear() < ANO_MINIMO)
                return false;

            LocalDate idadeMinima = hoje.minusYears(IDADE_MINIMA);
            if (dataNascimento.isAfter(idadeMinima))
                return false;

            this.dataNascimento = dataNascimento;
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public boolean setSenha(String senha) {
        if (senha == null || !senha.matches("\\d{4}")) {
            return false;
        }
        this.senha = senha;
        return true;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setSaldo(double saldo) {
        conta.setSaldo(saldo);
    }

   
    public void setBloqueada(boolean bloqueada) {
        this.bloqueada = bloqueada;
    }

   
   
    public void registrarTentativaFalha() {
        this.tentativasFalhas++;
        if (this.tentativasFalhas >= 3) {
            this.bloqueada = true;
        }
    }

    public void resetarTentativasFalhas() {
        this.tentativasFalhas = 0;
    }

    
    public boolean verificarSenha(String senhaInformada) {
        return this.senha != null && this.senha.equals(senhaInformada);
    }
}
