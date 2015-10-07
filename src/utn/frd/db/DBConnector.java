package utn.frd.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/test";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";
	
	private static Connection connection = null;

	public static Connection getConnection(){
		System.out.println("***Comenzando conección con MySQL***");

		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.err.println("No se encuentra el JDBC para MySQL");
			e.printStackTrace();
			return connection;
		}

		System.out.println("MySQL JDBC Driver registrado!");
		connection = null;

		try {
			connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
		} catch (SQLException e) {
			System.out.println("Falló la conección");
			e.printStackTrace();
			return connection;
		}

		if (connection != null) {
			System.out.println("Conectado a la base de datos!");
		} else {
			System.out.println("Conección fallida");
		}
		
		return connection;
	}
}
