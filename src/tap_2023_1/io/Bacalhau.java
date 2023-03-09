package tap_2023_1.io;

public class Bacalhau {
	private String[] tabela = new String[97];
	
	public void adicionar(String nome) {
		int indice = Math.abs(nome.hashCode()) % tabela.length;
		tabela[indice] = nome;
	}
	
	public boolean contem(String nome) {
		int indice = Math.abs(nome.hashCode()) % tabela.length;
		return tabela[indice] != null;
	}
	
	public static void main(String[] args) {
		Bacalhau b = new Bacalhau();
		b.adicionar("banana");
		System.out.println(b.contem("banana"));
		System.out.println(b.contem("maçã"));
	}
}
