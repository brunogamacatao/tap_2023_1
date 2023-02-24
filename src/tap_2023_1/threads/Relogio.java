package tap_2023_1.threads;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Relogio implements Runnable {
	private static final long UM_SEGUNDO = 1000;
	
	private String nome;
	private int tempoTotal;
	
	public Relogio(String nome, int tempoTotal) {
		this.nome = nome;
		this.tempoTotal = tempoTotal;
	}
	
	public void run() {
		DateFormat fmt = new SimpleDateFormat("HH:mm:ss - dd/MM/yyyy");
		
		for (int i = 0; i < tempoTotal; i++) {
			Date agora = new Date(); // pegando a data e hora atuais
			System.out.println(nome + ": " + fmt.format(agora));
			try {
				Thread.sleep(UM_SEGUNDO);
			} catch (InterruptedException ex) {}
		}
	}
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(4);
		exec.submit(new Relogio("A", 2));
		exec.submit(new Relogio("B", 5));
		exec.submit(() -> {
			System.out.println("MENSAGEM !!!!");
		});
		
		exec.shutdown();
		
        try {
			exec.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
		} catch (InterruptedException e) {
		}
        
        System.out.println("Terminou");
	}
}
