package swing.src.br.com.cod3r.cm.visao;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
//import javax.swing.JButton;	
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import swing.src.br.com.cod3r.cm.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel {
	public PainelTabuleiro(Tabuleiro tabuleiro){ 
		setLayout(new GridLayout(tabuleiro.getLinhas(),tabuleiro.getColunas()));
		
		tabuleiro.paraCada(c -> add(new BotaoCampo(c)));
		
		tabuleiro.registrarObservador(e -> {
			
			SwingUtilities.invokeLater(() -> {
				if(e.isGanhou()) {
					//FIXME  verei o que falta depois olhando codigo fonte do curso pq nao entendi pq ficou faltando. Talvez pulei sem querer
					JOptionPane.showMessageDialog(this,"Ganhou!");
				} else {
					JOptionPane.showMessageDialog(this,"Perdeu!");
				}
				
			});

			tabuleiro.reiniciar();
		});
		
//		int total = (tabuleiro.getLinhas() * tabuleiro.getColunas());
//		
//		for (int i = 0 ; i < total; i++) {
//			add(new BotaoCampo());
//		}
	}

}
