package tap_2023_1.regex;

import java.util.Scanner;

enum TipoChavePix {
	CPF, CNPJ, TELEFONE, EMAIL
}

class ChaveInvalidaException extends RuntimeException {
	public ChaveInvalidaException(String chave) {
		super(chave + " não é uma chave PIX válida");
	}
}

public class ValidaChavePIX {
	public static final String CPF_REGEX      = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
	public static final String CNPJ_REGEX     = "^\\d{2}\\.\\d{3}\\.\\d{3}\\/0{3}[12]-\\d{2}$";
	public static final String TELEFONE_REGEX = "^\\(\\d{2}\\)9?\\d{4}-\\d{4}$";
	public static final String EMAIL_REGEX    = "^[^@]+@([^@.]+\\.)+[^@.]+$";
	
	public static TipoChavePix validaChave(String chave) {
		if (chave.matches(CPF_REGEX)) {
			return TipoChavePix.CPF;
		} else if (chave.matches(CNPJ_REGEX)) {
			return TipoChavePix.CNPJ;
		} else if (chave.matches(TELEFONE_REGEX)) {
			return TipoChavePix.TELEFONE;
		} else if (chave.matches(EMAIL_REGEX)) {
			return TipoChavePix.EMAIL;
		}
		
		throw new ChaveInvalidaException(chave);
	}
	
	public static void main(String[] args) throws Exception {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Digite a chave PIX: ");
		String chave = teclado.nextLine();
		
		switch (validaChave(chave)) {
		case CPF:
			System.out.println("CPF"); 
			break;
		case CNPJ:
			System.out.println("CNPJ");
			break;
		case TELEFONE:
			System.out.println("Telefone");
			break;
		case EMAIL:
			System.out.println("Email");
			break;
		}
	}
}
