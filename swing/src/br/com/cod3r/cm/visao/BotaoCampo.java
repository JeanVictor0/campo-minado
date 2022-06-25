package swing.src.br.com.cod3r.cm.visao;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import swing.src.br.com.cod3r.cm.modelo.Campo;
import swing.src.br.com.cod3r.cm.modelo.CampoEvento;
import swing.src.br.com.cod3r.cm.modelo.CampoObservador;

@SuppressWarnings("serial")
public class BotaoCampo extends JButton implements CampoObservador, MouseListener{
	private final Color BG_PADRAO = new Color(184,184,184);
	private final Color BG_MARCADO = new Color(8,179,249);
	private final Color BG_EXPLOSAO = new Color(184,66,68);
	private final Color TEXTO_VERDE = new Color(0,100,0);
	
	private Campo campo;
	
	public BotaoCampo(Campo campo) {
		this.campo = campo;
		setBorder(BorderFactory.createBevelBorder(0));
		setBackground(BG_PADRAO);
		addMouseListener(this);
		
		campo.registrarObservador(this);
		
	}
	
	public void eventoOcorreu(Campo campo, CampoEvento evento) {
		setBackground(BG_PADRAO);
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		switch(evento) {
		case ABRIR:
			aplicarEstiloAbrir();
			break;
			
		case MARCAR:
			aplicarEstiloMarcar();
			break;
			
		case EXPLODIR:
			aplicarEstiloExplodir();
			break;
			
		default:
			aplicarEstiloPadrao();
		}
		
		
		
	}

	private void aplicarEstiloPadrao() {
		setBackground(BG_PADRAO);
		setText("");
		
	}

	private void aplicarEstiloExplodir() {
		setBackground(BG_EXPLOSAO);
		setForeground(Color.BLACK);
		setText("X");
		
	}

	private void aplicarEstiloMarcar() {
		setBackground(BG_MARCADO);
		setText("M");
		
	}

	private String aplicarEstiloAbrir() {
		
		if (campo.isMinado()) {
			setBackground(BG_EXPLOSAO);
			return "";
		}
		setBackground(BG_EXPLOSAO);
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		switch ((int)campo.minasNaVizinhanca()) {
		case 1:
			setForeground(TEXTO_VERDE);
			break;
		case 2:
			setForeground(Color.BLUE);
			break;
		case 3:
			setForeground(Color.YELLOW);
			break;
		case 4: case 5: case 6:
			setForeground(Color.RED);
			break;
		default:
			setForeground(Color.PINK);
			break;
		}
		String valor = !campo.vizinhancaSegura() ? campo.minasNaVizinhanca() + "" : "";
		return valor;
	}

	// TODO interface dos eventos do mouse
	
	
	
	public void mouseClicked(MouseEvent e) {	
		if (e.getButton() == 1) {
			campo.abrir();
		} else {
			System.out.println("Outro evento");
			campo.alterarMarcacao();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
