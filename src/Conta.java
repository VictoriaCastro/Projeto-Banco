import java.text.SimpleDateFormat;
import java.util.Date;

 class Conta{
	
	 private String conta;
	 private String senha;
	 private double saldo;
	 private String extrato;
	 
	 public Conta(String conta, String senha, double saldo){
		 
		 this.conta = conta;
		 this.senha = senha;
		 this.saldo = saldo;
		 this.extrato = "**    "+ conta + "   **" + "-";		 
	 }
	 
	 public String data(){
		 SimpleDateFormat data = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
		 return data.format(new Date());
	 }
	 
	 public double saldo (){
		 return saldo;
	 }
	 
	 public String extrato(){
		 return extrato;
	 }
	 
	 public String login (String senha){
		 
		 if(this.senha.equals(senha)){
			 return "True";
		 }
		 return "False";
	 }	
	 
	 public String conta(){
		 return conta;
	 }
	 
	 public String deposito(double valor){
		 
		 this.saldo = saldo + valor;
		 System.out.println(saldo);
		 extrato += "-" + data() + "  Deposito  " + valor;
		 return "Deposito Efetuado com Sucesso!";
	 }
	 
	 public String saque(double valor){
		 
		 if(this.saldo >= valor){
			 this.saldo = saldo - valor;
			 System.out.println(saldo);
			 extrato += "-" + data() + "  Saque  " + valor;
			 return "Saque Efetuado com Sucesso!";			 
		 }		 
		 return "Saldo Insuficiente para Saque!";		 
	 }
	 
}