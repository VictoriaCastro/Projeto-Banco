import java.net.Socket;

public class Threads_Msg_Caixa extends Thread{
	
	String msg;
	Mapeamento controle;
		
	public Threads_Msg_Caixa(Mapeamento controle){ // recebe mensagem do controlador		
		this.controle = controle;
	}	
	
	public void run(){
		while(true){
			try {
				msg = controle.Entrada();
				System.out.println("Caixa desativado!");
				System.exit(0);
			} catch (Exception e) {
				
			}
		}
		
//		msg = controle.Entrada();
//		
//		//if(msg.equals("desativar")){
//			System.out.println("Caixa desativado!");
//			System.exit(0);
	//	}
		//else{
		//	System.out.println("Erro ao desativar caixa!");
	//	}		
	}		
}
