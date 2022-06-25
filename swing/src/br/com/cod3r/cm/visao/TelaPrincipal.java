package swing.src.br.com.cod3r.cm.visao;

import javax.swing.JFrame;

import swing.src.br.com.cod3r.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {
	TelaPrincipal(){
		Tabuleiro tabuleiro = new Tabuleiro(16,30,50);
		PainelTabuleiro painelTabuleiro = new PainelTabuleiro(tabuleiro);
		add(painelTabuleiro);
		
		setTitle("Campo minado");
		setSize(690,438);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TelaPrincipal();
	}
}
