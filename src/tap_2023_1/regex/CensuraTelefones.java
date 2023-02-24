package tap_2023_1.regex;

public class CensuraTelefones {
	public static final String TELEFONE_REGEX = "\\(\\d{2}\\)9?\\d{4}-\\d{4}";
	
	public static void main(String[] args) {
		String texto = "Lorem ipsum dolor sit (83)98123-3211 amet, consectetur adipiscing elit. Pellentesque quis arcu a nisl convallis auctor eget at dui. Nam est nisi, tempus quis pulvinar ac, rutrum et dui. Aenean consectetur tincidunt ex vitae tristique. Aliquam egestas, dolor cursus fringilla sodales, felis felis volutpat arcu, ut malesuada neque nulla vel velit. Etiam tincidunt semper arcu, cursus gravida magna venenatis sit amet. Sed vitae interdum ex. Vivamus quis placerat risus. In hac habitasse platea dictumst. Suspendisse sagittis odio vel odio interdum euismod. Pellentesque quam sapien, aliquam efficitur cursus iaculis, scelerisque sit amet odio. Praesent ut sapien ut urna efficitur maximus ut vitae orci. Aliquam scelerisque libero in tincidunt congue. Aliquam suscipit faucibus urna, quis consequat nibh malesuada sed. Vivamus posuere ante a tellus tincidunt, in maximus ante volutpat. Suspendisse tincidunt erat a eros (81)9999-9999 congue fringilla.\n"
				+ "\n"
				+ "Quisque aliquam turpis quis eros (85)5555-4444 molestie vulputate. Nunc aliquam massa vel pharetra faucibus. Maecenas turpis dolor, ullamcorper vulputate eleifend ut, feugiat sed urna. Maecenas tortor elit, feugiat quis velit ac, tincidunt convallis eros. Nullam malesuada lacus lacinia risus gravida congue. Donec vitae convallis lectus. Pellentesque non risus ultrices arcu mollis posuere. Phasellus congue felis nec ex sollicitudin condimentum.";
		
		texto = texto.replaceAll(TELEFONE_REGEX, "***CENSURADO***");
		
		System.out.println(texto);
	}
}
