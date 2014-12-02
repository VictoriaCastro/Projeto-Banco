import java.util.ArrayList;

public class Map_Array {

		private static ArrayList <Mapeamento> Lista;
		
		public Map_Array(){
			
			Lista = new ArrayList<Mapeamento>();
		}		
		
		public void adiciona(Mapeamento map){
			
			Lista.add(map);
		}
		
		public void imprimeLista(){
			
			for(Mapeamento map: Lista){
				System.out.println(map.getNome());
			}
		}
		
		public void desativar(String caixa){
			
			Mapeamento tmp = null;
			
			for(Mapeamento map : Lista){
				
				if(caixa.equals(map.getNome())){
					tmp = map;
					map.Saida("desativar");
				}				
			}
			Lista.remove(tmp);			
		}
		
		public void removerCaixa(String caixa){
			
			Mapeamento tmp = null;
			
			for(Mapeamento map: Lista){
				
				map.Saida("desativar");
				
				if (caixa.equals(map.getNome())){
					tmp = map;
				}				
			}			
			
			if(tmp != null){
				Lista.remove(tmp);
				System.out.println("O Caixa " + tmp.getNome() + " foi desativado!!!");
			}
			else {
				System.out.println("O caixa não foi encontrado!");
			}		
		}		
}
