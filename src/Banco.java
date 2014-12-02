import java.util.ArrayList;

public class Banco {
	
	private static ArrayList<Conta> Lista;
		
	public Banco(){
		
		Lista = new ArrayList<Conta>();
		Conta c1 = new Conta("1", "12", 0.00);
		Conta c2 = new Conta("2", "21", 0.00);
		
		Lista.add(c1);
		Lista.add(c2);
	}
	
	public Conta buscar_conta(String n_Conta){
		
		 for(Conta conta : Lista){
			 
			 if(n_Conta.equals(conta.conta())){
				 return conta;
			 }
		 }		 
		 return null;
	}
	
	public String efetuar_login(String n_Conta, String senha){
		
		Conta tmp = buscar_conta(n_Conta);
		
		if(verifica_retorno(tmp)){
			return tmp.login(senha);
		}
		return "False";
	}
	
	public String efetuar_deposito(String n_Conta, double valor){
		Conta tmp = buscar_conta(n_Conta);
			
		if(verifica_retorno(tmp)){
			return tmp.deposito(valor);
		}
		return "False";		
	}
	
	public String saque(String n_Conta, double valor){
		
		Conta tmp = buscar_conta(n_Conta);
				
		if(verifica_retorno(tmp)){
			return tmp.saque(valor);
		}
		return "False";	
	}
	
	public String saldo (String n_Conta){
		
		Conta tmp = buscar_conta(n_Conta);
		
		if(verifica_retorno(tmp)){
			return String.valueOf(tmp.saldo());	
		}
		return "False";			
	}
	
	public String extrato(String n_Conta){
		Conta tmp = buscar_conta(n_Conta);
		
		if(verifica_retorno(tmp)){
			return tmp.extrato() + "-" + tmp.saldo();
		}
		return "False";	
	}
	
	public boolean verifica_retorno(Conta tmp){
		
		if(tmp == null){
			return false;			
		}
		return true;		
	}
}
