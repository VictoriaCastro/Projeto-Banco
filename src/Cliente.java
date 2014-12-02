
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
		
	private static Scanner s;

	public static void main(String[] args) throws UnknownHostException, IOException {
			
		final String LOGIN = "0";
		final String DEPOSITO = "1";
		final String SAQUE = "2";
		final String EXTRATO = "3";
		final String SALDO = "4";
		final String SAIR = "5";
		final String HELP = "6";
		
		String conta;
		String senha;
		String login = "False";
		String opcao;
		String T = "-";
		String valor;
		
		Socket cliente = new Socket("127.0.0.1", 12345);
		System.out.println("O cliente se conectou ao servidor!");
		
		Socket clienteControlador = new Socket("127.0.0.1", 12346);
		System.out.println("O cliente se conectou ao controlador!");
		
		Mapeamento conexao = new Mapeamento(cliente);
		Mapeamento controle = new Mapeamento(clienteControlador);	
		
		Scanner teclado = new Scanner(System.in);
		
		Threads_Msg_Caixa msg_caixa = new Threads_Msg_Caixa(controle);
		msg_caixa.start();
		

		while (true){
			
			
			do{
				System.out.println("Informar conta:");
				conta = teclado.nextLine();
				
				System.out.println("Informar senha:");
				senha = teclado.nextLine();	
				
				conexao.Saida(LOGIN + T + conta + T + senha);
				
				login = conexao.Entrada();
				
				if(login.equals("False")){
					System.out.println("Conta ou senha incorreta");
				}
				
			}while(login.equals("False"));
			
			if(login.equals("True")){
				
				while(conta != null){				
					
					System.out.println(" - MENU - ");	
					
					System.out.println("1 - Deposito");
				    System.out.println("2 - Saque");				
					System.out.println("3 - Extrato");
					System.out.println("4 - Saldo");
					System.out.println("5 - Sair");
					System.out.println("6 - Help");
					
					System.out.println("Informe uma opção:");
					opcao = teclado.nextLine();
					
					switch(opcao){
					
				        case DEPOSITO: 
				        	System.out.println("Digite o numero da conta:");
				        	String conta2 = teclado.nextLine();
				        	
				        	System.out.println("Digite o valor a ser depositado:");
				        	valor = teclado.nextLine();
				        	
				        	conexao.Saida(DEPOSITO + T + conta2 + T + valor);
				        	String retorno = conexao.Entrada();	
				        	
				        	System.out.println(retorno);
				        break;
				        
				        case SAQUE: 
				        	
				        	System.out.println("Digite o valor a ser sacado:");
				        	valor = teclado.nextLine();
				        	
				        	conexao.Saida(SAQUE + T + conta + T + valor);
				        	retorno = conexao.Entrada();
				        	System.out.println(retorno);			            
				        break;
				        
				        case EXTRATO:
				        	conexao.Saida(EXTRATO + T + conta);
	
				        	retorno = conexao.Entrada();
				        	retorno = retorno.replaceAll("-", "\n");
				        	System.out.println(retorno);			        				        				            
				        break;
				        
				        case SALDO: 			        	
				        	conexao.Saida(SALDO + T + conta);
				        	retorno = conexao.Entrada();
				        	
				        	System.out.println("Saldo atual: ");
				        	System.out.println(retorno);			        				            
				        break;
				        
				        case SAIR:
				        	controle.Saida("sair");	
				        	conta = null;
				        	valor = null;
				        	opcao = null;				        	
				        	System.exit(0);
				        break;
				        
				        case HELP: 				        	
				        	conexao.Saida(HELP);			        				            
				        break;
					}														
				}
			}			
		}				
	}	
}