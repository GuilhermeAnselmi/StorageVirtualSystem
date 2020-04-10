package control;

import javax.swing.JOptionPane;

public class methods {
	private int res = 1;
	
	public void sair() {	
		Object[] options = { "Sair", "Cancelar" };
		res = JOptionPane.showOptionDialog(null, "Deseja sair do sistema?", "Sair", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		if(res == 0) {
			System.exit(0);
		}
	}
}
