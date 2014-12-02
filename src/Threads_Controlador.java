import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Threads_Controlador extends Thread {
	
	Map_Array Lista;
	Mapeamento controle;
	
	public Threads_Controlador(Map_Array Lista){
		this.Lista = Lista;	
	}
	
	public void run() {
		
		while(true){
			
			System.out.println(" - MENU - ");	
			System.out.println("1 - Listar Caixas");
		    System.out.println("2 - Desativar Caixa");
		    System.out.println(" Digite a opção escolhida: ");	
			
			Scanner teclado = new Scanner(System.in);
			String opcao = teclado.nextLine();
			
			
			switch(opcao){
				
				case "1": 
					System.out.println(" ** Os caixas abertos são: **");
					Lista.imprimeLista();
				break;
				
				case "2":
					System.out.println(" - Digite o nome do caixa a ser desativado: ");
					String nome = teclado.nextLine();
					Lista.desativar(nome);					
				break;
			}
		}		
	}	
}
