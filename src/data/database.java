package data;

import control.produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import data.connection;
import control.produto;

public class database {
	
	public static void cadastrar() throws SQLException{
		connection connect = new connection();
		connect.connect();
		
		String insert = "insert into produto(id, nome, preco, tipo, desconto, gtin, descricao, quantidade)"
						+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement ps = connection.iserirDado(insert);
		
		try {
			System.out.println(produto.getPreco());
			
			ps.setInt(1, produto.getId());
			ps.setString(2, produto.getNome());
			ps.setFloat(3, produto.getPreco());
			ps.setString(4, produto.getTipo());
			ps.setFloat(5, produto.getDesconto());
			ps.setInt(6, produto.getGtin());
			ps.setString(7, produto.getDescr());
			ps.setInt(8, produto.getQuant());
			
			int res = ps.executeUpdate();
			
			if(res == 1) {
				JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
			} else if (res == 0) {
				JOptionPane.showMessageDialog(null, "Dado não inserido:\nErro desconhecido", "Falha na inserção", JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception error) {
			JOptionPane.showMessageDialog(null, error, "ERRO", JOptionPane.ERROR_MESSAGE);
		} finally {
			if(ps != null) {
				ps.close();
			}
		}
		
		connect.desconnection();
	}
}
