package br.com.apoio.bo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.apoio.model.Desenvolvedor;

public class DesenvolvedorDAO {
	Desenvolvedor dev = new Desenvolvedor();
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	MySQLAccess msql = new MySQLAccess();
	
	String status = null;
	public String InsertDataBase(Desenvolvedor dev) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connect = DriverManager.getConnection("jdbc:mysql://localhost/feedback?"
                    + "user=root&password=123");
			//Parametros 
			preparedStatement = connect.prepareStatement("insert into feedback.dev values (?,?,?)");
			//Dados dos Parâmetros
			preparedStatement.setString(1, dev.getNome());
			preparedStatement.setString(2, dev.getSetor());
			preparedStatement.setDouble(3, dev.getSalario());
			preparedStatement.executeUpdate();
			
			return "sucesso";
		}catch(Exception e) {
			throw e;
			
		}finally {
			msql.close();
		}
	}
	public String DeleteData(String nome) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connect = DriverManager.getConnection("jdbc:mysql://localhost/feedback?"
                    + "user=root&password=123");
			//Parametros 
			preparedStatement = connect.prepareStatement("delete from feedback.dev where nome = ? ");
			//Dados dos Parâmetros
			preparedStatement.setString(1, nome);
			preparedStatement.executeUpdate();
			return "sucesso";
		}catch(Exception e) {
			throw e;
			
		}finally {
			msql.close();
		}
	}
	public String UpdateData(String nome, double salario) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connect = DriverManager.getConnection("jdbc:mysql://localhost/feedback?"
                    + "user=root&password=123");
			//Parametros 
			preparedStatement = connect.prepareStatement("update dev set salario = ? where nome = ?");
			//Dados dos Parâmetros
			preparedStatement.setDouble(1, salario);
			preparedStatement.setString(2, nome);
			preparedStatement.executeUpdate();
			return "sucesso";
		}catch(Exception e) {
			throw e;
			
		}finally {
			msql.close();
		}
	}
	
}
