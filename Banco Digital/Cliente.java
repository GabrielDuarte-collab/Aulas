import java.time.LocalDate;
import java.time.format.*;

public class Cliente {

   private static final int IDADE_MINIMA = 16;
   private static final int ANO_MINIMO = 1900;
   private static final DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

   private String nome;
   private String cpf;
   private LocalDate dataNacimento;
   private String numeroConta;
   private String senha;
   private double saldo;
   private boolean bloqueada;
   private int tentatinvasFalhas;

   // GETTERS

   public String getNome() {
      return nome;
   }

   public String getCpf() {
      return cpf;
   }

   public String getdataNacimento() {
      return dataNacimento.format(formatador);
   }

   public String getnumeroConta() {
      return numeroConta;
   }

   public String getSenha() {
      return senha;
   }

   public double getSaldo() {
      return saldo;
   }

   public boolean isbloqueado() {
      return bloqueada;
   }

   public int getTentativasFalhas() {
      return tentatinvasFalhas;
   }

   // SETTERS

   public boolean setDataNascimento(String data) {
      if (data == null)
         return false;

      try {
         LocalDate dataNacimento = LocalDate.parse(data, formatador);
         LocalDate hoje = LocalDate.now();

         if (dataNacimento.getYear() < ANO_MINIMO)
            return false;

         LocalDate idadeMinima = hoje.minusYears(IDADE_MINIMA);
         if (dataNacimento.isAfter(idadeMinima))
            return false;

         this.dataNacimento = dataNacimento;
         return true;

      } catch (DateTimeParseException e) {
         return false;
      }
   }

   public boolean setNome(String nome) {
      if (nome == null || nome.trim().split("\\s+").length < 2) {
         return false;
      }
      this.nome = nome.trim();
      return true;
   }

   public boolean setCpf(String cpf) {
      String cpfLimpo;
      if (cpf == null)
         return false;

      cpfLimpo = cpf.replaceAll("[^0-9]", "");

      if (cpfLimpo.length() != 11)
         return false;

      if (!ValidaCPF.isCPF(cpfLimpo))
         return false;

      this.cpf = cpfLimpo;
      return true;

   }
}
