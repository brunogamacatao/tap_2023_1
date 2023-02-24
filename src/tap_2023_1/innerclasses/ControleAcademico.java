package tap_2023_1.innerclasses;

import java.util.ArrayList;
import java.util.List;

public class ControleAcademico {
	public static void main(String[] args) {
		List<Aluno> alunos = new ArrayList<>();
		
		alunos.add(new Aluno(333, "Pedro", 5.5));
		alunos.add(new Aluno(555, "Ana", 10.0));
		alunos.add(new Aluno(111, "Maria", 8.5));
		alunos.add(new Aluno(666, "Lúcio", 5.0));
		alunos.add(new Aluno(222, "Antônio", 9.5));
		alunos.add(new Aluno(444, "Carlos", 10.0));
		
		alunos.stream()
		.filter((a) -> a.getCra() >= 7.0)
		.sorted((a1, a2) -> Double.compare(a2.getCra(), a1.getCra()))
		.forEach(System.out::println); // (a) -> System.out.println(a)
	}
}
