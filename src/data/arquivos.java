package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

/*
 * ESSA CLASSE AINDA ESTA EM COMPLETO DESENVOLVIMENTO
 * TODA DECLARA��O DELA FUTURAMENTE SER� TROCADA PELO ELASTICSEARCH
 * PARA PODER LIDAR COM ARQUIVOS .json
 * PORTANTO N�O IREI ME APERFEI�OAR MUITO NA DOCUMENTA��O E NA
 * ATUALIZA��O DA MESMA
 */

public class arquivos {
	
	//M�todo que faz o envio de novos dados para o arquivo .pdt
	public static void escrever(String p) {
		try {
			FileWriter produtos = new FileWriter("products.pdt", true);
			PrintWriter item = new PrintWriter(produtos);
			
			item.write(p);
			
			item.close();
			produtos.close();
		} catch(Exception erro) {
			JOptionPane.showMessageDialog(null, erro, "Erro ao Gavar Dados", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//M�todo que verifica a existencia de um ID
	public static boolean verifID(String id) {
		try {
			FileReader arq = new FileReader("products.pdt");
			BufferedReader ler = new BufferedReader(arq);
			
			String verif;
			String linha;
			try {
				linha = ler.readLine();
				while(linha != null) {
					verif = linha.split("/")[0];
					
					if(verif.equals(id)) {
						JOptionPane.showMessageDialog(null, "Ja existe um item cadastrado com esse ID: " + id, "ID Existente", JOptionPane.WARNING_MESSAGE);
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
	
	//M�todo responsavel por pegar os produtos e listar os mesmos
	public static String listar() {
		try {
			FileReader arq = new FileReader("products.pdt");
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
				JOptionPane.showMessageDialog(null, "N�o h� itens para serem lidos", "Estoque Vazio", JOptionPane.INFORMATION_MESSAGE);
			}
			return conteudo;
		} catch(Exception erro) {
			JOptionPane.showMessageDialog(null, erro, "Erro ao Ler Dados", JOptionPane.ERROR_MESSAGE);
		}
		return null;
	}
}
