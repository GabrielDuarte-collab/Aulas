public class Cliente {
   private String nome;
   private String cpf;
   private String dataNacimento;
   private String numeroConta;
   private String senha;
   private double saldo;
   private boolean bloqueada;
   private int tentatinvas;

   //GETTERS

   public String getNome() {
      return nome;
   }

   public String getCpf() {
      return cpf;
   }

   public String getdataNacimento() {
      return dataNacimento;
   }

   //SETTERS

   public boolean setNome(String nome) {
      if (nome == null || nome.trim().split("\\s+").length < 2) {
         return false;
      }
      this.nome = nome.trim();
      return true;
   }

}