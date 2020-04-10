package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.arquivos;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class remove extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnviar;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEnviar = new JTextField();
		txtEnviar.setBounds(10, 11, 86, 20);
		contentPane.add(txtEnviar);
		txtEnviar.setColumns(10);
		
		JButton btnEnviar = new JButton("Enviar");
		
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arquivos ler = new arquivos();
				System.out.print(arquivos.verifID("5"));
			}
		});
		btnEnviar.setBounds(7, 69, 89, 23);
		contentPane.add(btnEnviar);
	}
}
