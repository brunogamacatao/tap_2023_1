package tap_2023_1.innerclasses;

public class Aluno {
	private String nome;
	private int matricula;
	private double cra;

	public Aluno(int matricula, String nome, double cra) {
		this.matricula = matricula;
		this.nome = nome;
		this.cra = cra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public double getCra() {
		return cra;
	}

	public void setCra(double cra) {
		this.cra = cra;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", cra=" + cra + "]";
	}
}
