package control;

import javax.swing.JOptionPane;

import data.arquivos;

public class produto {
	private int id;
	private String nome;
	private float preco;
	private String tipo;
	private float desconto;
	private int gtin;
	private String descr;
	
	//Métodos getters e setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getDesconto() {
		return desconto;
	}

	public void setDesconto(float desconto) {
		this.desconto = desconto;
	}

	public int getGtin() {
		return gtin;
	}

	public void setGtin(int gtin) {
		this.gtin = gtin;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	public void cadastrar() {
		String produto[];
		produto = new String[8];
		produto[0] = Integer.toString(getId());
		produto[1] = getNome();
		produto[2] = Float.toString(getPreco());
		produto[3] = tipo;
		produto[4] = Float.toString(getDesconto());
		produto[5] = Integer.toString(getGtin());
		produto[6] = descr;
		produto[7] = "0";
		
		arquivos escreve = new arquivos();
		
		if(arquivos.verifID(produto[0]) == false) {
			for(int c = 0; c < 8; c++) {
				arquivos.escrever(produto[c] + "/");
			}
			arquivos.escrever("\n");
			JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}