public class Conta {
  private double saldo;
  private Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.saldo = 0;
    }

    void Depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }
    public boolean sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
            return false;
        }
    }

}
