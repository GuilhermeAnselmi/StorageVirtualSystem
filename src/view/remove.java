package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.arquivos;
import control.methods;
import control.produto;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class remove extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtProd;
	private JTextField txtPreco;
	private JTextField txtQuant;
	private JTextField txtGtin;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					remove frame = new remove();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Interface de remoção dos itens
	public remove() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 319, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtID = new JTextField();
		txtID.setBounds(63, 11, 118, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		JButton btnVerif = new JButton("Verificar");
		JButton btnExcluir = new JButton("Excluir");
		JButton btnCancelar = new JButton("Cancelar");
		
		btnVerif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Chama o método para verificar se o valor no campo ID é inteiro;
				methods verificar = new methods();
				if(verificar.verifInt(txtID.getText())) {
					
					//Chama o método conclusão para mostrar se é o produto que deve ser excluido
					if(conclusão(txtID.getText())) {
						btnVerif.setEnabled(false);
						txtID.setEnabled(false);
						btnExcluir.setEnabled(true);
					}
				}
			}
		});
		btnVerif.setBounds(204, 10, 89, 23);
		contentPane.add(btnVerif);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(7, 14, 46, 14);
		contentPane.add(lblId);
		
		JLabel lblNome = new JLabel("Produto:");
		lblNome.setBounds(7, 116, 46, 14);
		contentPane.add(lblNome);
		
		txtProd = new JTextField();
		txtProd.setEditable(false);
		txtProd.setColumns(10);
		txtProd.setBounds(75, 113, 118, 20);
		contentPane.add(txtProd);
		
		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setBounds(7, 141, 46, 14);
		contentPane.add(lblPreo);
		
		txtPreco = new JTextField();
		txtPreco.setEditable(false);
		txtPreco.setColumns(10);
		txtPreco.setBounds(75, 138, 118, 20);
		contentPane.add(txtPreco);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(7, 166, 60, 14);
		contentPane.add(lblQuantidade);
		
		txtQuant = new JTextField();
		txtQuant.setEditable(false);
		txtQuant.setColumns(10);
		txtQuant.setBounds(75, 163, 118, 20);
		contentPane.add(txtQuant);
		
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methods metodo = new methods();
				
				if(metodo.confirm("Excluir", "Cancelar", "Isso excluira totalmente o item do seu sistema,\n e não terá como recupera-lo\nDeseja prosseguir?")) {
					arquivos.excluirItem(txtID.getText());
				}
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(204, 190, 89, 23);
		contentPane.add(btnExcluir);
		
		txtGtin = new JTextField();
		txtGtin.setEditable(false);
		txtGtin.setColumns(10);
		txtGtin.setBounds(75, 191, 118, 20);
		contentPane.add(txtGtin);
		
		JLabel lblGtin = new JLabel("GTIN:");
		lblGtin.setBounds(7, 191, 60, 14);
		contentPane.add(lblGtin);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExcluir.setEnabled(false);
				btnVerif.setEnabled(true);
				txtID.setEnabled(true);
				txtProd.setText("");
				txtPreco.setText("");
				txtQuant.setText("");
				txtGtin.setText("");
			}
		});
		btnCancelar.setBounds(204, 60, 89, 23);
		contentPane.add(btnCancelar);
	}
	
	//Método para procurar o item e retornar o valor que foi adicionado no objeto para o TextField
	private boolean conclusão(String id) {
		boolean value = false;
		
		if(arquivos.verifNotID(id) == false) {
			JOptionPane.showMessageDialog(null, "Esse ID não existe nos registros", "ID Inexistente", JOptionPane.ERROR_MESSAGE);
			value = false;
		} else {
			String nome = arquivos.procurarNome(txtID.getText());
			String preco = arquivos.procurarPreco(txtID.getText());
			String gtin = arquivos.procurarGtin(txtID.getText());
			String quant = arquivos.procurarQuant(txtID.getText());
			
			txtProd.setText(nome);
			txtPreco.setText(preco);
			txtQuant.setText(quant);
			txtGtin.setText(gtin);
			
			value = true;
		}
		
		return value;
	}
}
