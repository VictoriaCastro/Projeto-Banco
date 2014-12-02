import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Mapeamento {

	private Socket conexao;
	private PrintStream saida;
	private Scanner entrada;
	private String nome;
		
	public Mapeamento(Socket conexao){
		this.conexao = conexao;
			
		try {
			saida = new PrintStream(conexao.getOutputStream());
			entrada = new Scanner(conexao.getInputStream());
			
		} catch (IOException e) {
			e.printStackTrace();
		}			
	}
		
	public void Saida (String mensagem){
		saida.println(mensagem);
	}
		
	public String Entrada(){
		return entrada.nextLine();						
	}	
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
}
