package br.com.apoio.bo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class MySQLAccess {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	public String readDataBase() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connect = DriverManager.getConnection("jdbc:mysql://localhost/feedback?"
                    + "user=root&password=123");
			
			statement = connect.createStatement();
			
			resultSet = statement.executeQuery("select * from feedback.comments");
			
			return "sucesso";
		}catch(Exception e) {
			throw e;
			
		}finally {
			close();
		}
	}
	

	public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }


	
	
}

