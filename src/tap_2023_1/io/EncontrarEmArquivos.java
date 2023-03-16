package tap_2023_1.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class EncontrarEmArquivos {
	private static Map<String, Set<String>> indice = new HashMap<>();
	private static Set<String> STOP_WORDS = new HashSet<>(Arrays.asList(new String[]{"A", "O", "E", "AS", "OS", "UM", "UMA", "UNS", "UMAS"}));
	
	private static String getConteudoArquivo(File arquivo) throws FileNotFoundException {
		Scanner leitor = new Scanner(arquivo);
		
		StringBuilder builder = new StringBuilder();
		
		while (leitor.hasNextLine()) {
			String linha = leitor.nextLine();
			builder.append(linha + "\n");
		}
		
		leitor.close();
		
		return builder.toString();
	}
	
	public static boolean isStopWord(String palavra) {
		if (palavra.length() <= 2) {
			return true;
		}
		
		return STOP_WORDS.contains(palavra);
	}
	
	public static String palavraToChave(String palavra) {
		return palavra.toUpperCase();
	}
	
	public static void indexarArquivo(File arquivo) throws FileNotFoundException {
		String conteudo = getConteudoArquivo(arquivo);
		String[] palavras = conteudo.split("\\s+");
		
		Arrays.stream(palavras)
		.map((p) -> palavraToChave(p))
		.filter((p) -> !isStopWord(p))
		.forEach((palavra) -> {		
			palavra = palavraToChave(palavra);
			
			Set<String> indicePorPalavra = null;
			
			if (indice.containsKey(palavra)) {
				// se já tem um índice para essa palavra
				// vou adicionar o arquivo novo nesse índice
				indicePorPalavra = indice.get(palavra);
			} else {
				// se ainda não tem nenhum índice para essa palavra
				// vou criar um novo
				indicePorPalavra = new HashSet<>();
				indice.put(palavra, indicePorPalavra);
			}
			
			indicePorPalavra.add(arquivo.getAbsolutePath());
		});
	}
	
	public static Set<String> buscar(String palavra) {
		String chave = palavraToChave(palavra);
		return indice.get(chave);
	}
	
	public static void indexarPasta(File raiz) {
		for (File f : raiz.listFiles()) {
			if (f.isFile()) {
				try {
					indexarArquivo(f);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} else if (f.isDirectory()) {
				indexarPasta(f);
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		System.out.println("Indexando ...");
		indexarPasta(new File("/home/bruno/eclipse-workspace/tap_2023_1"));
		System.out.println("Pronto !");
		
		Scanner teclado = new Scanner(System.in);
		
		while (true) {
			System.out.print("Digite sua busca (ou SAIR para sair): ");
			String busca = teclado.nextLine();
			if (busca.equals("SAIR")) break;
			Set<String> resultado = buscar(busca);
			
			if (resultado == null || resultado.size() == 0) {
				System.out.println("Não foram encontrados resultados");
			} else {
				System.out.println(resultado.size() + " resultados: ");
				for (String arquivo : resultado) {
					System.out.println(arquivo);
				}
			}
		}
		
		teclado.close();
	}
}
