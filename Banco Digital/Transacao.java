import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Transacao {

    private static final DateTimeFormatter FORMATADOR =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String tipo;
    private double valor;
    private LocalDate data;

    public Transacao(String tipo, double valor, LocalDate data) {
        this.tipo  = tipo;
        this.valor = valor;
        this.data  = data;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    @Override
    public String toString() {
        return String.format("%-22s  R$ %10.2f   %s",
                tipo, valor, data.format(FORMATADOR));
    }
}
