import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Controlador {
	public static void main (String[] args) throws IOException{
	
		ServerSocket controlador = new ServerSocket(12346);
		System.out.println("A porta 12346");
		Map_Array lista = new Map_Array();
		
		Threads_Controlador threads_menu = new Threads_Controlador(lista); 
		threads_menu.start(); //inicia a thread do menu
		
		int i =1;
		
		while(true){
			
			Socket clienteControlador = controlador.accept();
			Mapeamento map = new Mapeamento(clienteControlador);
			map.setNome("caixa" + i); //
			lista.adiciona(map); // chama metodo para adicinar caixa na lista
			
			Threads_Msg_Controlador msg_control = new Threads_Msg_Controlador(map, lista);			
			msg_control.start();
			i++;
		}
	}
}
