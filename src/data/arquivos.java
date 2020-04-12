package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import control.produto;

import javax.swing.JOptionPane;

/*
 * ESSA CLASSE AINDA ESTA EM COMPLETO DESENVOLVIMENTO
 * TODA DECLARAÇÃO DELA FUTURAMENTE SERÁ TROCADA PELO ELASTICSEARCH
 * PARA PODER LIDAR COM ARQUIVOS .json
 * PORTANTO NÃO IREI ME APERFEIÇOAR MUITO NA DOCUMENTAÇÃO E NA
 * ATUALIZAÇÃO DA MESMA
 */

public class arquivos {
	
	//Método que faz o envio de novos dados para o arquivo .pdt
	public static void escrever(String p) {
		try {
			FileWriter produtos = new FileWriter("data/products.pdt", true);
			PrintWriter item = new PrintWriter(produtos);
			
			item.write(p);
			
			item.close();
			produtos.close();
		} catch(Exception erro) {
			JOptionPane.showMessageDialog(null, erro, "Erro ao Gavar Dados", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//Método que verifica a existencia de um ID
	public static boolean verifNotID(String id) {
		try {
			FileReader arq = new FileReader("data/products.pdt");
			BufferedReader ler = new BufferedReader(arq);
			
			String verif;
			String linha;
			try {
				linha = ler.readLine();
				while(linha != null) {
					verif = linha.split("/")[0];
					
					if(verif.equals(id)) {
						arq.close();
						ler.close();
						return true;
					}
					
					linha = ler.readLine();
				}
				
				arq.close();
				ler.close();
				
				return false;
			} catch(Exception erro) {
				JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
				return true;
			}
		} catch(Exception erro) {
			JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			return true;
		}
	}
	
	
	
	
	
	
	/*
	 * Os proximos 4 metodos são métodos para retornar as caracteristicas para 
	 * a janela de remoção
	 */
	public static String procurarNome(String id) {
		try {
			FileReader arq = new FileReader("data/products.pdt");
			BufferedReader ler = new BufferedReader(arq);
			
			String verif;
			String linha;
			
			String nome;
			
			try {
				linha = ler.readLine();
				while(linha != null) {
					verif = linha.split("/")[0];
					
					if(verif.equals(id)) {
						nome = linha.split("/")[1];
						
						return nome;
					}
					
					linha = ler.readLine();
				}
				
				arq.close();
				ler.close();
			} catch(Exception erro) {
				JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
				return null;
			}
		} catch(Exception erro) {
			JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		return null;
	}
	
	public static String procurarPreco(String id) {
		try {
			FileReader arq = new FileReader("data/products.pdt");
			BufferedReader ler = new BufferedReader(arq);
			
			String verif;
			String linha;
			
			String preco;
			
			try {
				linha = ler.readLine();
				while(linha != null) {
					verif = linha.split("/")[0];
					
					if(verif.equals(id)) {
						preco = linha.split("/")[2];
						
						return preco;
					}
					
					linha = ler.readLine();
				}
				
				arq.close();
				ler.close();
			} catch(Exception erro) {
				JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
				return null;
			}
		} catch(Exception erro) {
			JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		return null;
	}
	
	public static String procurarGtin(String id) {
		try {
			FileReader arq = new FileReader("data/products.pdt");
			BufferedReader ler = new BufferedReader(arq);
			
			String verif;
			String linha;
			
			String gtin;
			
			try {
				linha = ler.readLine();
				while(linha != null) {
					verif = linha.split("/")[0];
					
					if(verif.equals(id)) {
						gtin = linha.split("/")[5];
						
						return gtin;
					}
					
					linha = ler.readLine();
				}
				
				arq.close();
				ler.close();
			} catch(Exception erro) {
				JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
				return null;
			}
		} catch(Exception erro) {
			JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		return null;
	}
	
	public static String procurarQuant(String id) {
		try {
			FileReader arq = new FileReader("data/products.pdt");
			BufferedReader ler = new BufferedReader(arq);
			
			String verif;
			String linha;
			
			String quant;
			
			try {
				linha = ler.readLine();
				while(linha != null) {
					verif = linha.split("/")[0];
					
					if(verif.equals(id)) {
						quant = linha.split("/")[7];
						
						return quant;
					}
					
					linha = ler.readLine();
				}
				
				arq.close();
				ler.close();
			} catch(Exception erro) {
				JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
				return null;
			}
		} catch(Exception erro) {
			JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		return null;
	}
	//Fim dos métodos da janela de remoção
	
	
	
	
	//Método responsavel por pegar os produtos e listar os mesmos
	public static String listar() {
		try {
			FileReader arq = new FileReader("data/products.pdt");
			BufferedReader ler = new BufferedReader(arq);
			
			String conteudo = "";
			String linha;
			try {
				linha = ler.readLine();
				while(linha != null) {
					conteudo += linha + "\n";
					linha = ler.readLine();
				}
				
				arq.close();
				ler.close();
			} catch(Exception erro) {
				JOptionPane.showMessageDialog(null, "Não há itens para serem lidos", "Estoque Vazio", JOptionPane.INFORMATION_MESSAGE);
			}
			return conteudo;
		} catch(Exception erro) {
			JOptionPane.showMessageDialog(null, erro, "Erro ao Ler Dados", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
	
	public static boolean excluirItem(String id) {
		try {
			FileReader arq = new FileReader("data/products.pdt");
			BufferedReader ler = new BufferedReader(arq);
			
			String verif;
			String linha;
			try {
				linha = ler.readLine();
				while(linha != null) {
					verif = linha.split("/")[0];
					
					if(verif.equals(id)) {
						linha = "";
						
						arq.close();
						ler.close();
						
						return true;
					}
					
					linha = ler.readLine();
				}
				
				arq.close();
				ler.close();
				
				return false;
			} catch(Exception erro) {
				JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
				return true;
			}
		} catch(Exception erro) {
			JOptionPane.showMessageDialog(null, erro, "Erro", JOptionPane.ERROR_MESSAGE);
			return true;
		}
	}
}
