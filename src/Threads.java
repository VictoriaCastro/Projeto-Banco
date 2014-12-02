import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Threads extends Thread{
	
	final String LOGIN = "0";
	final String DEPOSITO = "1";
	final String SAQUE = "2";
	final String EXTRATO = "3";
	final String SALDO = "4";
	final String SAIR = "5";
	final String HELP = "6";
	
	private Socket cliente;
	private String nome;
	private int contador = 0;
	
	Mapeamento conexao;
	Banco banco;

	public Threads(Socket cliente, String nome) {
		this.cliente = cliente;
		this.nome = nome;
		
		conexao = new Mapeamento(cliente);
		banco = new Banco();
	}
		
	public void run(){
		
		System.out.println("Nova conexão com o cliente " + this.nome + " " + cliente.getInetAddress().getHostAddress());
		
		while (true){
			
			String login = conexao.Entrada();
			String[] mensagem = login.split("-");		
			String opcao = mensagem[0];
            float valor = 0;
                        
	        switch(opcao){
		        case LOGIN:
		        	String conta = mensagem[1];
		            String senha = mensagem[2];
		            
		            String ret = banco.efetuar_login(conta, senha);
		            conexao.Saida(ret);
		        break;
		       
		        case DEPOSITO:	        	
		        	conta = mensagem[1];
		        	valor = Float.parseFloat(mensagem[2]);
		        	
		        	ret = banco.efetuar_deposito(conta, valor);
		        	conexao.Saida(ret);
		        	
		        break;
		        
		        case SAQUE:		        	
		        	conta = mensagem[1];
		        	valor = Float.parseFloat(mensagem[2]);
		        	
		        	ret = banco.saque(conta, valor);		        	
		        	conexao.Saida(ret);		
		        break;
		        
		        case EXTRATO: 
		        	System.out.println("Extrato");
		        	
		        	conta = mensagem[1];
		        	ret = banco.extrato(conta);
		        	conexao.Saida(ret);		        	
		        break;
		        
		        case SALDO:
		        	System.out.println("SALDO");
		        	
		        	conta = mensagem[1];
		        	ret = banco.saldo(conta);
		        	conexao.Saida(ret);		        	
		        break;
		        
		        case SAIR:
		        	
		        break;
		        
		        case HELP:
		        	
		        break;
		    }
		}                      
	}
}


