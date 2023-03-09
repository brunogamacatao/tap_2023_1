package tap_2023_1.io;

import java.io.Serializable;
import java.text.NumberFormat;

public class Produto implements Serializable {
	private static final long serialVersionUID = 6348954239070262693L;

	private String nome;
	private double valor;
	
	public Produto() {
	}
	
	public Produto(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		return nome + ", " + fmt.format(valor);
	}
}
