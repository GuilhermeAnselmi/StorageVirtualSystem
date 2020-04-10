package control;

import javax.swing.JOptionPane;

public class methods {
	
	public void sair() {
		int res = 1;
		Object[] options = { "Sair", "Cancelar" };
		res = JOptionPane.showOptionDialog(null, "Deseja sair do sistema?", "Sair", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		if(res == 0) {
			System.exit(0);
		}
	}
	
	public boolean verifInt(String id) {
		boolean value = false;
		
		try {
			Integer.parseInt(id);
			System.out.println(id);
			value = true;
		} catch(Exception error) {
			JOptionPane.showMessageDialog(null, "O campo ID não pode esta vazio ou contem caracteres e pontuação\n" + 
											"O campo ID pode apenas conter numeros inteiros", 
											"Falha ao identiidicar produto", JOptionPane.ERROR_MESSAGE);
			value = false;
		}
		
		return value;
	}
}
