package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class connection {
	private static Connection con;
	
	public void connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:C:/Users/Invictus/eclipse-workspace/StorageVirtualSystem/db/vssDB.db";
			
			con = DriverManager.getConnection(url);
			System.out.println("Conectado com sucesso!");
		} catch(Exception error) {
			System.out.println("Connection error: " + error);
		}
	}
	
	public Connection getCon() {
		return con;
	}
	
	public boolean desconnection() {
		try {
			
			if(con.isClosed() == false) {
				con.isClosed();
			}
			
			System.out.println("Desconectado com sucesso!");
			
			return true;
		} catch(Exception error) {
			System.out.println("Connection error: " + error);
			
			return false;
		}
	}
	
	public static PreparedStatement iserirDado(String sql) {
		try {
			return con.prepareStatement(sql);
		} catch(Exception error) {
			System.out.println("Connection error: " + error);
			return null;
		}
	}
}
