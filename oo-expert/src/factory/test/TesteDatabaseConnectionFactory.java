package factory.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import factory.model.DatabaseConnectionFactory;
import factory.model.TipoBanco;

public class TesteDatabaseConnectionFactory {

	public static void main(String[] args) throws SQLException {
		String envTipoBanco = System.getenv("tipoBanco");
		TipoBanco tipoBanco = TipoBanco.fromString(envTipoBanco);
		Connection c = new DatabaseConnectionFactory().getConnection(tipoBanco);
		Statement statement = c.createStatement();
		ResultSet rs = statement.executeQuery("select * from PESSOAS");

		while (rs.next()) {
			String nome = rs.getString("Nome");
			System.out.println("Nome da pessoa: " + nome);
		}
	}
}
