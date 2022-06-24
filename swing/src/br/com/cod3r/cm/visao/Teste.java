package swing.src.br.com.cod3r.cm.visao;

import swing.src.br.com.cod3r.cm.modelo.Tabuleiro;

public class Teste {
	public static void main(String[] args) {
		Tabuleiro tabuleiro = new Tabuleiro(3,3,9);
		System.out.println("A");
		tabuleiro.abrir(2,2);
		System.out.println("A");
//		tabuleiro.registrarObservador(e -> {
//			if(e.isGanhou())) {
//				System.out.println("Ganhou!");
//			} else {
//				System.out.println("Perdeu!");
//			}
//		});
	}
}
