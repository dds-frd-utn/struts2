package utn.frd.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utn.frd.bean.Person;

/*
	CREATE TABLE Persons
	(
	PersonID int,
	LastName varchar(255),
	FirstName varchar(255),
	Address varchar(255),
	City varchar(255)
	);
*/

public class DBPersonManager {

	public static void getAll() throws SQLException{
		Connection connection = null;
		Statement statement = null;
		
		String selectTableSQL = "SELECT PersonID, LastName, FirstName, Address, City from Persons";

		try {
			connection = DBConnector.getConnection();
			statement = connection.createStatement();

			System.out.println("CORRIENDO SQL: "+selectTableSQL);

			// ejecutar la consula SQL
			ResultSet rs = statement.executeQuery(selectTableSQL);

			while (rs.next()) {

				String personId = rs.getString("PersonID");
				String name = rs.getString("FirstName") + " " + rs.getString("LastName");
				String address = rs.getString("Address") + ", " + rs.getString("City");

				System.err.println("Persona ID: " + personId);
				System.out.println("Nombre: " + name);
				System.out.println("Direccion: " + address);

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}

		}
	}

	public static void add(Person person) throws SQLException{
		Connection connection = null;
		PreparedStatement statement = null;

		String sql = "INSERT INTO Persons "
				+ "(PersonID, LastName, FirstName, Address, City) VALUES"
				+ "(?,?,?,?,?)";

		try{
			System.out.println("CORRIENDO SQL: "+sql);

			connection = DBConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, person.getId());
			statement.setString(2, person.getLastName());
			statement.setString(3, person.getFirstName());
			statement.setString(4, person.getStreet());
			statement.setString(5, person.getCity());
			statement.executeUpdate(); 
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			connection.rollback();

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}

		}
	}
	
	public static void update(Person person) throws SQLException{
		String sql = "UPDATE Persons SET LastName=?, FirstName=?, Address=?, City=? "
					+ "WHERE PersonID=?";

		Connection connection = null;
		PreparedStatement statement = null;

		try{
			System.out.println("CORRIENDO SQL: "+sql);
			connection = DBConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, person.getLastName());
			statement.setString(2, person.getFirstName());
			statement.setString(3, person.getStreet());
			statement.setString(4, person.getCity());
			statement.setInt(5, person.getId());
			statement.executeUpdate(); 

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			connection.rollback();

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}

		}
	}

	
	public static void deleteAll() throws SQLException{
		String sql = "DELETE FROM Persons";

		Connection connection = null;
		PreparedStatement statement = null;

		try{
			System.out.println("CORRIENDO SQL: "+sql);
			connection = DBConnector.getConnection();
			statement = connection.prepareStatement(sql);
			statement.executeUpdate(); 

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			connection.rollback();

		} finally {

			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}

		}
	}

}
