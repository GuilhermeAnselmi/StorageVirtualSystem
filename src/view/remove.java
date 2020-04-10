package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.arquivos;
import control.methods;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class remove extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtProd;
	private JTextField txtPreco;
	private JTextField txtQuant;
	private JTextField txtGtin;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
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
		
		btnVerif.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				methods verificar = new methods();
				verificar.verifInt(txtID.getText());
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
		
		JButton btnExcluir = new JButton("Excluir");
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
	}
}
