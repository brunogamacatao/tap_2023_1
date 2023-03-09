package tap_2023_1.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

// MOCK
public class SerializadorDeProdutos {
	public static void gravar(ArrayList<Produto> produtos) {
		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(
					new File("produtos.txt")));
			oos.writeObject(produtos);
			oos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Produto> carregar() {
		try {
			
			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream(
					new File("produtos.txt")));
			ArrayList<Produto> produtos = (ArrayList<Produto>)ois.readObject();
			ois.close();
			return produtos;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return new ArrayList<Produto>();
	}
}
