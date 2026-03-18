public class Cliente {
   private String nome;
   private String cpf;
   private String dataNacimento;
   private String numeroConta;
   private String senha;
   private double saldo;
   private boolean bloqueada;
   private int tentatinvas;
      
   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      if (nome.toUpperCase().trim().isEmpty()) {
         System.out.println("Inválido!");
      } else if  
         (!nome.matches("[a-zA-Za-s]")){
         System.out.println("Apenas letras!");
      } else {
         this.nome = nome;
      }
   }

}