package tap_2023_1.io;

import java.util.ArrayList;
import java.util.Scanner;

public class ControleDeEstoque {
	public static void main(String[] args) {
		ArrayList<Produto> produtos = ProdutosToCSV.carregar();
		Scanner teclado = new Scanner(System.in);
		
		while (true) {
			System.out.println("MENU DE OPÇÕES");
			System.out.println("1. Cadastrar produto");
			System.out.println("2. Listar produtos");
			System.out.println("3. Sair");
			System.out.println("Digite a sua opção: ");
			
			int opcao = Integer.parseInt(teclado.nextLine());
			
			if (opcao == 1) {
				System.out.println("Digite o nome do produto: ");
				String nome = teclado.nextLine();
				System.out.println("Digite o valor do produto: ");
				double valor = Double.parseDouble(teclado.nextLine());
				
				Produto novo = new Produto(nome, valor);
				produtos.add(novo);
				ProdutosToCSV.gravar(produtos);
			} else if (opcao == 2) {
				for (Produto p : produtos) {
					System.out.println(p);
				}
			} else if (opcao == 3) {
				break;
			} else {
				System.out.println("Digite uma opção válida !");
			}
		}
	}
}
