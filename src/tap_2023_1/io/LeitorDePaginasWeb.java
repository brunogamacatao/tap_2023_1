package tap_2023_1.io;

import java.net.URL;
import java.util.Scanner;

public class LeitorDePaginasWeb {
	public static String lePagina(String url) {
		try {
			URL u = new URL("https://pt.wikipedia.org/wiki/Campina_Grande");
			Scanner leitor = new Scanner(u.openStream());
			
			StringBuilder pagina = new StringBuilder();
			
			while (leitor.hasNextLine()) {
				pagina.append(leitor.nextLine());
			}
			
			leitor.close();
		
			return pagina.toString();
		} catch (Exception ex) {
			System.err.println(ex);
		}
		return "";
	}
	
	public static void main(String[] args) throws Exception {
		String pagina = lePagina("https://pt.wikipedia.org/wiki/Campina_Grande");
		System.out.println(pagina);
	}
}
