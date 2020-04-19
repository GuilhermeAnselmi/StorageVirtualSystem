package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.DropMode;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;

import control.produto;
import data.database;

import javax.swing.event.ChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.beans.VetoableChangeListener;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;

public class adicionar extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNome;
	private JTextField txtPreco;
	private JTextField txtDesconto;
	private JTextField txtGtin;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adicionar frame = new adicionar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public adicionar() {
		setFont(new Font("Arial", Font.BOLD, 14));
		setTitle("Adicionar Produto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 594, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Declação do conteudo da janela de adição de produtos
		
		txtID = new JTextField();
		txtNome = new JTextField();
		txtPreco = new JTextField();
		txtDesconto = new JTextField();
		txtGtin = new JTextField();
		JComboBox<?> cmbTipo = new JComboBox();
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {null, "Ola", "Tchau"}));
		JScrollPane scrollPane = new JScrollPane();
		JTextArea txtDescr = new JTextArea();
		JCheckBox cbxVariacao = new JCheckBox("Varia\u00E7\u00E3o");
		JButton btnFinalizar = new JButton("Finalizar");
		JButton btnProximo = new JButton("Proximo");
		
		JLabel lblAdicionarProdutos = new JLabel("Adicionar Produtos");
		lblAdicionarProdutos.setFont(new Font("Arial", Font.BOLD, 16));
		lblAdicionarProdutos.setBounds(200, 11, 148, 14);
		contentPane.add(lblAdicionarProdutos);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Arial", Font.PLAIN, 14));
		lblID.setBounds(10, 56, 46, 14);
		contentPane.add(lblID);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNome.setBounds(10, 81, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblDescr = new JLabel("Descri\u00E7\u00E3o:");
		lblDescr.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDescr.setBounds(295, 56, 67, 14);
		contentPane.add(lblDescr);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTipo.setBounds(10, 108, 46, 14);
		contentPane.add(lblTipo);
		
		JLabel lblVenda = new JLabel("Pre\u00E7o Venda:");
		lblVenda.setFont(new Font("Arial", Font.PLAIN, 14));
		lblVenda.setBounds(10, 133, 86, 14);
		contentPane.add(lblVenda);
		
		JLabel lblDesconto = new JLabel("Desconto:");
		lblDesconto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDesconto.setBounds(10, 158, 67, 14);
		contentPane.add(lblDesconto);
		
		JLabel lblGtin = new JLabel("GTIN:");
		lblGtin.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGtin.setBounds(10, 185, 46, 14);
		contentPane.add(lblGtin);
		
		txtID.setBounds(104, 54, 164, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtNome.setColumns(10);
		txtNome.setBounds(104, 79, 164, 20);
		contentPane.add(txtNome);
		
		txtPreco.setColumns(10);
		txtPreco.setBounds(104, 131, 164, 20);
		contentPane.add(txtPreco);
		
		txtDesconto.setColumns(10);
		txtDesconto.setBounds(104, 156, 164, 20);
		contentPane.add(txtDesconto);
		
		txtGtin.setColumns(10);
		txtGtin.setBounds(104, 183, 164, 20);
		contentPane.add(txtGtin);
		
		cmbTipo.setBounds(104, 106, 164, 20);
		contentPane.add(cmbTipo);
		
		scrollPane.setBounds(295, 81, 250, 230);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(txtDescr);
		txtDescr.setWrapStyleWord(true);
		txtDescr.setColumns(1);
		txtDescr.setLineWrap(true);
		
		cbxVariacao.setEnabled(false);
		cbxVariacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 *Verificação da CheckBox para produtos com variação
				 * A variação para produtos ainda será desenvolvido
				 * será implementado apenas quando for concluido a etada de busca de produtos
				 * que sera feito após a etapa de desenvolvimento da adição, remoção e edição de produtos.
				 */
				if(cbxVariacao.isSelected()) {
					btnProximo.setEnabled(true);
					btnFinalizar.setEnabled(false);
				} else {
					btnProximo.setEnabled(false);
					btnFinalizar.setEnabled(true);
				}
			}
		});
		cbxVariacao.setBounds(10, 206, 97, 23);
		contentPane.add(cbxVariacao);
		
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Evento principal ao clicar para Finalizar a adição de um produto.
				String tipo = null;
				String descr = null;
				String gtin = null;
				
				//Breve verificação do campo do ComboBox
				if(cmbTipo.getSelectedItem() == null) {
					tipo = "-";
				} else {
					tipo = cmbTipo.getSelectedItem().toString();
				}
				
				if(txtGtin.getText().equals("")) {
					gtin = "0";
				} else {
					gtin = txtGtin.getText();
				}
				
				if(verif(txtID.getText(), txtNome.getText(), txtPreco.getText(), txtDesconto.getText(), gtin, txtDescr.getText())) {
					String desc = null;
					if(txtDesconto.getText().length() == 0) {
						desc = "0.0";
					} else {
						desc = txtDesconto.getText();
					}
					
					if(txtDescr.getText().length() == 0) {
						descr = "Sem informações";
					} else {
						descr = txtDescr.getText();
					}
					
					//Envio dos dados para a classe do objeto em questão (produto)
					produto item = new produto();
					
					item.setId(Integer.parseInt(txtID.getText()));
					item.setNome(txtNome.getText());
					item.setPreco(Float.parseFloat(txtPreco.getText()));
					item.setTipo(tipo);
					item.setDesconto(Float.parseFloat(desc));
					item.setGtin(Integer.parseInt(gtin));
					item.setDescr(descr);
					
					//Chama o metodo para cadastrar os produtos
					try {
						database.cadastrar();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnFinalizar.setBounds(179, 302, 89, 23);
		contentPane.add(btnFinalizar);
		
		btnProximo.setBounds(10, 302, 89, 23);
		btnProximo.setEnabled(false);
		contentPane.add(btnProximo);
	}
	
	/*
	*Método para verificação dos campos do produto
	*Aqui é verificado se todos os TextField e outros campos
	*tem os valores de seus respectivos tipos.
	*É retornado um valor booleano.
	*/
	private boolean verif(String id, String nome, String preco, String desconto, String gtin, String descr) {
		if(id.length() == 0 || nome.length() == 0 || preco.length() == 0) {
			JOptionPane.showMessageDialog(null, "Todos os campos obrigatórios devem estar preenchidos", "Preenchimento Obrigatório", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {	
			try {
				Integer.parseInt(id);
				Float.parseFloat(preco);
				
				if(!desconto.equals("")) {
					Float.parseFloat(desconto);
				}
				
				if(!gtin.equals("")) {
					Integer.parseInt(gtin);
				}
				return true;
			} catch(Exception error) {
				JOptionPane.showMessageDialog(null, "Os campos ID, Preço, Desconto, GTIN devem conter valores numericos ou nenhum valor\nO ID e GTIN não podem conter ponto ou virgula", "Erro de Tipo", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
	}
}
