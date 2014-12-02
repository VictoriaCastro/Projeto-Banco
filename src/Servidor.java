
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) throws IOException {
	
		ServerSocket servidor = new ServerSocket(12345);
		System.out.println("Porta 12345 aberta!");
		
		int i = 1;
		
		while (true) {
			Socket cliente = servidor.accept();
			
			Threads threads = new Threads(cliente, "Cliente " + i);
			threads.start();
			i++;
		}		
	}	
}