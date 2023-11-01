package fr.einfolearning.employee_crud.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {

	private static Connection connection = null;
        
	
	public static Connection getInstance()
	{
		if (connection == null) {
		try
		{       /*
                         On deactive SSL pour eviter l'erreur
                    at org.postgresql.ssl.jdbc4.AbstractJdbc4MakeSSL.convert(AbstractJdbc4MakeSSL.java:126)
                    sur le serveur Tomcat (dans un container Docker)
                    */
			String dbURL = "jdbc:postgresql://127.0.0.1:5432/devavance_db?sslmode=disable"; // PostgreSQL 
                        //String dbURL = "jdbc:postgresql://postgresql:5432/devavance_db?sslmode=disable"; // PostgreSQL 
			String userName = "devavance_user";
			String password = "passwordd";
						
			
			//Load JDBC Driver
			Class.forName("org.postgresql.Driver");
			
			//Open Connection to MySql Employee DB
			connection = DriverManager.getConnection(dbURL, userName, password);
			
			//Condition to make sure connection is established.
			if( connection != null) 
			{
				System.out.println("Connected !");
			}
			else
			{
				System.out.println("Not Connected !");
			}		
			return connection;
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
			return null;
		}
		}
		
		return connection;
	}
	
	public static void main(String[] args) {
		DBConnection.getInstance();
	}
}
