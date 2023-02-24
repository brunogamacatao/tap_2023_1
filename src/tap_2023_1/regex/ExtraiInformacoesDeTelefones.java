package tap_2023_1.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtraiInformacoesDeTelefones {
	public static final String TELEFONE_REGEX = "\\+(\\d{1,3})\\((\\d{2})\\)(\\d{4,5}-\\d{4})";
	
	public static void main(String[] args) {
		String teste = "Texto +55(83)98888-4444 mais texto +1(83)5555-2222 fim";
		
		Pattern telPattern = Pattern.compile(TELEFONE_REGEX);
		Matcher telMatcher = telPattern.matcher(teste);
		
		while (telMatcher.find()) {
			System.out.println("Encontrei um telefone: " + telMatcher.group());
			System.out.println("\tCódigo do país: " + telMatcher.group(1));
			System.out.println("\tCódigo DDD: " + telMatcher.group(2));
			System.out.println("\tTelefone: " + telMatcher.group(3).replaceAll("-", ""));
		}
	}
}
