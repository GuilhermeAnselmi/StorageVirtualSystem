package control;

import javax.swing.JOptionPane;

import data.arquivos;

//Classe objeto produto
public class produto {
	private static int id;
	private static String nome;
	private static float preco;
	private static String tipo;
	private static float desconto;
	private static int gtin;
	private static String descr;
	private static int quant;
	
	//Métodos getters e setters
	
	public static int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public static String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public static String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public static float getDesconto() {
		return desconto;
	}
	
	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}
	
	public static int getGtin() {
		return gtin;
	}
	
	public void setGtin(int gtin) {
		this.gtin = gtin;
	}
	
	public static String getDescr() {
		return descr;
	}
	
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	public static int getQuant() {
		return quant;
	}
	
	public void setQuant(int quant) {
		this.quant = quant;
	}
}