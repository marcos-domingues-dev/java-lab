package factory.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionFactory {

	public Connection getConnection(TipoBanco tipoBanco) {
		String url = "jdbc:<TipoBanco>://localhost:3306/banco";
		String user = "admin";
		String password = "1234";

		switch (tipoBanco) {
		case MYSQL:
			url = url.replaceFirst("<TipoBanco>", "mysql");
			break;
		case POSTGRES:
			url = url.replaceFirst("<TipoBanco>", "postgres");
			break;
		case ORACLE:
			url = url.replaceFirst("<TipoBanco>", "oracle");
			break;
		default:
			url = url.replaceFirst("<TipoBanco>", "mysql");
		}

		try {
			return DriverManager.getConnection(url, user, password);
		} catch (Exception ex) {
			throw new RuntimeException("Erro na conexão");
		}
	}
}
