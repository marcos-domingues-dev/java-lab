package com.br.alura.jpa.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.br.alura.jpa.modelo.Conta;

public class TesteSelectQuery {

	public static void main(String[] args) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/alura_jpa?serverTimezone=UTC", "root",
				"root");

		String sql = "select * from conta";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		List<Conta> contas = new ArrayList<Conta>();
		while (rs.next()) {
			Conta conta = new Conta();
			conta.setId(rs.getLong("id"));
			conta.setAgencia(rs.getInt("agencia"));
			conta.setNumero(rs.getInt("numero"));
			conta.setTitular(rs.getString("titular"));
			conta.setSaldo(rs.getDouble("saldo"));
			contas.add(conta);
		}

		for (Conta conta : contas) {
			System.out.println("Titular: " + conta.getTitular() + " - Saldo: " + conta.getSaldo());
		}
	}
}
