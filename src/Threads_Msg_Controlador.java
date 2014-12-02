
public class Threads_Msg_Controlador extends Thread {
	
	Mapeamento controle;
	Map_Array Lista;
	
	String msg;
	
	public Threads_Msg_Controlador(Mapeamento controle, Map_Array Lista){ // recebe mensagem do caixa
		this.Lista = Lista;
		this.controle = controle;
	}
	
	public void run(){	
		
		msg = controle.Entrada();
		
		if(msg.equals("sair")){
			System.out.println("Caixa desativado !");
			Lista.removerCaixa(controle.getNome());
		}
		else{
			System.out.println("Erro ao desativar caixa!!");
		}		
	}
}
