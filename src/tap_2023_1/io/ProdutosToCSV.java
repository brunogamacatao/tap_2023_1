package tap_2023_1.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Scanner;

public class ProdutosToCSV {
	public static void gravar(ArrayList<Produto> produtos) {
		try {
			PrintWriter out = new PrintWriter("produtos.csv");
			for (Produto p : produtos) {
				out.println(produtoToCSV(p));
			}
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Produto> carregar() {
		ArrayList<Produto> produtos = new ArrayList<>();
		
		try {
			Scanner in = new Scanner(new File("produtos.csv"));
			while (in.hasNextLine()) {
				produtos.add(csvToProduto(in.nextLine()));
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return produtos;
	}
	
	private static String produtoToCSV(Produto p) {
		return p.getNome() + ";" + p.getValor();
	}
	
	private static Produto csvToProduto(String csv) {
		String[] campos = csv.split(";");
		String nome = campos[0];
		double valor = Double.parseDouble(campos[1]);
		return new Produto(nome, valor);
	}
	
	public static void main(String[] args) throws Exception {
		Produto p = new Produto("Bla", 3.14);
		
		for (Field f : Produto.class.getDeclaredFields()) {
			if (f.getName().equals("serialVersionUID")) {
				continue;
			}
			
			f.setAccessible(true);
			
			System.out.println(f.getName() + " = " + f.get(p));
		}
	}
}
