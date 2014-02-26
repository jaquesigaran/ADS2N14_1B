
public class Pessoa {

	private String nome;
	private int matricula;
	
	public Pessoa (String nome){
		this.nome = nome;
		this.matricula = -1;
		}
	public String getNome(){
			
	return nome;
	
} 
	
	public static void main(String[] args) {
		 
		Pessoa p= new Pessoa (args[0]);
		
		System.out.println(p.getNome());
	}
	
	
}
