package tap_2023_1.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class EncontrarEmArquivos {
	private static ExecutorService threadPool = Executors.newFixedThreadPool(4);
	
	public static void procurarNoArquivo(File arquivo, String texto) throws FileNotFoundException {
		Scanner leitor = new Scanner(arquivo);
		
		int numeroDaLinha = 1;
		while (leitor.hasNextLine()) {
			String linha = leitor.nextLine();
			if (linha.contains(texto)) {
				System.out.println(arquivo.getName() + " (#" + numeroDaLinha + "): " + linha);
			}
			numeroDaLinha++;
		}
		leitor.close();
	}
	
	public static void procurarEmArquivos(File raiz, String texto) {
		threadPool.submit(() -> {
			for (File f : raiz.listFiles()) {
				if (f.isFile()) {
					try {
						procurarNoArquivo(f, texto);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				} else if (f.isDirectory()) {
					procurarEmArquivos(f, texto);
				}
			}
		});
	}
	
	private static void encerra() {
		try {
			Thread.sleep(500);
		} catch (Exception ex) {
		}
		
		threadPool.shutdown();
		
		try {
			threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		} catch (InterruptedException e) {
		}
	}
	
	public static void main(String[] args) throws Exception {
		procurarEmArquivos(
				new File("/home/bruno/eclipse-workspace/tap_2023_1"), 
				"Teclado");
		encerra();
	}
}
