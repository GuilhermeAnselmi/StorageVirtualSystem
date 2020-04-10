package control;

import javax.swing.JOptionPane;

import data.arquivos;

//Classe objeto produto
public class produto {
	private int id;
	private String nome;
	private float preco;
	private String tipo;
	private float desconto;
	private int gtin;
	private String descr;
	private int quant;
	
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
		return this.preco;
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
	
	public int getQuant() {
		return quant;
	}
	
	public void setQuant(int quant) {
		this.quant = quant;
	}
	
	//Método de conversão e envio dos dados para um arquivo .pdt (criado por mim)
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
		
		//Aqui é feito o envio dos dados um de cada vez, seja ele algum valor, caracter ou nulo (0)
		if(arquivos.verifNotID(produto[0]) == false) {
			for(int c = 0; c < 8; c++) {
				arquivos.escrever(produto[c] + "/");
			}
			arquivos.escrever("\n");
			JOptionPane.showMessageDialog(null, "Item cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Ja existe um item cadastrado com esse ID: " + produto[0], "ID Existente", JOptionPane.WARNING_MESSAGE);
		}
	}
}