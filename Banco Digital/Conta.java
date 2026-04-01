
public class Conta {
    private double saldo;
    private String numeroConta;

    public double getSaldo() {
        return this.saldo;

    }

    public String getnumeroConta() {
        return this.numeroConta;
    }

    public boolean Depositar(double valor) {
        if (valor <= 0) {
            return false;
        }
        this.saldo += valor;
        return true;
    }

    public boolean sacar(double valor) {
        if (valor <= 0 || valor > this.saldo) {
            return false;
        }
        this.saldo -= valor;
        return true;
    }

    public String descricao() {
        return "Conta";
    }

}
