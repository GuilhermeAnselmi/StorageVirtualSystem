package control;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class methods {
	
	/*
	 * Método para sair do sistema com segurança
	 * Ainda será implementado uma verificação para fazer o fechamento correto do sistema
	 * fechando todos os arquivos e verificando se não terá nenhum arquivo prejudicado com o fechamento
	 */
	public void sair() {
		int res = 1;
		Object[] options = { "Sair", "Cancelar" };
		res = JOptionPane.showOptionDialog(null, "Deseja realmente fechar o sistema?", "Sair", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		if(res == 0) {
			try {
				FileReader arq = new FileReader("data/products.pdt");
				BufferedReader ler = new BufferedReader(arq);
			
				arq.close();
				ler.close();
				
				System.exit(0);
			} catch(Exception error) {
				JOptionPane.showMessageDialog(null, error, "Erro", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	//Método de criação de janela de confirmação generica
	public boolean confirm(String ir, String voltar, String msg) {
		int res = 1;
		Object[] options = { ir, voltar };
		res = JOptionPane.showOptionDialog(null, msg, ir, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		if(res == 0) {
			return true;
		}
		
		return false;
	}
	
	//Método que verifica se o valor é inteiro
	public boolean verifInt(String valor) {
		boolean value = false;
		
		try {
			Integer.parseInt(valor);
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
